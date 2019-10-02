package com.springtest.ws.service.impl;

import com.springtest.ws.entity.PolicyProductEntity;
import com.springtest.ws.io.repositories.PolicyProductRepository;
import com.springtest.ws.service.PolicyProductService;
import com.springtest.ws.shared.dto.PolicyProductDto;
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
public class PolicyProductServiceImpl implements PolicyProductService {

    @Autowired
    PolicyProductRepository policyProductRepository;


    @Override
    public PolicyProductDto createSubclass(PolicyProductDto subclass) {

        if(policyProductRepository.findBySclCode(subclass.getSclCode()) != null) throw new RuntimeException("Record already exists");

        PolicyProductEntity policyProductEntity = new PolicyProductEntity();
        BeanUtils.copyProperties(subclass, policyProductEntity);

        PolicyProductEntity storedSubclassDetails = policyProductRepository.save(policyProductEntity);

        PolicyProductDto returnValue = new PolicyProductDto();
        BeanUtils.copyProperties(storedSubclassDetails, returnValue);

        return returnValue;
    }

    @Override
    public PolicyProductDto getSubclassBySubclassCode(int sclCode) {
        PolicyProductDto returnValue = new PolicyProductDto();
        PolicyProductEntity policyProductEntity = policyProductRepository.findBySclCode(sclCode);

        BeanUtils.copyProperties(policyProductEntity, returnValue);

        return returnValue;
    }

    @Override
    public PolicyProductDto updateSubclass(int sclCode, PolicyProductDto subclass) {
        PolicyProductDto returnValue = new PolicyProductDto();
        PolicyProductEntity policyProductEntity = policyProductRepository.findBySclCode(sclCode);

        policyProductEntity.setSclPolCode(subclass.getSclPolCode());
        policyProductEntity.setSclName(subclass.getSclName());

        PolicyProductEntity updatedSubclassDetails = policyProductRepository.save(policyProductEntity);

        BeanUtils.copyProperties(updatedSubclassDetails, returnValue);

        return returnValue;
    }

    @Override
    public void deleteSubclass(int sclCode) {
        PolicyProductEntity policyProductEntity = policyProductRepository.findBySclCode(sclCode);

        policyProductRepository.delete(policyProductEntity);
    }

    @Override
    public List<PolicyProductDto> getSubclasses(int page, int limit) {
        List<PolicyProductDto> returnValue = new ArrayList<>();

        Pageable pageableRequest = PageRequest.of(page, limit, Sort.by("sclCode"));

        Page<PolicyProductEntity> subclassesPage = policyProductRepository.findAll(pageableRequest);
        List<PolicyProductEntity> subclasses = subclassesPage.getContent();

        for(PolicyProductEntity policyProductEntity : subclasses) {
            PolicyProductDto policyProductDto = new PolicyProductDto();
            BeanUtils.copyProperties(policyProductEntity, policyProductDto);
            returnValue.add(policyProductDto);
        }

        return returnValue;
    }

    @Override
    public List<PolicyProductEntity> getPolicySubclasses(int sclPolCode) {
        List<PolicyProductEntity> returnValue = policyProductRepository.findAllBySclPolCode(sclPolCode);
        return returnValue;
    }
}
