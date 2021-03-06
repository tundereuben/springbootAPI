package com.springtest.ws.service;

import com.springtest.ws.entity.PolicyDiscountEntity;
import com.springtest.ws.shared.dto.PolicyDiscountDto;

import java.util.List;

public interface PolicyDiscountService {
    PolicyDiscountDto createDiscount(PolicyDiscountDto discount);
    PolicyDiscountDto getDiscountByDiscountCode(int discountCode);
    PolicyDiscountDto updateDiscount(int discountCode, PolicyDiscountDto discount);
    void deleteDiscount(int discountCode);
    List<PolicyDiscountDto> getDiscounts(int page, int limit);
    List<PolicyDiscountEntity> getPolicyDiscounts(int dsctPolCode);
    List<PolicyDiscountEntity> getPolicyDiscountsBySubclassCode(int dsctSclCode);
}
