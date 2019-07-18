package com.springtest.ws.service.impl;

import com.springtest.ws.entity.PolicyRateEntity;
import com.springtest.ws.io.repositories.PolicyRateRepository;
import com.springtest.ws.service.PolicyRateService;
import com.springtest.ws.shared.dto.PolicyRateDto;
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
public class PolicyRateServiceImpl implements PolicyRateService {

    @Autowired
    PolicyRateRepository policyRateRepository;

    @Override
    public PolicyRateDto createRate(PolicyRateDto rate) {
        if(policyRateRepository.findByRateCode(rate.getRateCode()) != null) throw new RuntimeException("Record already exist");

        PolicyRateEntity policyRateEntity = new PolicyRateEntity();
        BeanUtils.copyProperties(rate, policyRateEntity);

        PolicyRateEntity storedRateDetails = policyRateRepository.save(policyRateEntity);

        PolicyRateDto returnValue = new PolicyRateDto();
        BeanUtils.copyProperties(storedRateDetails, returnValue);

        return returnValue;
    }

    @Override
    public PolicyRateDto getRateByRateCode(int rateCode) {
        PolicyRateDto returnValue = new PolicyRateDto();

        PolicyRateEntity policyRateEntity = policyRateRepository.findByRateCode(rateCode);

        BeanUtils.copyProperties(policyRateEntity, returnValue);

        return returnValue;
    }

    @Override
    public PolicyRateDto updateRate(int rateCode, PolicyRateDto rate) {
        PolicyRateDto returnValue = new PolicyRateDto();
        PolicyRateEntity policyRateEntity = policyRateRepository.findByRateCode(rateCode);

        policyRateEntity.setRateName(rate.getRateName());
        policyRateEntity.setRatePolCode(rate.getRatePolCode());
        policyRateEntity.setRateDefaultValue(rate.getRateDefaultValue());
        policyRateEntity.setRateSclCode(rate.getRateSclCode());

        PolicyRateEntity updateRateDetails = policyRateRepository.save(policyRateEntity);

        BeanUtils.copyProperties(updateRateDetails, returnValue);

        return returnValue;
    }

    @Override
    public void deleteRate(int rateCode) {
        PolicyRateEntity policyRateEntity = policyRateRepository.findByRateCode(rateCode);
        policyRateRepository.delete(policyRateEntity);
    }

    @Override
    public List<PolicyRateDto> getRates(int page, int limit) {
        List<PolicyRateDto> returnValue = new ArrayList<>();

        Pageable pageableRequest = PageRequest.of(page, limit, Sort.by("rateCode"));

        Page<PolicyRateEntity> ratesPage = policyRateRepository.findAll(pageableRequest);
        List<PolicyRateEntity> rates = ratesPage.getContent();

        for(PolicyRateEntity policyRateEntity : rates) {
            PolicyRateDto policyRateDto = new PolicyRateDto();
            BeanUtils.copyProperties(policyRateEntity, policyRateDto);
            returnValue.add(policyRateDto);
        }

        return returnValue;
    }

    @Override
    public List<PolicyRateEntity> getPolicyRates(int ratePolCode) {
        List<PolicyRateEntity> returnValue = policyRateRepository.findAllByRatePolCode(ratePolCode);
        return returnValue;
    }

    @Override
    public List<PolicyRateEntity> getPolicyRatesBySubclassCode(int rateSclCode) {
        List<PolicyRateEntity> returnValue = policyRateRepository.findAllByRateSclCode(rateSclCode);
        return returnValue;
    }
}
