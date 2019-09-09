package com.springtest.ws.service.impl;

import com.springtest.ws.entity.SectorEntity;
import com.springtest.ws.io.repositories.SectorRepository;
import com.springtest.ws.service.SectorService;
import com.springtest.ws.shared.dto.SectorDto;
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
public class SectorServiceImpl implements SectorService {

    @Autowired
    SectorRepository sectorRepository;

    @Override
    public List<SectorDto> getSectors(int page, int limit) {
        List<SectorDto> returnValue = new ArrayList<>();

        Pageable pageableRequest = PageRequest.of(page, limit, Sort.by("secCode"));

        Page<SectorEntity> sectorsPage = sectorRepository.findAll(pageableRequest);
        List<SectorEntity> sectors = sectorsPage.getContent();

        for(SectorEntity sectorEntity: sectors) {
            SectorDto sectorDto = new SectorDto();
            BeanUtils.copyProperties(sectorEntity, sectorDto);
            returnValue.add(sectorDto);
        }

        return returnValue;
    }
}
