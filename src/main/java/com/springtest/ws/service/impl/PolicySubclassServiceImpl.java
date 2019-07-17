package com.springtest.ws.service.impl;

import com.springtest.ws.entity.PolicySubclassEntity;
import com.springtest.ws.io.repositories.PolicySubclassRepository;
import com.springtest.ws.service.PolicySubclassService;
import com.springtest.ws.shared.dto.PolicySubclassDto;
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
public class PolicySubclassServiceImpl implements PolicySubclassService {

    @Autowired
    PolicySubclassRepository policySubclassRepository;


    @Override
    public PolicySubclassDto createSubclass(PolicySubclassDto subclass) {

        if(policySubclassRepository.findBySclCode(subclass.getSclCode()) != null) throw new RuntimeException("Record already exists");

        PolicySubclassEntity policySubclassEntity = new PolicySubclassEntity();
        BeanUtils.copyProperties(subclass, policySubclassEntity);

        PolicySubclassEntity storedSubclassDetails = policySubclassRepository.save(policySubclassEntity);

        PolicySubclassDto returnValue = new PolicySubclassDto();
        BeanUtils.copyProperties(storedSubclassDetails, returnValue);

        return returnValue;
    }

    @Override
    public PolicySubclassDto getSubclassBySubclassCode(int sclCode) {
        PolicySubclassDto returnValue = new PolicySubclassDto();
        PolicySubclassEntity policySubclassEntity = policySubclassRepository.findBySclCode(sclCode);

        BeanUtils.copyProperties(policySubclassEntity, returnValue);

        return returnValue;
    }

    @Override
    public PolicySubclassDto updateSubclass(int sclCode, PolicySubclassDto subclass) {
        PolicySubclassDto returnValue = new PolicySubclassDto();
        PolicySubclassEntity policySubclassEntity = policySubclassRepository.findBySclCode(sclCode);

        policySubclassEntity.setSclPolCode(subclass.getSclPolCode());
        policySubclassEntity.setSclName(subclass.getSclName());

        PolicySubclassEntity updatedSubclassDetails = policySubclassRepository.save(policySubclassEntity);

        BeanUtils.copyProperties(updatedSubclassDetails, returnValue);

        return returnValue;
    }

    @Override
    public void deleteSubclass(int sclCode) {
        PolicySubclassEntity policySubclassEntity = policySubclassRepository.findBySclCode(sclCode);

        policySubclassRepository.delete(policySubclassEntity);
    }

    @Override
    public List<PolicySubclassDto> getSubclasses(int page, int limit) {
        List<PolicySubclassDto> returnValue = new ArrayList<>();

        Pageable pageableRequest = PageRequest.of(page, limit, Sort.by("sclCode"));

        Page<PolicySubclassEntity> subclassesPage = policySubclassRepository.findAll(pageableRequest);
        List<PolicySubclassEntity> subclasses = subclassesPage.getContent();

        for(PolicySubclassEntity policySubclassEntity : subclasses) {
            PolicySubclassDto policySubclassDto = new PolicySubclassDto();
            BeanUtils.copyProperties(policySubclassEntity, policySubclassDto);
            returnValue.add(policySubclassDto);
        }

        return returnValue;
    }

    @Override
    public List<PolicySubclassEntity> getPolicySubclasses(int sclPolCode) {
        List<PolicySubclassEntity> returnValue = policySubclassRepository.findAllBySclPolCode(sclPolCode);
        return returnValue;
    }
}
