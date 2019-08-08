package com.springtest.ws.service.impl;

import com.springtest.ws.entity.UnderwriterEntity;
import com.springtest.ws.io.repositories.UnderwriterRepository;
import com.springtest.ws.service.UnderwriterService;
import com.springtest.ws.shared.dto.UnderwriterDto;
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
public class UnderwriterServiceImpl implements UnderwriterService {

    @Autowired
    UnderwriterRepository underwriterRepository;

    @Override
    public UnderwriterDto createUnderwriter(UnderwriterDto underwriter) {
        if(underwriterRepository.findByUndCode(underwriter.getUndCode()) != null) throw new RuntimeException("Record already exist");

        UnderwriterEntity underwriterEntity = new UnderwriterEntity();
        BeanUtils.copyProperties(underwriter, underwriterEntity);

        UnderwriterEntity storedUnderwriterDetails = underwriterRepository.save(underwriterEntity);

        UnderwriterDto returnValue = new UnderwriterDto();
        BeanUtils.copyProperties(storedUnderwriterDetails, returnValue);

        return returnValue;
    }

    @Override
    public UnderwriterDto getUnderwriterByUndCode(long undCode) {
        UnderwriterDto returnValue = new UnderwriterDto();
        UnderwriterEntity underwriterEntity = underwriterRepository.findByUndCode(undCode);

        BeanUtils.copyProperties(underwriterEntity, returnValue);

        return returnValue;
    }

    @Override
    public UnderwriterDto updateUnderwriter(long undCode, UnderwriterDto underwriter) {
        UnderwriterDto returnValue = new UnderwriterDto();
        UnderwriterEntity underwriterEntity = underwriterRepository.findByUndCode(undCode);

        underwriterEntity.setUndTitle(underwriter.getUndTitle());
        underwriterEntity.setUndEmail(underwriter.getUndEmail());
        underwriterEntity.setUndOthernames(underwriter.getUndOthernames());
        underwriterEntity.setUndLastname(underwriter.getUndLastname());
        underwriterEntity.setUndMobile(underwriter.getUndMobile());
        underwriterEntity.setUndCompanyName(underwriter.getUndCompanyName());
        underwriterEntity.setUndCountry(underwriter.getUndCountry());
        underwriterEntity.setUndDescription(underwriter.getUndDescription());
        underwriterEntity.setUndDob(underwriter.getUndDob());
        underwriterEntity.setUndEmail(underwriter.getUndEmail());
        underwriterEntity.setUndGender(underwriter.getUndGender());
        underwriterEntity.setUndLeadDate(underwriter.getUndLeadDate());
        underwriterEntity.setUndOccupation(underwriter.getUndOccupation());
        underwriterEntity.setUndCity(underwriter.getUndCity());
        underwriterEntity.setUndPostalAddress(underwriter.getUndPostalAddress());
        underwriterEntity.setUndPostalCode(underwriter.getUndPostalCode());
        underwriterEntity.setUndSector(underwriter.getUndSector());
        underwriterEntity.setUndSource(underwriter.getUndSource());
        underwriterEntity.setUndType(underwriter.getUndType());
        underwriterEntity.setUndContactFirstname(underwriter.getUndContactFirstname());
        underwriterEntity.setUndContactLastname(underwriter.getUndLastname());
        underwriterEntity.setUndContactEmail(underwriter.getUndEmail());
        underwriterEntity.setUndContactMobile(underwriter.getUndMobile());
        underwriterEntity.setUndContactBirthday(underwriter.getUndContactBirthday());

        UnderwriterEntity updateUnderwriterDetails = underwriterRepository.save(underwriterEntity);

        BeanUtils.copyProperties(updateUnderwriterDetails, returnValue);

        return returnValue;
    }

    @Override
    public void deleteUnderwriter(long undCode) {
        UnderwriterEntity underwriterEntity = underwriterRepository.findByUndCode(undCode);

        underwriterRepository.delete(underwriterEntity);
    }

    @Override
    public List<UnderwriterDto> getUnderwriters(int page, int limit) {
        List<UnderwriterDto> returnValue = new ArrayList<>();

        Pageable pageableRequest = PageRequest.of(page, limit, Sort.by("undCode"));

        Page<UnderwriterEntity> underwritersPage = underwriterRepository.findAll(pageableRequest);
        List<UnderwriterEntity> underwriters = underwritersPage.getContent();

        for(UnderwriterEntity underwriterEntity: underwriters) {
            UnderwriterDto underwriterDto = new UnderwriterDto();
            BeanUtils.copyProperties(underwriterEntity, underwriterDto);
            returnValue.add(underwriterDto);
        }

        return returnValue;
    }
}
