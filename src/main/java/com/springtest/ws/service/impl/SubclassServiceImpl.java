package com.springtest.ws.service.impl;

import com.springtest.ws.entity.SubclassEntity;
import com.springtest.ws.io.repositories.SubclassRepository;
import com.springtest.ws.service.SubclassService;
import com.springtest.ws.shared.dto.SubclassDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SubclassServiceImpl implements SubclassService{

    @Autowired
    SubclassRepository subclassRepository;


    @Override
    public SubclassDto createSubclass(SubclassDto subclass) {

        if(subclassRepository.findBySclCode(subclass.getSclCode()) != null) throw new RuntimeException("Record already exists");

        SubclassEntity subclassEntity = new SubclassEntity();
        BeanUtils.copyProperties(subclass, subclassEntity);

        SubclassEntity storedSubclassDetails = subclassRepository.save(subclassEntity);

        SubclassDto returnValue = new SubclassDto();
        BeanUtils.copyProperties(storedSubclassDetails, returnValue);

        return returnValue;
    }

    @Override
    public SubclassDto getSubclassBySubclassCode(int sclCode) {
        SubclassDto returnValue = new SubclassDto();
        SubclassEntity subclassEntity = subclassRepository.findBySclCode(sclCode);

        BeanUtils.copyProperties(subclassEntity, returnValue);

        return returnValue;
    }

    @Override
    public SubclassDto updateSubclass(int sclCode, SubclassDto subclass) {
        SubclassDto returnValue = new SubclassDto();
        SubclassEntity subclassEntity = subclassRepository.findBySclCode(sclCode);

        subclassEntity.setSclClaCode(subclass.getSclClaCode());
        subclassEntity.setSclDesc(subclass.getSclDesc());
        subclassEntity.setSclShtDesc(subclass.getSclShtDesc());

        SubclassEntity updatedSubclassDetails = subclassRepository.save(subclassEntity);

        BeanUtils.copyProperties(updatedSubclassDetails, returnValue);

        return returnValue;
    }

    @Override
    public void deleteSubclass(int sclCode) {
        SubclassEntity subclassEntity = subclassRepository.findBySclCode(sclCode);

        subclassRepository.delete(subclassEntity);
    }

    @Override
    public List<SubclassDto> getSubclasses(int page, int limit) {
        List<SubclassDto> returnValue = new ArrayList<>();

        Pageable pageableRequest = PageRequest.of(page, limit);

        Page<SubclassEntity> subclassesPage = subclassRepository.findAll(pageableRequest);
        List<SubclassEntity> subclasses = subclassesPage.getContent();

        for(SubclassEntity subclassEntity: subclasses) {
            SubclassDto subclassDto = new SubclassDto();
            BeanUtils.copyProperties(subclassEntity, subclassDto);
            returnValue.add(subclassDto);
        }

        return returnValue;
    }
}
