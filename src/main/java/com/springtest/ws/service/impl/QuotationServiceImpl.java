package com.springtest.ws.service.impl;

import com.springtest.ws.entity.QuotationEntity;
import com.springtest.ws.io.repositories.QuotationRepository;
import com.springtest.ws.service.QuotationService;
import com.springtest.ws.shared.dto.QuotationDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuotationServiceImpl implements QuotationService {

    @Autowired
    QuotationRepository quotationRepository;

    @Override
    public QuotationDto createQuotation (QuotationDto quotation) {
        if(quotationRepository.findByQuotCode(quotation.getQuotCode()) != null) throw new RuntimeException("Record already exists");

        QuotationEntity quotationEntity = new QuotationEntity();
        BeanUtils.copyProperties(quotation, quotationEntity);

        QuotationEntity storedQuotationDetails = quotationRepository.save(quotationEntity);

        QuotationDto returnValue = new QuotationDto();
        BeanUtils.copyProperties(storedQuotationDetails, returnValue);

        return returnValue;
    }

    @Override
    public QuotationDto getQuotationByQuotationCode(int quotCode) {
        QuotationDto returnValue = new QuotationDto();
        QuotationEntity quotationEntity = quotationRepository.findByQuotCode(quotCode);

        BeanUtils.copyProperties(quotationEntity, returnValue);

        return returnValue;
    }

    @Override
    public QuotationDto updateQuotation(int quotCode, QuotationDto quotation) {
        QuotationDto returnValue = new QuotationDto();
        QuotationEntity quotationEntity = quotationRepository.findByQuotCode(quotCode);

        quotationEntity.setQuotCode(quotation.getQuotCode());
        quotationEntity.setQuotNo(quotation.getQuotNo());
        quotationEntity.setQuotClntCode(quotation.getQuotClntCode());
        quotationEntity.setQuotBrnCode(quotation.getQuotBrnCode());
        quotationEntity.setQuotCurCode(quotation.getQuotCurCode());
        quotationEntity.setQuotCurSymbol(quotation.getQuotCurSymbol());
        quotationEntity.setQuotCoverFrom(quotation.getQuotCoverFrom());
        quotationEntity.setQuotCoverTo(quotation.getQuotCoverTo());
        quotationEntity.setQuotTotPropertyVal(quotation.getQuotTotPropertyVal());
        quotationEntity.setQuotDate(quotation.getQuotDate());
        quotationEntity.setQuotStatus(quotation.getQuotStatus());
        quotationEntity.setQuotExpiryDate(quotation.getQuotExpiryDate());
        quotationEntity.setQuotPremium(quotation.getQuotPremium());
        quotationEntity.setQuotCommAmt(quotation.getQuotCommAmt());
        quotationEntity.setQuotAuthorisedBy(quotation.getQuotAuthorisedBy());
        quotationEntity.setQuotAuthorisedDt(quotation.getQuotAuthorisedDt());
        quotationEntity.setQuotConfirmed(quotation.getQuotConfirmed());
        quotationEntity.setQuotConfirmedBy(quotation.getQuotConfirmedBy());
        quotationEntity.setQuotConfirmedDt(quotation.getQuotConfirmedDt());
        quotationEntity.setQuotReadyBy(quotation.getQuotReadyBy());
        quotationEntity.setQuotReadyDate(quotation.getQuotReadyDate());
        quotationEntity.setQuotRevised(quotation.getQuotRevised());
        quotationEntity.setQuotPreparedBy(quotation.getQuotPreparedBy());
        quotationEntity.setQuotClntType(quotation.getQuotClntType());
        quotationEntity.setQuotPreparedDt(quotation.getQuotPreparedDt());
        quotationEntity.setQuotCancelReason(quotation.getQuotCancelReason());
        quotationEntity.setQuotFreqOfPayment(quotation.getQuotFreqOfPayment());

        QuotationEntity updatedQuotationDetails = quotationRepository.save(quotationEntity);

        BeanUtils.copyProperties(updatedQuotationDetails, returnValue);

        return returnValue;
    }

    @Override
    public void deleteQuotation(int quotCode) {
        QuotationEntity quotationEntity = quotationRepository.findByQuotCode(quotCode);
        quotationRepository.delete(quotationEntity);
    }

    @Override
    public List<QuotationDto> getQuotations(int page, int limit) {
        List<QuotationDto> returnValue = new ArrayList<>();

        if(page > 0) page -= 1;

        Pageable pageableRequest = PageRequest.of(page, limit);

        Page<QuotationEntity> quotationsPage = quotationRepository.findAll(pageableRequest);
        List<QuotationEntity> quotations = quotationsPage.getContent();

        for(QuotationEntity quotationEntity: quotations) {
            QuotationDto quotationDto = new QuotationDto();
            BeanUtils.copyProperties(quotationEntity, quotationDto);
            returnValue.add(quotationDto);
        }

        return returnValue;
    }
}
