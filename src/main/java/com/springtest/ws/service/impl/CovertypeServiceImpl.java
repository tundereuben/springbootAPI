package com.springtest.ws.service.impl;

import com.springtest.ws.entity.CovertypeEntity;
import com.springtest.ws.io.repositories.CovertypeRepository;
import com.springtest.ws.service.CovertypeService;
import com.springtest.ws.shared.dto.CovertypeDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CovertypeServiceImpl implements CovertypeService {

    @Autowired
    CovertypeRepository covertypeRepository;


    @Override
    public CovertypeDto createCovertype(CovertypeDto covertype) {
        if(covertypeRepository.findByCovtCode(covertype.getCovtCode()) != null) throw new RuntimeException("Record already exists");

        CovertypeEntity covertypeEntity = new CovertypeEntity();
        BeanUtils.copyProperties(covertype, covertypeEntity);

        CovertypeEntity storedCovertypeDetails = covertypeRepository.save(covertypeEntity);

        CovertypeDto returnValue = new CovertypeDto();
        BeanUtils.copyProperties(storedCovertypeDetails, returnValue);

        return returnValue;
    }

    @Override
    public CovertypeDto getCovertypeByCovertypeCode(int covtCode) {
        CovertypeDto returnValue = new CovertypeDto();
        CovertypeEntity covertypeEntity = covertypeRepository.findByCovtCode(covtCode);

        BeanUtils.copyProperties(covertypeEntity, returnValue);

        return returnValue;
    }

    @Override
    public CovertypeDto updtateCovertype(int covtCode, CovertypeDto covertype) {
        CovertypeDto returnValue = new CovertypeDto();
        CovertypeEntity covertypeEntity = covertypeRepository.findByCovtCode(covtCode);

        covertypeEntity.setCovtCode(covertype.getCovtCode());
        covertypeEntity.setCovtDesc(covertype.getCovtDesc());
        covertypeEntity.setCovtShtDesc(covertype.getCovtShtDesc());

        CovertypeEntity updatedCovertypeDetails = covertypeRepository.save(covertypeEntity);

        BeanUtils.copyProperties(updatedCovertypeDetails, returnValue);

        return returnValue;
    }

    @Override
    public void deleteCovertype(int covtCode) {
        CovertypeEntity covertypeEntity = covertypeRepository.findByCovtCode(covtCode);

        covertypeRepository.delete(covertypeEntity);
    }

    @Override
    public List<CovertypeDto> getCovertypes(int page, int limit) {
        List<CovertypeDto> returnValue = new ArrayList<>();

        Pageable pageableRequest = PageRequest.of(page, limit);

        Page<CovertypeEntity> covertypesPage = covertypeRepository.findAll(pageableRequest);
        List<CovertypeEntity> covertypes = covertypesPage.getContent();

        for(CovertypeEntity covertypeEntity: covertypes) {
            CovertypeDto covertypeDto = new CovertypeDto();
            BeanUtils.copyProperties(covertypeEntity, covertypeDto);
            returnValue.add(covertypeDto);
        }

        return returnValue;
    }
}
