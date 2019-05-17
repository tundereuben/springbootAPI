package com.springtest.ws.service.impl;

import com.springtest.ws.entity.SectionEntity;
import com.springtest.ws.io.repositories.SectionRepository;
import com.springtest.ws.service.SectionService;
import com.springtest.ws.shared.dto.SectionDto;
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
public class SectionServiceImpl implements SectionService {

    @Autowired
    SectionRepository sectionRepository;

    @Override
    public SectionDto createSection(SectionDto section) {
        if(sectionRepository.findBySectCode(section.getSectCode()) != null) throw new RuntimeException("Record already exists");

        SectionEntity sectionEntity = new SectionEntity();
        BeanUtils.copyProperties(section, sectionEntity);

        SectionEntity storedSectionDetails = sectionRepository.save(sectionEntity);

        SectionDto returnValue = new SectionDto();
        BeanUtils.copyProperties(storedSectionDetails, returnValue);

        return returnValue;
    }

    @Override
    public SectionDto getSectionBySectionCode(int sectCode) {
        SectionDto returnValue = new SectionDto();
        SectionEntity sectionEntity = sectionRepository.findBySectCode(sectCode);

        BeanUtils.copyProperties(sectionEntity, returnValue);

        return returnValue;
    }

    @Override
    public SectionDto updateSection(int sectCode, SectionDto section) {
        SectionDto returnValue = new SectionDto();
        SectionEntity sectionEntity = sectionRepository.findBySectCode(sectCode);

        sectionEntity.setSectDesc(section.getSectDesc());
        sectionEntity.setSectShtDesc(section.getSectShtDesc());
        sectionEntity.setSectType(section.getSectType());

        SectionEntity updatedSectionDetails = sectionRepository.save(sectionEntity);

        BeanUtils.copyProperties(updatedSectionDetails, returnValue);

        return returnValue;
    }

    @Override
    public void deleteSection(int sectCode) {
        SectionEntity sectionEntity = sectionRepository.findBySectCode(sectCode);

        sectionRepository.delete(sectionEntity);

    }

    @Override
    public List<SectionDto> getSections(int page, int limit) {
        List<SectionDto> returnValue = new ArrayList<>();

        Pageable pageableRequest = PageRequest.of(page, limit, Sort.by("sectCode"));

        Page<SectionEntity> sectionsPage = sectionRepository.findAll(pageableRequest);
        List<SectionEntity> sections = sectionsPage.getContent();

        for(SectionEntity sectionEntity: sections) {
            SectionDto sectionDto = new SectionDto();
            BeanUtils.copyProperties(sectionEntity, sectionDto);
            returnValue.add(sectionDto);
        }

        return returnValue;
    }
}
