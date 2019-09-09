package com.springtest.ws.service.impl;

import com.springtest.ws.entity.OccupationEntity;
import com.springtest.ws.io.repositories.OccupationRepository;
import com.springtest.ws.service.OccupationService;
import com.springtest.ws.shared.dto.OccupationDto;
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
public class OccupationServiceImpl implements OccupationService{

    @Autowired
    OccupationRepository occupationRepository;

        @Override
        public List<OccupationDto> getOccupations(int page, int limit) {
            List<OccupationDto> returnValue = new ArrayList<>();

            Pageable pageableRequest = PageRequest.of(page, limit, Sort.by("occCode"));

            Page<OccupationEntity> occupationsPage = occupationRepository.findAll(pageableRequest);
            List<OccupationEntity> occupations = occupationsPage.getContent();

            for(OccupationEntity occupationEntity: occupations) {
                OccupationDto occupationDto = new OccupationDto();
                BeanUtils.copyProperties(occupationEntity, occupationDto);
                returnValue.add(occupationDto);
            }

            return returnValue;
        }
}
