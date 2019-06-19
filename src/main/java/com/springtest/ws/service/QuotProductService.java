package com.springtest.ws.service;

import com.springtest.ws.shared.dto.QuotProductDto;

import java.util.List;

public interface QuotProductService {
    QuotProductDto createQuotProduct(QuotProductDto quotProduct);
    QuotProductDto getQuotProductByQuotProductCode(int qpCode);
    QuotProductDto updateQuotProduct(int qpCode, QuotProductDto quotProduct);
    void deleteQuotProduct(int qpCode);
    List<QuotProductDto> getQuotProducts(int page, int limit);
}
