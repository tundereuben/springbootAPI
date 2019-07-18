package com.springtest.ws.service;

import com.springtest.ws.entity.PolicyRateEntity;
import com.springtest.ws.shared.dto.PolicyRateDto;

import java.util.List;

public interface PolicyRateService {
    PolicyRateDto createRate(PolicyRateDto rate);
    PolicyRateDto getRateByRateCode(int rateCode);
    PolicyRateDto updateRate(int rateCode, PolicyRateDto rate);
    void deleteRate(int rateCode);
    List<PolicyRateDto> getRates(int page, int limit);
    List<PolicyRateEntity> getPolicyRates(int ratePolCode);
    List<PolicyRateEntity> getPolicyRatesBySubclassCode(int rateSclCode);
}
