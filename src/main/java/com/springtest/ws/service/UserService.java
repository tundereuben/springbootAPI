package com.springtest.ws.service;

import com.springtest.ws.entity.UserEntity;
import com.springtest.ws.shared.dto.UserDto;
import com.springtest.ws.ui.model.request.UserLoginRequestModel;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {
    UserDto createUser(UserDto user);
    UserDto getUser(String email);
    UserDto getUserByUserId(String userId);
    UserDto updateUser(String userId, UserDto user);
    void deleteUser(String userId);
    List<UserDto> getUsers(int page, int limit);
    List<UserEntity> getUsersByLastName(String lastName);
    UserDto authenticate(UserLoginRequestModel userLoginRequestModel);
}
