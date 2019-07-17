package com.springtest.ws.service.impl;

import com.springtest.ws.entity.PolicyBenefitEntity;
import com.springtest.ws.io.repositories.PolicyBenefitRepository;
import com.springtest.ws.service.PolicyBenefitService;
import com.springtest.ws.shared.dto.PolicyBenefitDto;
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
public class PolicyBenefitServiceImpl implements PolicyBenefitService {

    @Autowired
    PolicyBenefitRepository policyBenefitRepository;

    @Override
    public PolicyBenefitDto createBenefit(PolicyBenefitDto benefit) {
        if(policyBenefitRepository.findByBftCode(benefit.getBftCode()) != null) throw new RuntimeException("Record already exist");

        PolicyBenefitEntity policyBenefitEntity = new PolicyBenefitEntity();
        BeanUtils.copyProperties(benefit, policyBenefitEntity);

        PolicyBenefitEntity storedBenefitDetails = policyBenefitRepository.save(policyBenefitEntity);

        PolicyBenefitDto returnValue = new PolicyBenefitDto();
        BeanUtils.copyProperties(storedBenefitDetails, returnValue);

        return returnValue;
    }

    @Override
    public PolicyBenefitDto getBftByBftCode(int bftCode) {
        PolicyBenefitDto returnValue = new PolicyBenefitDto();
        PolicyBenefitEntity policyBenefitEntity = policyBenefitRepository.findByBftCode(bftCode);

        BeanUtils.copyProperties(policyBenefitEntity, returnValue);

        return returnValue;
    }

    @Override
    public PolicyBenefitDto updateBenefit(int bftCode, PolicyBenefitDto benefit) {
        PolicyBenefitDto returnValue = new PolicyBenefitDto();
        PolicyBenefitEntity policyBenefitEntity = policyBenefitRepository.findByBftCode(bftCode);

        policyBenefitEntity.setBftName(benefit.getBftName());
        policyBenefitEntity.setBftRate(benefit.getBftRate());
        policyBenefitEntity.setBftMultBy(benefit.getBftMultBy());
        policyBenefitEntity.setBftNo(benefit.getBftNo());

        PolicyBenefitEntity updateBenefitDetails = policyBenefitRepository.save(policyBenefitEntity);

        BeanUtils.copyProperties(updateBenefitDetails, returnValue);

        return returnValue;
    }

    @Override
    public void deleteBenefit(int bftCode) {
        PolicyBenefitEntity policyBenefitEntity = policyBenefitRepository.findByBftCode(bftCode);

        policyBenefitRepository.delete(policyBenefitEntity);
    }

    @Override
    public List<PolicyBenefitDto> getBenefits(int page, int limit) {
        List<PolicyBenefitDto> returnValue = new ArrayList<>();

        Pageable pageableRequest = PageRequest.of(page, limit, Sort.by("bftCode"));

        Page<PolicyBenefitEntity> benefitsPage = policyBenefitRepository.findAll(pageableRequest);
        List<PolicyBenefitEntity> benefits = benefitsPage.getContent();

        for(PolicyBenefitEntity policyBenefitEntity : benefits) {
            PolicyBenefitDto policyBenefitDto = new PolicyBenefitDto();
            BeanUtils.copyProperties(policyBenefitEntity, policyBenefitDto);
            returnValue.add(policyBenefitDto);
        }

        return returnValue;
    }

    @Override
    public List<PolicyBenefitEntity> getPolicyBenefits(int bftPolCode) {
        List<PolicyBenefitEntity> returnValue = policyBenefitRepository.findAllByBftPolCode(bftPolCode);
        return returnValue;
    }

    @Override
    public List<PolicyBenefitEntity> getPolicyBenefitsByBftSclCode(int bftSclCode) {
        List<PolicyBenefitEntity> returnValue = policyBenefitRepository.findAllByBftSclCode(bftSclCode);
        return returnValue;
    }
}
