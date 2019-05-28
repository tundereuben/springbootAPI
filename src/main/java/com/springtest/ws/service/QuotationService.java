package com.springtest.ws.service;

import com.springtest.ws.shared.dto.QuotationDto;

import java.util.List;

public interface QuotationService {
    QuotationDto createQuotation(QuotationDto quotation);
    QuotationDto getQuotationByQuotationCode(int quotCode);
    QuotationDto updateQuotation(int quotCode, QuotationDto quotation);
    void deleteQuotation(int quotCode);
    List<QuotationDto> getQuotations(int page, int limit);
}
