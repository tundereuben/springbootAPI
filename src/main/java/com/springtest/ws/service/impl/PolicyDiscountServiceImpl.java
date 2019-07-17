package com.springtest.ws.service.impl;

import com.springtest.ws.entity.PolicyDiscountEntity;
import com.springtest.ws.io.repositories.PolicyDiscountRepository;
import com.springtest.ws.service.PolicyDiscountService;
import com.springtest.ws.shared.dto.PolicyDiscountDto;
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
public class PolicyDiscountServiceImpl implements PolicyDiscountService {

    @Autowired
    PolicyDiscountRepository policyDiscountRepository;

    @Override
    public PolicyDiscountDto createDiscount(PolicyDiscountDto discount) {
        if(policyDiscountRepository.findByDsctCode(discount.getDsctCode()) != null) throw new RuntimeException("Record already exist");

        PolicyDiscountEntity policyDiscountEntity = new PolicyDiscountEntity();
        BeanUtils.copyProperties(discount, policyDiscountEntity);

        PolicyDiscountEntity storedDiscountDetails = policyDiscountRepository.save(policyDiscountEntity);

        PolicyDiscountDto returnValue = new PolicyDiscountDto();
        BeanUtils.copyProperties(storedDiscountDetails, returnValue);

        return returnValue;
    }

    @Override
    public PolicyDiscountDto getDiscountByDiscountCode(int discountCode) {
        PolicyDiscountDto returnValue = new PolicyDiscountDto();
        PolicyDiscountEntity policyDiscountEntity = policyDiscountRepository.findByDsctCode(discountCode);

        BeanUtils.copyProperties(policyDiscountEntity, returnValue);

        return returnValue;
    }

    @Override
    public PolicyDiscountDto updateDiscount(int discountCode, PolicyDiscountDto discount) {
        PolicyDiscountDto returnValue = new PolicyDiscountDto();
        PolicyDiscountEntity policyDiscountEntity = policyDiscountRepository.findByDsctCode(discountCode);

        policyDiscountEntity.setDsctName(discount.getDsctName());
        policyDiscountEntity.setDsctType(discount.getDsctType());
        policyDiscountEntity.setDsctCalcOn(discount.getDsctCalcOn());
        policyDiscountEntity.setDsctPolCode(discount.getDsctPolCode());
        policyDiscountEntity.setDsctDefaultValue(discount.getDsctDefaultValue());
        policyDiscountEntity.setDsctSclCode(discount.getDsctSclCode());

        PolicyDiscountEntity updateDiscountDetails = policyDiscountRepository.save(policyDiscountEntity);

        BeanUtils.copyProperties(updateDiscountDetails, returnValue);

        return returnValue;
    }

    @Override
    public void deleteDiscount(int discountCode) {
        PolicyDiscountEntity policyDiscountEntity = policyDiscountRepository.findByDsctCode(discountCode);

        policyDiscountRepository.delete(policyDiscountEntity);
    }

    @Override
    public List<PolicyDiscountDto> getDiscounts(int page, int limit) {
        List<PolicyDiscountDto> returnValue = new ArrayList<>();

        Pageable pageableRequest = PageRequest.of(page, limit, Sort.by("dsctCode"));

        Page<PolicyDiscountEntity> discountsPage = policyDiscountRepository.findAll(pageableRequest);
        List<PolicyDiscountEntity> discounts = discountsPage.getContent();

        for(PolicyDiscountEntity policyDiscountEntity : discounts) {
            PolicyDiscountDto policyDiscountDto = new PolicyDiscountDto();
            BeanUtils.copyProperties(policyDiscountEntity, policyDiscountDto);
            returnValue.add(policyDiscountDto);
        }

        return returnValue;
    }

    @Override
    public List<PolicyDiscountEntity> getPolicyDiscounts(int dsctPolCode) {
        List<PolicyDiscountEntity> returnValue = policyDiscountRepository.findAllByDsctPolCode(dsctPolCode);
        return returnValue;
    }

    @Override
    public List<PolicyDiscountEntity> getPolicyDiscountsBySubclassCode(int dsctSclCode) {
        List<PolicyDiscountEntity> returnValue = policyDiscountRepository.findAllByDsctSclCode(dsctSclCode);
        return returnValue;
    }
}
