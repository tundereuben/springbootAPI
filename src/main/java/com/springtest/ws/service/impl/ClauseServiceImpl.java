package com.springtest.ws.service.impl;

import com.springtest.ws.entity.ClauseEntity;
import com.springtest.ws.io.repositories.ClauseRepository;
import com.springtest.ws.service.ClauseService;
import com.springtest.ws.shared.dto.ClauseDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

//import com.springtest.ws.shared.dto.ClassDto;

@Service
public class ClauseServiceImpl implements ClauseService {

    @Autowired
    ClauseRepository clauseRepository;


    @Override
    public ClauseDto createClause(ClauseDto clause) {
        if(clauseRepository.findByClsCode(clause.getClsCode()) != null) throw new RuntimeException("Record already exist");

        ClauseEntity clauseEntity = new ClauseEntity();
        BeanUtils.copyProperties(clause, clauseEntity);

        ClauseEntity storedClauseDetails = clauseRepository.save(clauseEntity);

        ClauseDto returnValue = new ClauseDto();
        BeanUtils.copyProperties(storedClauseDetails, returnValue);

        return returnValue;
    }

    @Override
    public ClauseDto getClauseByClauseCode(int clsCode) {
        ClauseDto returnValue = new ClauseDto();
        ClauseEntity clauseEntity = clauseRepository.findByClsCode(clsCode);

        BeanUtils.copyProperties(clauseEntity, returnValue);

        return returnValue;
    }

    @Override
    public ClauseDto updtateClause(int clsCode, ClauseDto clause) {
        ClauseDto returnValue = new ClauseDto();
        ClauseEntity clauseEntity = clauseRepository.findByClsCode(clsCode);

        clauseEntity.setClsShtDesc(clause.getClsShtDesc());
        clauseEntity.setClsHeading(clause.getClsHeading());
        clauseEntity.setClsWording(clause.getClsWording());
        clauseEntity.setClsType(clause.getClsType());

        ClauseEntity updateClauseDetails = clauseRepository.save(clauseEntity);

        BeanUtils.copyProperties(updateClauseDetails, returnValue);

        return returnValue;
    }

    @Override
    public void deleteClause(int clsCode) {
        ClauseEntity clauseEntity = clauseRepository.findByClsCode(clsCode);

        clauseRepository.delete(clauseEntity);
    }

    @Override
    public List<ClauseDto> getClauses(int page, int limit) {
        List<ClauseDto> returnValue = new ArrayList<>();

        Pageable pageableRequest = PageRequest.of(page, limit);

        Page<ClauseEntity> clausesPage = clauseRepository.findAll(pageableRequest);
        List<ClauseEntity> clauses = clausesPage.getContent();

        for(ClauseEntity clauseEntity: clauses) {
            ClauseDto clauseDto = new ClauseDto();
            BeanUtils.copyProperties(clauseEntity, clauseDto);
            returnValue.add(clauseDto);
        }

        return returnValue;
    }
}

