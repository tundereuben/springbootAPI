package com.springtest.ws.service.impl;

import com.springtest.ws.entity.QuotRiskEntity;
import com.springtest.ws.io.repositories.QuotRiskRepository;
import com.springtest.ws.service.QuotRiskService;
import com.springtest.ws.shared.dto.QuotRiskDto;
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
public class QuotRiskServiceImpl implements QuotRiskService {
    @Autowired
    QuotRiskRepository quotRiskRepository;


    @Override
    public QuotRiskDto createQuotRisk(QuotRiskDto quotRisk) {
        if(quotRiskRepository.findByQrCode(quotRisk.getQrCode()) != null) throw new RuntimeException("Record already exists");

        QuotRiskEntity quotRiskEntity = new QuotRiskEntity();
        BeanUtils.copyProperties(quotRisk, quotRiskEntity);

        QuotRiskEntity storedQuotRiskDetails = quotRiskRepository.save(quotRiskEntity);

        QuotRiskDto returnValue = new QuotRiskDto();
        BeanUtils.copyProperties(storedQuotRiskDetails, returnValue);

        return returnValue;
    }

    @Override
    public QuotRiskDto getQuotRiskByQuotRisk(int qrCode) {
        QuotRiskDto returnValue = new QuotRiskDto();
        QuotRiskEntity quotRiskEntity = quotRiskRepository.findByQrCode(qrCode);

        BeanUtils.copyProperties(quotRiskEntity, returnValue);
        return returnValue;
    }

    @Override
    public QuotRiskDto updateQuotRisk(int qrCode, QuotRiskDto quotRisk) {
        QuotRiskDto returnValue = new QuotRiskDto();
        QuotRiskEntity quotRiskEntity = quotRiskRepository.findByQrCode(qrCode);

//        quotRiskEntity.setQrCode(quotRisk.getQrCode());
//        quotRiskEntity.setQrClntCode(quotRisk.getQrClntCode());;
        quotRiskEntity.setQrCovtCode(quotRisk.getQrCovtCode());
        quotRiskEntity.setQrItemDesc(quotRisk.getQrItemDesc());
        quotRiskEntity.setQrPropertyId(quotRisk.getQrPropertyId());
//        quotRiskEntity.setQrQpCode(quotRisk.getQrQpCode());
//        quotRiskEntity.setQrQuotCode(quotRisk.getQrQuotCode());
//        quotRiskEntity.setQrQuotNo(quotRisk.getQrQuotNo());
        quotRiskEntity.setQrSclCode(quotRisk.getQrSclCode());
        quotRiskEntity.setQrWefDate(quotRisk.getQrWefDate());
        quotRiskEntity.setQrWetDate(quotRisk.getQrWetDate());

        QuotRiskEntity updatedQuotRiskDetails = quotRiskRepository.save(quotRiskEntity);

        BeanUtils.copyProperties(updatedQuotRiskDetails, returnValue);

        return returnValue;
    }

    @Override
    public void deleteQuotRisk(int qrCode) {
        QuotRiskEntity quotRiskEntity = quotRiskRepository.findByQrCode(qrCode);
        quotRiskRepository.delete(quotRiskEntity);
    }

    @Override
    public List<QuotRiskDto> getQuotRisks(int page, int limit) {
        List<QuotRiskDto> returnValue = new ArrayList<>();

        if(page > 0) page -= 1;

        Pageable pageableRequest = PageRequest.of(page, limit, Sort.by("qrCode").descending());

        Page<QuotRiskEntity> quotRisksPage = quotRiskRepository.findAll(pageableRequest);
        List<QuotRiskEntity> quotRisks = quotRisksPage.getContent();

        for(QuotRiskEntity quotRiskEntity: quotRisks) {
            QuotRiskDto quotRiskDto = new QuotRiskDto();
            BeanUtils.copyProperties(quotRiskEntity,  quotRiskDto);
            returnValue.add(quotRiskDto);
        }
        return returnValue;
    }
}
