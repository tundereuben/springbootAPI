package com.springtest.ws.service.impl;

import com.springtest.ws.entity.CountryEntity;
import com.springtest.ws.io.repositories.CountryRepository;
import com.springtest.ws.service.CountryService;
import com.springtest.ws.shared.dto.CountryDto;
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
public class CountryServiceImpl implements CountryService {

    @Autowired
    CountryRepository countryRepository;

    @Override
    public List<CountryDto> getCountries(int page, int limit) {
        List<CountryDto> returnValue = new ArrayList<>();

        Pageable pageableRequest = PageRequest.of(page, limit, Sort.by("couCode"));

        Page<CountryEntity> countriesPage = countryRepository.findAll(pageableRequest);
        List<CountryEntity> countries = countriesPage.getContent();

        for(CountryEntity countryEntity: countries) {
            CountryDto countryDto = new CountryDto();
            BeanUtils.copyProperties(countryEntity, countryDto);
            returnValue.add(countryDto);
        }

        return returnValue;
    }
}
