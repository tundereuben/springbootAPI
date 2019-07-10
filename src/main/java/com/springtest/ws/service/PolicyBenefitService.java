package com.springtest.ws.service;

import com.springtest.ws.shared.dto.PolicyBenefitDto;

import java.util.List;

public interface PolicyBenefitService {
    PolicyBenefitDto createBenefit(PolicyBenefitDto benefit);
    PolicyBenefitDto getBftByBftCode(int bftCode);
    PolicyBenefitDto updateBenefit(int bftCode, PolicyBenefitDto benefit);
    void deleteBenefit(int bftCode);
    List<PolicyBenefitDto> getBenefits(int page, int limit);
}
