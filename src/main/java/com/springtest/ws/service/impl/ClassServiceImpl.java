package com.springtest.ws.service.impl;

import com.springtest.ws.entity.ClassEntity;
import com.springtest.ws.io.repositories.ClassRepository;
import com.springtest.ws.service.ClassService;
import com.springtest.ws.shared.dto.ClassDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClassServiceImpl implements ClassService {
                                
    @Autowired
    ClassRepository classRepository;

    @Override
    public ClassDto createClass(ClassDto _class) {

//        ClassEntity storedClassDetails = classRepository.findByClaCode(_class.getClaCode());

        if(classRepository.findByClaCode(_class.getClaCode()) != null) throw new RuntimeException("Record already exist");

        ClassEntity classEntity = new ClassEntity();
        BeanUtils.copyProperties(_class, classEntity);

        ClassEntity storedClassDetails = classRepository.save(classEntity);

        ClassDto returnValue = new ClassDto();
        BeanUtils.copyProperties(storedClassDetails, returnValue);

        return returnValue;
    }

    @Override
    public ClassDto getClassByClassCode(int claCode) {
        ClassDto returnValue = new ClassDto();
        ClassEntity classEntity = classRepository.findByClaCode(claCode);
        
        BeanUtils.copyProperties(classEntity, returnValue);
        
        return returnValue;
    }

    @Override
    public ClassDto updateClass(int claCode, ClassDto _class) {
        ClassDto returnValue = new ClassDto();
        ClassEntity classEntity = classRepository.findByClaCode(claCode);

        classEntity.setClaDesc(_class.getClaDesc());
        classEntity.setClaShtDesc(_class.getClaShtDesc());

        ClassEntity updatedClassDetails = classRepository.save(classEntity);

        BeanUtils.copyProperties(updatedClassDetails, returnValue);
        
        return returnValue;
    }

    @Override
    public void deleteClass(int claCode) {
        ClassEntity classEntity = classRepository.findByClaCode(claCode);

        classRepository.delete(classEntity);
    }

    @Override
    public List<ClassDto> getClasses(int page, int limit) {
        List<ClassDto> returnValue = new ArrayList<>();

        Pageable pageableRequest = PageRequest.of(page, limit, Sort.by("claCode"));
        
        Page<ClassEntity> classesPage = classRepository.findAll(pageableRequest);
        List<ClassEntity> classes = classesPage.getContent();

        for(ClassEntity classEntity: classes) {
            ClassDto classDto = new ClassDto();
            BeanUtils.copyProperties(classEntity, classDto);
            returnValue.add(classDto);
        }
        
        return returnValue;
    }
}
