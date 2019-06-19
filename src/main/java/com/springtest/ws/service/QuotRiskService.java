package com.springtest.ws.service;

import com.springtest.ws.shared.dto.QuotRiskDto;

import java.util.List;

public interface QuotRiskService {
    QuotRiskDto createQuotRisk(QuotRiskDto quotRisk);
    QuotRiskDto getQuotRiskByQuotRisk(int qrCode);
    QuotRiskDto updateQuotRisk(int qrCode, QuotRiskDto quotRisk);
    void deleteQuotRisk(int qrCode);
    List<QuotRiskDto> getQuotRisks(int page, int limit);
}
