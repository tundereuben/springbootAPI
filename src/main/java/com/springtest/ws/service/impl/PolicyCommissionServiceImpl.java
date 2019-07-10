package com.springtest.ws.service.impl;

import com.springtest.ws.entity.PolicyCommissionEntity;
import com.springtest.ws.io.repositories.PolicyCommissionRepository;
import com.springtest.ws.service.PolicyCommissionService;
import com.springtest.ws.shared.dto.PolicyCommissionDto;
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
public class PolicyCommissionServiceImpl implements PolicyCommissionService {

    @Autowired
    PolicyCommissionRepository policyCommissionRepository;

    @Override
    public PolicyCommissionDto createCommission(PolicyCommissionDto commission) {

        if(policyCommissionRepository.findByCommCode(commission.getCommCode()) != null) throw new RuntimeException("Record already exist");

        PolicyCommissionEntity policyCommissionEntity = new PolicyCommissionEntity();
        BeanUtils.copyProperties(commission, policyCommissionEntity);

        PolicyCommissionEntity storedCommissionDetails = policyCommissionRepository.save(policyCommissionEntity);

        PolicyCommissionDto returnValue = new PolicyCommissionDto();
        BeanUtils.copyProperties(storedCommissionDetails, returnValue);

        return returnValue;
    }

    @Override
    public PolicyCommissionDto getCommByCommCode(int commCode) {
        PolicyCommissionDto returnValue = new PolicyCommissionDto();

        PolicyCommissionEntity policyCommissionEntity = policyCommissionRepository.findByCommCode(commCode);

        BeanUtils.copyProperties(policyCommissionEntity, returnValue);

        return returnValue;
    }

    @Override
    public PolicyCommissionDto updateCommission(int commCode, PolicyCommissionDto commission) {
        PolicyCommissionDto returnValue = new PolicyCommissionDto();
        PolicyCommissionEntity policyCommissionEntity = policyCommissionRepository.findByCommCode(commCode);

        policyCommissionEntity.setCommName(commission.getCommName());
        policyCommissionEntity.setCommType(commission.getCommType());
        policyCommissionEntity.setCommCalcOn(commission.getCommCalcOn());
        policyCommissionEntity.setCommPolCode(commission.getCommPolCode());

        PolicyCommissionEntity updateCommDetails = policyCommissionRepository.save(policyCommissionEntity);

        BeanUtils.copyProperties(updateCommDetails, returnValue);

        return returnValue;
    }

    @Override
    public void deleteCommission(int commCode) {
        PolicyCommissionEntity policyCommissionEntity = policyCommissionRepository.findByCommCode(commCode);

        policyCommissionRepository.delete(policyCommissionEntity);
    }

    @Override
    public List<PolicyCommissionDto> getCommissions(int page, int limit) {
        List<PolicyCommissionDto> returnValue = new ArrayList<>();

        Pageable pageableRequest = PageRequest.of(page, limit, Sort.by("commCode"));

        Page<PolicyCommissionEntity> commissionsPage = policyCommissionRepository.findAll(pageableRequest);
        List<PolicyCommissionEntity> commissions = commissionsPage.getContent();

        for(PolicyCommissionEntity policyCommissionEntity : commissions) {
            PolicyCommissionDto policyCommissionDto = new PolicyCommissionDto();
            BeanUtils.copyProperties(policyCommissionEntity, policyCommissionDto);
            returnValue.add(policyCommissionDto);
        }

        return returnValue;
    }
}
