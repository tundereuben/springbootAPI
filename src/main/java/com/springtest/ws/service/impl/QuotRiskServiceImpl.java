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

        quotRiskEntity.setQrCode(quotRisk.getQrCode());
        quotRiskEntity.setQrAllowedCommRate(quotRisk.getQrAllowedCommRate());
        quotRiskEntity.setQrAnnualPrem(quotRisk.getQrAnnualPrem());
        quotRiskEntity.setQrBindCode(quotRisk.getQrBindCode());
        quotRiskEntity.setQrClntCode(quotRisk.getQrClntCode());
//        quotRiskEntity.setQrClntShtDesc(quotRisk.getQrClntShtDesc());
        quotRiskEntity.setQrClntType(quotRisk.getQrClntType());
        quotRiskEntity.setQrCommAmt(quotRisk.getQrCommAmt());
        quotRiskEntity.setQrComment(quotRisk.getQrComment());
        quotRiskEntity.setQrComRate(quotRisk.getQrComRate());
        quotRiskEntity.setQrConveyanceType(quotRisk.getQrConveyanceType());
        quotRiskEntity.setQrCoverDays(quotRisk.getQrCoverDays());
        quotRiskEntity.setQrCovtCode(quotRisk.getQrCovtCode());
        quotRiskEntity.setQrCovtShtDesc(quotRisk.getQrCovtShtDesc());
        quotRiskEntity.setQrEnforceCvtMinPrem(quotRisk.getQrEnforceCvtMinPrem());
        quotRiskEntity.setQrFp(quotRisk.getQrFp());
        quotRiskEntity.setQrItemDesc(quotRisk.getQrItemDesc());
        quotRiskEntity.setQrLtaCommAmt(quotRisk.getQrLtaCommAmt());
        quotRiskEntity.setQrLtaCommRate(quotRisk.getQrLtaCommRate());
        quotRiskEntity.setQrMinPremiumUsed(quotRisk.getQrMinPremiumUsed());
        quotRiskEntity.setQrMktrComAmt(quotRisk.getQrMktrComAmt());
        quotRiskEntity.setQrMktrComRate(quotRisk.getQrMktrComRate());
        quotRiskEntity.setQrNcdLevel(quotRisk.getQrNcdLevel());
        quotRiskEntity.setQrPremium(quotRisk.getQrPremium());
        quotRiskEntity.setQrPropertyId(quotRisk.getQrPropertyId());
        quotRiskEntity.setQrPrsCode(quotRisk.getQrPrsCode());
        quotRiskEntity.setQrQpCode(quotRisk.getQrQpCode());
        quotRiskEntity.setQrQty(quotRisk.getQrQty());
        quotRiskEntity.setQrQuotCode(quotRisk.getQrQuotCode());
        quotRiskEntity.setQrQuotNo(quotRisk.getQrQuotNo());
        quotRiskEntity.setQrQuotRevisionNo(quotRisk.getQrQuotRevisionNo());
        quotRiskEntity.setQrSclCode(quotRisk.getQrSclCode());
        quotRiskEntity.setQrSubCommAmt(quotRisk.getQrSubCommAmt());
        quotRiskEntity.setQrSubCommRate(quotRisk.getQrSubCommRate());
        quotRiskEntity.setQrValue(quotRisk.getQrValue());
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

        Pageable pageableRequest = PageRequest.of(page, limit);

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
