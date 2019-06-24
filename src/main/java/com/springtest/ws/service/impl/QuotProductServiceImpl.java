package com.springtest.ws.service.impl;

import com.springtest.ws.entity.QuotProductEntity;
import com.springtest.ws.io.repositories.QuotProductRepository;
import com.springtest.ws.service.QuotProductService;
import com.springtest.ws.shared.dto.QuotProductDto;
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
public class QuotProductServiceImpl implements QuotProductService {
    @Autowired
    QuotProductRepository quotProductRepository;

    @Override
    public QuotProductDto createQuotProduct(QuotProductDto quotProduct) {
        if(quotProductRepository.findByQpCode(quotProduct.getQpCode()) != null) throw new RuntimeException("Record already exists");

        QuotProductEntity quotProductEntity = new QuotProductEntity();
        BeanUtils.copyProperties(quotProduct, quotProductEntity);

        QuotProductEntity storedQuotProductDetails = quotProductRepository.save(quotProductEntity);

        QuotProductDto returnValue = new QuotProductDto();
        BeanUtils.copyProperties(storedQuotProductDetails, returnValue);
        return returnValue;
    }

    @Override
    public QuotProductDto getQuotProductByQuotProductCode(int qpCode) {
        QuotProductDto returnValue = new QuotProductDto();
        QuotProductEntity quotProductEntity = quotProductRepository.findByQpCode(qpCode);

        BeanUtils.copyProperties(quotProductEntity, returnValue);
        return returnValue;
    }

    @Override
    public QuotProductDto updateQuotProduct(int qpCode, QuotProductDto quotProduct) {
        QuotProductDto returnValue = new QuotProductDto();
        QuotProductEntity quotProductEntity = quotProductRepository.findByQpCode(qpCode);

//        quotProductEntity.setQpCode(quotProduct.getQpCode());
        quotProductEntity.setQpComm(quotProduct.getQpComm());
        quotProductEntity.setQpPremium(quotProduct.getQpPremium());
        quotProductEntity.setQpProCode(quotProduct.getQpProCode());
        quotProductEntity.setQpProShtDesc(quotProduct.getQpProShtDesc());
        quotProductEntity.setQpQuotNo(quotProduct.getQpQuotNo());
        quotProductEntity.setQpQuotCode(quotProduct.getQpQuotCode());
        quotProductEntity.setQpTotalSi(quotProduct.getQpTotalSi());
        quotProductEntity.setQpWefDate(quotProduct.getQpWefDate());
        quotProductEntity.setQpWetDate(quotProduct.getQpWetDate());
//        quotProductEntity.setQpAgntCode(quotProduct.getQpAgntCode());

        QuotProductEntity updatedQuotProductDetails = quotProductRepository.save(quotProductEntity);

        BeanUtils.copyProperties(updatedQuotProductDetails, returnValue);
        return returnValue;
    }

    @Override
    public void deleteQuotProduct(int qpCode) {
        QuotProductEntity quotProductEntity = quotProductRepository.findByQpCode(qpCode);
        quotProductRepository.delete(quotProductEntity);
    }

    @Override
    public List<QuotProductDto> getQuotProducts(int page, int limit) {
        List<QuotProductDto> returnValue = new ArrayList<>();

        if(page > 0) page -= 1;

        Pageable pageableRequest = PageRequest.of(page, limit, Sort.by("qpCode").descending());

        Page<QuotProductEntity> quotProductsPage = quotProductRepository.findAll(pageableRequest);
        List<QuotProductEntity> quotProducts = quotProductsPage.getContent();

        for(QuotProductEntity quotProductEntity: quotProducts) {
            QuotProductDto quotProductDto = new QuotProductDto();
            BeanUtils.copyProperties(quotProductEntity, quotProductDto);
            returnValue.add(quotProductDto);
        }

        return returnValue;
    }
}
