package com.springtest.ws.service.impl;

import com.springtest.ws.entity.UserEntity;
import com.springtest.ws.exceptions.UserServiceException;
import com.springtest.ws.io.repositories.UserRepository;
import com.springtest.ws.service.UserService;
import com.springtest.ws.shared.Utils;
import com.springtest.ws.shared.dto.UserDto;
import com.springtest.ws.ui.model.request.UserLoginRequestModel;
import com.springtest.ws.ui.model.response.ErrorMessages;
import io.jsonwebtoken.lang.Assert;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    Utils utils;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDto createUser(UserDto user) {

        if(userRepository.findByEmail(user.getEmail()) != null) throw new RuntimeException("Record already exists");

        UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties(user, userEntity);

        String publicUserId = utils.generateUserId(30);
        userEntity.setEncryptedPassword(bCryptPasswordEncoder.encode("12345678"));
        userEntity.setUserId(publicUserId);

        UserEntity storedUserDetails = userRepository.save(userEntity);

        UserDto returnValue = new UserDto();
        BeanUtils.copyProperties(storedUserDetails, returnValue);

        return returnValue;
    }

    @Override
    public UserDto getUser(String email) {
        UserEntity userEntity = userRepository.findByEmail(email);

        if(userEntity == null) throw new UsernameNotFoundException(email);
        
        UserDto returnValue = new UserDto();
        BeanUtils.copyProperties(userEntity, returnValue);
        return returnValue;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserEntity userEntity = userRepository.findByEmail(email);

        if(userEntity == null) throw new UsernameNotFoundException(email);

        return new User(userEntity.getEmail(), userEntity.getEncryptedPassword(), new ArrayList<>());
    }

    @Override
    public UserDto getUserByUserId(String userId) {
        UserDto returnValue = new UserDto();
        UserEntity userEntity = userRepository.findByUserId(userId);

        if(userEntity == null) throw new UsernameNotFoundException("User with the ID: " + userId + " not found!");

        BeanUtils.copyProperties(userEntity, returnValue);

        return returnValue;
    }

    @Override
    public UserDto updateUser(String userId, UserDto user) {
        UserDto returnValue = new UserDto();
        UserEntity userEntity = userRepository.findByUserId(userId);

        if(userEntity == null)
            throw new UserServiceException(ErrorMessages.NO_RECORD_FOUND.getErrorMessage());

        userEntity.setFirstName(user.getFirstName());
        userEntity.setLastName(user.getLastName());
        userEntity.setCity(user.getCity());
        userEntity.setCountry(user.getCountry());
        userEntity.setDob(user.getDob());
        userEntity.setCity(user.getCity());
        userEntity.setGender(user.getGender());
        userEntity.setMobile(user.getMobile());
        userEntity.setPostalAddress(user.getPostalAddress());
        userEntity.setPostalCode(user.getPostalCode());
        userEntity.setState(user.getState());
        userEntity.setTitle(user.getTitle());
        userEntity.setType(user.getType());

        UserEntity updatedUserDetails = userRepository.save(userEntity);

        BeanUtils.copyProperties(updatedUserDetails, returnValue);
        
        return returnValue;
    }

    @Override
    public void deleteUser(String userId) {
        UserEntity userEntity = userRepository.findByUserId(userId);

        if(userEntity == null)
            throw new UserServiceException(ErrorMessages.NO_RECORD_FOUND.getErrorMessage());

        userRepository.delete(userEntity);
    }

    @Override
    public List<UserDto> getUsers(int page, int limit) {
        List<UserDto> returnValue = new ArrayList<>();

        if(page > 0) page -= 1;

        Pageable pageableRequest = PageRequest.of(page, limit);

        Page<UserEntity> usersPage = userRepository.findAll(pageableRequest);
        List<UserEntity> users = usersPage.getContent();

        for(UserEntity userEntity: users) {
            UserDto userDto = new UserDto();
            BeanUtils.copyProperties(userEntity, userDto);
            returnValue.add(userDto);
        }
        return returnValue;
    }

    @Override
    public List<UserEntity> getUsersByLastName(String lastName) {
        List<UserEntity> returnValue = userRepository.findAllByLastName(lastName);
        return returnValue;
    }

    @Override
    public UserDto authenticate(UserLoginRequestModel userLoginRequestModel) {
        Assert.notNull(userLoginRequestModel, "cannot continue with empty credentials.");
        final String username = userLoginRequestModel.getEmail();


// agentauth client
        final UserEntity userEntity = this.userRepository.findByEmail(username);

        if (userEntity == null)
            throw new RuntimeException("We could not authenticate. User does not exist.");

// if password is empty ask the user to reset the password
        if (Objects.isNull(userEntity.getEncryptedPassword())) {
            userEntity.setEmailVerificationStatus(false);
            userRepository.save(userEntity);

            throw new RuntimeException("Please reset your password.");
        }

// check if password matches
        if (!bCryptPasswordEncoder.matches(userLoginRequestModel.getPassword(), userEntity.getEncryptedPassword())) {

            throw new RuntimeException("We could not authenticate. Wrong password!");
        }

        UserDto returnValue = new UserDto();
        BeanUtils.copyProperties(userEntity, returnValue);


// set last logged in

        userRepository.save(userEntity);

        return returnValue;
    }

}
