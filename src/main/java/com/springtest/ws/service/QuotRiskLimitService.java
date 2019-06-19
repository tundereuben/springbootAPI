package com.springtest.ws.service;

import com.springtest.ws.shared.dto.QuotRiskLimitDto;

import java.util.List;

public interface QuotRiskLimitService {
    QuotRiskLimitDto createQuotRiskLimit(QuotRiskLimitDto quotRiskLimit);
    QuotRiskLimitDto getQuotRiskLimitByQuotRiskLimitCode(int qrlCode);
    QuotRiskLimitDto updateQuotRiskLimit(int qrlCode, QuotRiskLimitDto quotRiskLimit);
    void deleteQuotRiskLimit(int qrlCode);
    List<QuotRiskLimitDto> getQuotRiskLimits(int page, int limit);
}
