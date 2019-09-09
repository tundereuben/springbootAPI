package com.springtest.ws.ui.controller;

import com.springtest.ws.service.SectorService;
import com.springtest.ws.shared.dto.SectorDto;
import com.springtest.ws.ui.model.response.SectorRest;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("sectors") // http://localhost/:8080/sectors
public class SectorController {

    @Autowired
    SectorService sectorService;

    @GetMapping
    public List<SectorRest> getSectors(@RequestParam(value="page", defaultValue = "0") int page,
                                       @RequestParam(value="limit", defaultValue = "2500") int limit) {

        List<SectorRest> returnValue = new ArrayList<>();

        List<SectorDto> sectors = sectorService.getSectors(page, limit);

        for(SectorDto sectorDto : sectors) {
            SectorRest sectorModel = new SectorRest();
            BeanUtils.copyProperties(sectorDto, sectorModel);
            returnValue.add(sectorModel);
        }

        return returnValue;
    }
}
