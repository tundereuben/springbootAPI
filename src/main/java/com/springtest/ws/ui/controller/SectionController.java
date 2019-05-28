package com.springtest.ws.ui.controller;

import com.springtest.ws.service.SectionService;
import com.springtest.ws.shared.dto.SectionDto;
import com.springtest.ws.ui.model.request.SectionDetailsRequestModel;
import com.springtest.ws.ui.model.response.OperationStatusModel;
import com.springtest.ws.ui.model.response.RequestOperationName;
import com.springtest.ws.ui.model.response.RequestOperationStatus;
import com.springtest.ws.ui.model.response.SectionRest;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping ("sections") // http://localhost/:8080/sections
public class SectionController {

    @Autowired
    SectionService sectionService;

    @GetMapping (path="/{id}")
    public SectionRest getSection(@PathVariable int id) {
        SectionRest returnValue = new SectionRest();

        SectionDto sectionDto = sectionService.getSectionBySectionCode(id);
        BeanUtils.copyProperties(sectionDto, returnValue);

        return returnValue;
    }

    @PostMapping
    public SectionRest createSection(@RequestBody SectionDetailsRequestModel sectionDetails) {
        SectionRest returnValue = new SectionRest();

        SectionDto sectionDto = new SectionDto();
        BeanUtils.copyProperties(sectionDetails, sectionDto);

        SectionDto createdSection = sectionService.createSection(sectionDto);
        BeanUtils.copyProperties(createdSection, returnValue);

        return returnValue;
    }

    @PutMapping (path="/{id}")
    public SectionRest upateSection(@PathVariable int id, @RequestBody SectionDetailsRequestModel sectionDetails) {
        SectionRest returnValue = new SectionRest();

        SectionDto sectionDto = new SectionDto();
        BeanUtils.copyProperties(sectionDetails, sectionDto);

        SectionDto updatedSection = sectionService.updateSection(id, sectionDto);
        BeanUtils.copyProperties(updatedSection, returnValue);

        return returnValue;
    }

    @DeleteMapping(path="/{id}")
    public OperationStatusModel deleteSection(@PathVariable int id) {
        OperationStatusModel returnValue = new OperationStatusModel();

        returnValue.setOperationName(RequestOperationName.DELETE.name());
        returnValue.setOperationResult(RequestOperationStatus.SUCCESS.name());

        sectionService.deleteSection(id);

        return returnValue;
    }

    @GetMapping
    public List<SectionRest> getSections(@RequestParam(value="page", defaultValue = "0") int page,
                                         @RequestParam(value="limit", defaultValue = "500") int limit) {

        List<SectionRest> returnValue = new ArrayList<>();

        List<SectionDto> sections = sectionService.getSections(page, limit);

        for(SectionDto sectionDto : sections) {
            SectionRest sectionModel = new SectionRest();
            BeanUtils.copyProperties(sectionDto, sectionModel);
            returnValue.add(sectionModel);
        }

        return returnValue;
    }
}
