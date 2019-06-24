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
import org.springframework.data.domain.Sort;
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
        quotRiskLimitEntity.setQrlCoverType(quotRiskLimit.getQrlCoverType());
        quotRiskLimitEntity.setQrlDesc(quotRiskLimit.getQrlDesc());
        quotRiskLimitEntity.setQrlDualBasis(quotRiskLimit.getQrlDualBasis());
        quotRiskLimitEntity.setQrlLimitAmt(quotRiskLimit.getQrlLimitAmt());
        quotRiskLimitEntity.setQrlPremAmt(quotRiskLimit.getQrlPremAmt());
        quotRiskLimitEntity.setQrlPremRate(quotRiskLimit.getQrlPremRate());
        quotRiskLimitEntity.setQrlRateDesc(quotRiskLimit.getQrlRateDesc());
        quotRiskLimitEntity.setQrlRateDivFactor(quotRiskLimit.getQrlRateDivFactor());
        quotRiskLimitEntity.setQrlRateType(quotRiskLimit.getQrlRateType());
        quotRiskLimitEntity.setQrlSectCode(quotRiskLimit.getQrlSectCode());
        quotRiskLimitEntity.setQrlSectShtDesc(quotRiskLimit.getQrlSectShtDesc());
        quotRiskLimitEntity.setQrlSectType(quotRiskLimit.getQrlSectType());

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

        Pageable pageableRequest = PageRequest.of(page, limit, Sort.by("qrlCode").descending());

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
