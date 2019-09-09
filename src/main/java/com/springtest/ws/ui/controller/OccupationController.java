package com.springtest.ws.ui.controller;

import com.springtest.ws.service.OccupationService;
import com.springtest.ws.shared.dto.OccupationDto;
import com.springtest.ws.ui.model.response.OccupationRest;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("occupations") // http://localhost/:8080/occupations
public class OccupationController {

    @Autowired
    OccupationService occupationService;

    @GetMapping
    public List<OccupationRest> getOccupations(@RequestParam(value="page", defaultValue = "0") int page,
                                               @RequestParam(value="limit", defaultValue = "2500") int limit) {

        List<OccupationRest> returnValue = new ArrayList<>();

        List<OccupationDto> occupations = occupationService.getOccupations(page, limit);

        for(OccupationDto occupationDto : occupations) {
            OccupationRest occupationModel = new OccupationRest();
            BeanUtils.copyProperties(occupationDto, occupationModel);
            returnValue.add(occupationModel);
        }

        return returnValue;
    }
}
