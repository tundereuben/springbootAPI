package com.springtest.ws.service.impl;

import com.springtest.ws.entity.PolicyLoadingEntity;
import com.springtest.ws.io.repositories.PolicyLoadingRepository;
import com.springtest.ws.service.PolicyLoadingService;
import com.springtest.ws.shared.dto.PolicyLoadingDto;
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
public class PolicyLoadingServiceImpl implements PolicyLoadingService {

    @Autowired
    PolicyLoadingRepository policyLoadingRepository;

    @Override
    public PolicyLoadingDto createLoading(PolicyLoadingDto loading) {
        if(policyLoadingRepository.findByLoadCode(loading.getLoadCode()) != null) throw new RuntimeException("Record already exist");

        PolicyLoadingEntity policyLoadingEntity = new PolicyLoadingEntity();
        BeanUtils.copyProperties(loading, policyLoadingEntity);

        PolicyLoadingEntity storedLoadingDetails = policyLoadingRepository.save(policyLoadingEntity);

        PolicyLoadingDto returnValue = new PolicyLoadingDto();
        BeanUtils.copyProperties(storedLoadingDetails, returnValue);

        return returnValue;
    }

    @Override
    public PolicyLoadingDto getLoadingByLoadingCode(int loadCode) {
        PolicyLoadingDto returnValue = new PolicyLoadingDto();

        PolicyLoadingEntity policyLoadingEntity = policyLoadingRepository.findByLoadCode(loadCode);

        BeanUtils.copyProperties(policyLoadingEntity, returnValue);

        return returnValue;
    }

    @Override
    public PolicyLoadingDto updateLoading(int loadCode, PolicyLoadingDto loading) {
        PolicyLoadingDto returnValue = new PolicyLoadingDto();
        PolicyLoadingEntity policyLoadingEntity = policyLoadingRepository.findByLoadCode(loadCode);

        policyLoadingEntity.setLoadName(loading.getLoadName());
        policyLoadingEntity.setLoadType(loading.getLoadType());
        policyLoadingEntity.setLoadCalcOn(loading.getLoadCalcOn());
        policyLoadingEntity.setLoadPolCode(loading.getLoadPolCode());
        policyLoadingEntity.setLoadDefaultValue(loading.getLoadDefaultValue());

        PolicyLoadingEntity updateLoadDetails = policyLoadingRepository.save(policyLoadingEntity);

        BeanUtils.copyProperties(updateLoadDetails, returnValue);

        return returnValue;
    }

    @Override
    public void deleteLoading(int loadCode) {
        PolicyLoadingEntity policyLoadingEntity = policyLoadingRepository.findByLoadCode(loadCode);

        policyLoadingRepository.delete(policyLoadingEntity);
    }

    @Override
    public List<PolicyLoadingDto> getLoadings(int page, int limit) {
        List<PolicyLoadingDto> returnValue = new ArrayList<>();

        Pageable pageableRequest = PageRequest.of(page, limit, Sort.by("loadCode"));

        Page<PolicyLoadingEntity> loadingsPage = policyLoadingRepository.findAll(pageableRequest);
        List<PolicyLoadingEntity> loadings = loadingsPage.getContent();

        for(PolicyLoadingEntity policyLoadingEntity : loadings) {
            PolicyLoadingDto policyLoadingDto = new PolicyLoadingDto();
            BeanUtils.copyProperties(policyLoadingEntity, policyLoadingDto);
            returnValue.add(policyLoadingDto);
        }

        return returnValue;
    }
}
