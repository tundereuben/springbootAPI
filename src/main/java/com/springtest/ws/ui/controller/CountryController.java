package com.springtest.ws.ui.controller;

import com.springtest.ws.service.CountryService;
import com.springtest.ws.shared.dto.CountryDto;
import com.springtest.ws.ui.model.response.CountryRest;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("countries") // http://localhost/:8080/countries
public class CountryController {

    @Autowired
    CountryService countryService;

    @GetMapping
    public List<CountryRest> getCountries(@RequestParam(value="page", defaultValue = "0") int page,
                                          @RequestParam(value="limit", defaultValue = "2500") int limit) {

        List<CountryRest> returnValue = new ArrayList<>();

        List<CountryDto> countries = countryService.getCountries(page, limit);

        for(CountryDto countryDto : countries) {
            CountryRest countryModel = new CountryRest();
            BeanUtils.copyProperties(countryDto, countryModel);
            returnValue.add(countryModel);
        }

        return returnValue;
    }

}
