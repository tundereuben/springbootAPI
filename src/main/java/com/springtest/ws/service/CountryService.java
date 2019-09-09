package com.springtest.ws.service;

import com.springtest.ws.shared.dto.CountryDto;

import java.util.List;

public interface CountryService {
    List<CountryDto> getCountries(int page, int limit);
}
