package com.springtest.ws.service.impl;

import com.springtest.ws.entity.PolicyEntity;
import com.springtest.ws.io.repositories.PolicyRepository;
import com.springtest.ws.service.PolicyService;
import com.springtest.ws.shared.dto.PolicyDto;
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
public class PolicyServiceImpl implements PolicyService {
    @Autowired
    PolicyRepository policyRepository;

    @Override
    public PolicyDto createPolicy(PolicyDto policy) {

        if(policyRepository.findByPolCode(policy.getPolCode()) != null) throw new RuntimeException("Record already exist");

        PolicyEntity policyEntity = new PolicyEntity();
        BeanUtils.copyProperties(policy, policyEntity);

        PolicyEntity storedPolicyDetails = policyRepository.save(policyEntity);

        PolicyDto returnValue = new PolicyDto();
        BeanUtils.copyProperties(storedPolicyDetails, returnValue);

        return returnValue;
    }

    @Override
    public PolicyDto getPolicyByPolicyCode(int polCode) {
        PolicyDto returnValue = new PolicyDto();
        PolicyEntity policyEntity = policyRepository.findByPolCode(polCode);

        BeanUtils.copyProperties(policyEntity, returnValue);

        return returnValue;
    }

    @Override
    public PolicyDto updatePolicy(int polCode, PolicyDto policy) {
        PolicyDto returnValue = new PolicyDto();
        PolicyEntity policyEntity = policyRepository.findByPolCode(polCode);

        policyEntity.setPolName(policy.getPolName());
        policyEntity.setPolClaName(policy.getPolClaName());
        policyEntity.setPolSclName(policy.getPolSclName());

        PolicyEntity updatedPolicyDetails = policyRepository.save(policyEntity);

        BeanUtils.copyProperties(updatedPolicyDetails, returnValue);

        return returnValue;
    }

    @Override
    public void deletePolicy(int polCode) {
        PolicyEntity policyEntity = policyRepository.findByPolCode(polCode);

        policyRepository.delete(policyEntity);
    }

    @Override
    public List<PolicyDto> getPolicies(int page, int limit) {
        List<PolicyDto> returnValue = new ArrayList<>();

        Pageable pageableRequest = PageRequest.of(page, limit, Sort.by("polCode").descending());

        Page<PolicyEntity> policiesPage = policyRepository.findAll(pageableRequest);
        List<PolicyEntity> policies = policiesPage.getContent();

        for(PolicyEntity policyEntity: policies) {
            PolicyDto policyDto = new PolicyDto();
            BeanUtils.copyProperties(policyEntity, policyDto);
            returnValue.add(policyDto);
        }

        return returnValue;
    }
}
