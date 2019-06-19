package com.springtest.ws.service.impl;

import com.springtest.ws.entity.QuotRiskLimitEntity;
import com.springtest.ws.io.repositories.QuotRiskLimitRepository;
import com.springtest.ws.service.QuotRiskLimitService;
import com.springtest.ws.shared.dto.QuotRiskLimitDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuotRiskLimitServiceImpl implements QuotRiskLimitService {
    @Autowired
    QuotRiskLimitRepository quotRiskLimitRepository;

    @Override
    public QuotRiskLimitDto createQuotRiskLimit(QuotRiskLimitDto quotRiskLimit) {
        if(quotRiskLimitRepository.findByQrlCode(quotRiskLimit.getQrlCode()) != null) throw new RuntimeException("Record already exists");

        QuotRiskLimitEntity quotRiskLimitEntity = new QuotRiskLimitEntity();
        BeanUtils.copyProperties(quotRiskLimit, quotRiskLimitEntity);

        QuotRiskLimitEntity storedQuotRiskLimitDetails = quotRiskLimitRepository.save(quotRiskLimitEntity);

        QuotRiskLimitDto returnValue = new QuotRiskLimitDto();
        BeanUtils.copyProperties(storedQuotRiskLimitDetails, returnValue);

        return returnValue;
    }

    @Override
    public QuotRiskLimitDto getQuotRiskLimitByQuotRiskLimitCode(int qrlCode) {
        QuotRiskLimitDto returnValue = new QuotRiskLimitDto();
        QuotRiskLimitEntity quotRiskLimitEntity = quotRiskLimitRepository.findByQrlCode(qrlCode);

        BeanUtils.copyProperties(quotRiskLimitEntity, returnValue);
        return returnValue;
    }

    @Override
    public QuotRiskLimitDto updateQuotRiskLimit(int qrlCode, QuotRiskLimitDto quotRiskLimit) {
        QuotRiskLimitDto returnValue = new QuotRiskLimitDto();
        QuotRiskLimitEntity quotRiskLimitEntity = quotRiskLimitRepository.findByQrlCode(qrlCode);

//        quotRiskLimitEntity.setQrlCode(quotRiskLimit.getQrlCode());
        quotRiskLimitEntity.setQrlActualPrem(quotRiskLimit.getQrlActualPrem());
        quotRiskLimitEntity.setQrlActualRatePrem(quotRiskLimit.getQrlActualRatePrem());
        quotRiskLimitEntity.setQrlActualPrem(quotRiskLimit.getQrlActualPrem());
        quotRiskLimitEntity.setQrlCalcGroup(quotRiskLimit.getQrlCalcGroup());
        quotRiskLimitEntity.setQrlComment(quotRiskLimit.getQrlComment());
        quotRiskLimitEntity.setQrlCompute(quotRiskLimit.getQrlCompute());
        quotRiskLimitEntity.setQrlCoverType(quotRiskLimit.getQrlCoverType());
        quotRiskLimitEntity.setQrlDeclarationSection(quotRiskLimit.getQrlDeclarationSection());
        quotRiskLimitEntity.setQrlDesc(quotRiskLimit.getQrlDesc());
        quotRiskLimitEntity.setQrlDualBasis(quotRiskLimit.getQrlDualBasis());
        quotRiskLimitEntity.setQrlEmlPct(quotRiskLimit.getQrlEmlPct());
        quotRiskLimitEntity.setQrlExpired(quotRiskLimit.getQrlExpired());
        quotRiskLimitEntity.setQrlFirstloss(quotRiskLimit.getQrlFirstloss());
        quotRiskLimitEntity.setQrlFirstlossAmtPcnt(quotRiskLimit.getQrlFirstlossAmtPcnt());
        quotRiskLimitEntity.setQrlFirstlossValue(quotRiskLimit.getQrlFirstlossValue());
        quotRiskLimitEntity.setQrlFreeLimit(quotRiskLimit.getQrlFreeLimit());
        quotRiskLimitEntity.setQrlFreeLimitAmt(quotRiskLimit.getQrlFreeLimitAmt());
        quotRiskLimitEntity.setQrlIndemFstprd(quotRiskLimit.getQrlIndemFstprd());
        quotRiskLimitEntity.setQrlIndemFstprdPct(quotRiskLimit.getQrlIndemFstprdPct());
        quotRiskLimitEntity.setQrlIndemPrd(quotRiskLimit.getQrlIndemPrd());
        quotRiskLimitEntity.setQrlIndemRemprdPct(quotRiskLimit.getQrlIndemRemprdPct());
        quotRiskLimitEntity.setQrlIpuCode(quotRiskLimit.getQrlIpuCode());
        quotRiskLimitEntity.setQrlIsEditable(quotRiskLimit.getQrlIsEditable());
        quotRiskLimitEntity.setQrlLimitAmt(quotRiskLimit.getQrlLimitAmt());
        quotRiskLimitEntity.setQrlLimitPrd(quotRiskLimit.getQrlLimitPrd());
        quotRiskLimitEntity.setQrlMinPremium(quotRiskLimit.getQrlMinPremium());
        quotRiskLimitEntity.setQrlMultiplierDivFactor(quotRiskLimit.getQrlMultiplierDivFactor());
        quotRiskLimitEntity.setQrlMultiplierRate(quotRiskLimit.getQrlMultiplierRate());
        quotRiskLimitEntity.setQrlOriginalPremRate(quotRiskLimit.getQrlOriginalPremRate());
        quotRiskLimitEntity.setQrlPrdType(quotRiskLimit.getQrlPrdType());
        quotRiskLimitEntity.setQrlPremAccumulation(quotRiskLimit.getQrlPremAccumulation());
        quotRiskLimitEntity.setQrlPremAmt(quotRiskLimit.getQrlPremAmt());
        quotRiskLimitEntity.setQrlPremProrata(quotRiskLimit.getQrlPremProrata());
        quotRiskLimitEntity.setQrlPremRate(quotRiskLimit.getQrlPremRate());
        quotRiskLimitEntity.setQrlPrevEndrMultRate(quotRiskLimit.getQrlPrevEndrMultRate());
        quotRiskLimitEntity.setQrlPrevEndrPremRate(quotRiskLimit.getQrlPrevEndrPremRate());
        quotRiskLimitEntity.setQrlPrevEndrRateDivFact(quotRiskLimit.getQrlPrevEndrRateDivFact());
        quotRiskLimitEntity.setQrlPrevLimit(quotRiskLimit.getQrlPrevLimit());
        quotRiskLimitEntity.setQrlPrevPrem(quotRiskLimit.getQrlPrevPrem());
        quotRiskLimitEntity.setQrlPrevPremProrata(quotRiskLimit.getQrlPrevPremProrata());
        quotRiskLimitEntity.setQrlProrataFull(quotRiskLimit.getQrlProrataFull());
        quotRiskLimitEntity.setQrlPrrMaxRate(quotRiskLimit.getQrlPrrMaxRate());
        quotRiskLimitEntity.setQrlPrrMinRate(quotRiskLimit.getQrlPrrMinRate());
        quotRiskLimitEntity.setQrlqrlPrevEndrMultDivFact(quotRiskLimit.getQrlqrlPrevEndrMultDivFact());
        quotRiskLimitEntity.setQrlRateChangeRemarks(quotRiskLimit.getQrlRateChangeRemarks());
        quotRiskLimitEntity.setQrlRateDesc(quotRiskLimit.getQrlRateDesc());
        quotRiskLimitEntity.setQrlRateDivFactor(quotRiskLimit.getQrlRateDivFactor());
        quotRiskLimitEntity.setQrlRateType(quotRiskLimit.getQrlRateType());
        quotRiskLimitEntity.setQrlRowNum(quotRiskLimit.getQrlRowNum());
        quotRiskLimitEntity.setQrlSectCode(quotRiskLimit.getQrlSectCode());
        quotRiskLimitEntity.setQrlSectExcessDetail(quotRiskLimit.getQrlSectExcessDetail());
        quotRiskLimitEntity.setQrlSectShtDesc(quotRiskLimit.getQrlSectShtDesc());
        quotRiskLimitEntity.setQrlSectType(quotRiskLimit.getQrlSectType());
        quotRiskLimitEntity.setQrlSiLimitType(quotRiskLimit.getQrlSiLimitType());
        quotRiskLimitEntity.setQrlSiRate(quotRiskLimit.getQrlSiRate());
        quotRiskLimitEntity.setQrlTopLocDivFact(quotRiskLimit.getQrlTopLocDivFact());
        quotRiskLimitEntity.setQrlTopLocRate(quotRiskLimit.getQrlTopLocRate());
        quotRiskLimitEntity.setQrlUsedLimit(quotRiskLimit.getQrlUsedLimit());


        QuotRiskLimitEntity updatedQuotRiskLimitDetails = quotRiskLimitRepository.save(quotRiskLimitEntity);

        BeanUtils.copyProperties(updatedQuotRiskLimitDetails, returnValue);

        return returnValue;
    }

    @Override
    public void deleteQuotRiskLimit(int qrlCode) {
        QuotRiskLimitEntity quotRiskLimitEntity = quotRiskLimitRepository.findByQrlCode(qrlCode);
        quotRiskLimitRepository.delete(quotRiskLimitEntity);
    }

    @Override
    public List<QuotRiskLimitDto> getQuotRiskLimits(int page, int limit) {
        List<QuotRiskLimitDto> returnValue = new ArrayList<>();

        if(page > 0) page -= 1;

        Pageable pageableRequest = PageRequest.of(page, limit);

        Page<QuotRiskLimitEntity> quotRiskLimitsPage = quotRiskLimitRepository.findAll(pageableRequest);
        List<QuotRiskLimitEntity> quotRiskLimits = quotRiskLimitsPage.getContent();

        for(QuotRiskLimitEntity quotRiskLimitEntity: quotRiskLimits) {
            QuotRiskLimitDto quotRiskLimitDto = new QuotRiskLimitDto();
            BeanUtils.copyProperties(quotRiskLimitEntity,  quotRiskLimitDto);
            returnValue.add(quotRiskLimitDto);
        }
        return returnValue;
    }
}
