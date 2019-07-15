package com.springtest.ws.service.impl;

import com.springtest.ws.entity.PolicyExtensionEntity;
import com.springtest.ws.io.repositories.PolicyExtensionRepository;
import com.springtest.ws.service.PolicyExtensionService;
import com.springtest.ws.shared.dto.PolicyExtensionDto;
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
public class PolicyExtensionServiceImpl implements PolicyExtensionService {

    @Autowired
    PolicyExtensionRepository policyExtensionRepository;

    @Override
    public PolicyExtensionDto createExtension(PolicyExtensionDto extension) {
        if(policyExtensionRepository.findByExtCode(extension.getExtCode()) != null) throw new RuntimeException("Record already exist");

        PolicyExtensionEntity policyExtensionEntity = new PolicyExtensionEntity();
        BeanUtils.copyProperties(extension, policyExtensionEntity);

        PolicyExtensionEntity storedExtensionDetails = policyExtensionRepository.save(policyExtensionEntity);

        PolicyExtensionDto returnValue = new PolicyExtensionDto();
        BeanUtils.copyProperties(storedExtensionDetails, returnValue);

        return returnValue;
    }

    @Override
    public PolicyExtensionDto getExtensionByExtensionCode(int extCode) {
        PolicyExtensionDto returnValue = new PolicyExtensionDto();
        PolicyExtensionEntity policyExtensionEntity = policyExtensionRepository.findByExtCode(extCode);

        BeanUtils.copyProperties(policyExtensionEntity, returnValue);

        return returnValue;
    }

    @Override
    public PolicyExtensionDto updateExtension(int extCode, PolicyExtensionDto extension) {
        PolicyExtensionDto returnValue = new PolicyExtensionDto();
        PolicyExtensionEntity policyExtensionEntity = policyExtensionRepository.findByExtCode(extCode);

        policyExtensionEntity.setExtName(extension.getExtName());
        policyExtensionEntity.setExtPolCode(extension.getExtPolCode());

        PolicyExtensionEntity updateExtensionDetails = policyExtensionRepository.save(policyExtensionEntity);

        BeanUtils.copyProperties(updateExtensionDetails, returnValue);

        return returnValue;
    }

    @Override
    public void deleteExtension(int extCode) {
        PolicyExtensionEntity policyExtensionEntity = policyExtensionRepository.findByExtCode(extCode);

        policyExtensionRepository.delete(policyExtensionEntity);
    }

    @Override
    public List<PolicyExtensionDto> getExtensions(int page, int limit) {
        List<PolicyExtensionDto> returnValue = new ArrayList<>();

        Pageable pageableRequest = PageRequest.of(page, limit, Sort.by("extCode"));

        Page<PolicyExtensionEntity> extensionsPage = policyExtensionRepository.findAll(pageableRequest);
        List<PolicyExtensionEntity> extensions = extensionsPage.getContent();

        for(PolicyExtensionEntity policyExtensionEntity : extensions) {
            PolicyExtensionDto policyExtensionDto = new PolicyExtensionDto();
            BeanUtils.copyProperties(policyExtensionEntity, policyExtensionDto);
            returnValue.add(policyExtensionDto);
        }

        return returnValue;
    }

    @Override
    public List<PolicyExtensionEntity> getPolicyExtensions(int extPolCode) {
        List<PolicyExtensionEntity> returnValue = policyExtensionRepository.findAllByExtPolCode(extPolCode);
        return returnValue;
    }
}
