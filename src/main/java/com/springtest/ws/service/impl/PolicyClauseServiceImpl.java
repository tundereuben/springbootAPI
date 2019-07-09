package com.springtest.ws.service.impl;

import com.springtest.ws.entity.PolicyClauseEntity;
import com.springtest.ws.io.repositories.PolicyClauseRepository;
import com.springtest.ws.service.PolicyClauseService;
import com.springtest.ws.shared.dto.PolicyClauseDto;
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
public class PolicyClauseServiceImpl implements PolicyClauseService {

    @Autowired
    PolicyClauseRepository policyClauseRepository;


    @Override
    public PolicyClauseDto createClause(PolicyClauseDto clause) {
        if(policyClauseRepository.findByClsCode(clause.getClsCode()) != null) throw new RuntimeException("Record already exist");

        PolicyClauseEntity policyClauseEntity = new PolicyClauseEntity();
        BeanUtils.copyProperties(clause, policyClauseEntity);

        PolicyClauseEntity storedClauseDetails = policyClauseRepository.save(policyClauseEntity);

        PolicyClauseDto returnValue = new PolicyClauseDto();
        BeanUtils.copyProperties(storedClauseDetails, returnValue);

        return returnValue;
    }

    @Override
    public PolicyClauseDto getClauseByClauseCode(int clsCode) {
        PolicyClauseDto returnValue = new PolicyClauseDto();
        PolicyClauseEntity policyClauseEntity = policyClauseRepository.findByClsCode(clsCode);

        BeanUtils.copyProperties(policyClauseEntity, returnValue);

        return returnValue;
    }

    @Override
    public PolicyClauseDto updateClause(int clsCode, PolicyClauseDto clause) {
        PolicyClauseDto returnValue = new PolicyClauseDto();
        PolicyClauseEntity policyClauseEntity = policyClauseRepository.findByClsCode(clsCode);

        policyClauseEntity.setClsCode(clause.getClsCode());
        policyClauseEntity.setClsName(clause.getClsName());

        PolicyClauseEntity updateClauseDetails = policyClauseRepository.save(policyClauseEntity);

        BeanUtils.copyProperties(updateClauseDetails, returnValue);

        return returnValue;
    }

    @Override
    public void deleteClause(int clsCode) {
        PolicyClauseEntity policyClauseEntity = policyClauseRepository.findByClsCode(clsCode);

        policyClauseRepository.delete(policyClauseEntity);
    }

    @Override
    public List<PolicyClauseDto> getClauses(int page, int limit) {
        List<PolicyClauseDto> returnValue = new ArrayList<>();

        Pageable pageableRequest = PageRequest.of(page, limit, Sort.by("clsCode"));

        Page<PolicyClauseEntity> clausesPage = policyClauseRepository.findAll(pageableRequest);
        List<PolicyClauseEntity> clauses = clausesPage.getContent();

        for(PolicyClauseEntity policyClauseEntity : clauses) {
            PolicyClauseDto policyClauseDto = new PolicyClauseDto();
            BeanUtils.copyProperties(policyClauseEntity, policyClauseDto);
            returnValue.add(policyClauseDto);
        }

        return returnValue;
    }
}

