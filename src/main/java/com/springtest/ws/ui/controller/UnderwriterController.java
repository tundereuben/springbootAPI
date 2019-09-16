package com.springtest.ws.ui.controller;

import com.springtest.ws.entity.UnderwriterEntity;
import com.springtest.ws.service.UnderwriterService;
import com.springtest.ws.shared.dto.UnderwriterDto;
import com.springtest.ws.ui.model.request.UnderwriterDetailsRequestModel;
import com.springtest.ws.ui.model.response.OperationStatusModel;
import com.springtest.ws.ui.model.response.RequestOperationName;
import com.springtest.ws.ui.model.response.RequestOperationStatus;
import com.springtest.ws.ui.model.response.UnderwriterRest;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("underwriters") // http://localhost/:8080/underwriters
public class UnderwriterController {

    @Autowired
    UnderwriterService underwriterService;

    @GetMapping(path="/{id}")
    public UnderwriterRest getUnderwriter(@PathVariable int id) {
        UnderwriterRest returnValue = new UnderwriterRest();

        UnderwriterDto underwriterDto = underwriterService.getUnderwriterByUndCode(id);
        BeanUtils.copyProperties(underwriterDto, returnValue);

        return returnValue;
    }

    @PostMapping
    public UnderwriterRest createUnderwriter(@RequestBody UnderwriterDetailsRequestModel underwriterDetails) {
        UnderwriterRest returnValue = new UnderwriterRest();

        UnderwriterDto underwriterDto = new UnderwriterDto();
        BeanUtils.copyProperties(underwriterDetails, underwriterDto);

        UnderwriterDto createdUnderwriter = underwriterService.createUnderwriter(underwriterDto);
        BeanUtils.copyProperties(createdUnderwriter, returnValue);

        return returnValue;
    }

    @PutMapping(path="/{id}")
    public UnderwriterRest updateUnderwriter(@PathVariable int id, @RequestBody UnderwriterDetailsRequestModel underwriterDetails) {
        UnderwriterRest returnValue = new UnderwriterRest();

        UnderwriterDto underwriterDto = new UnderwriterDto();
        BeanUtils.copyProperties(underwriterDetails, underwriterDto);

        UnderwriterDto updatedUnderwriter = underwriterService.updateUnderwriter(id, underwriterDto);
        BeanUtils.copyProperties(updatedUnderwriter, returnValue);

        return returnValue;
    }

    @DeleteMapping(path="/{id}")
    public OperationStatusModel deleteUnderwriter(@PathVariable int id) {
        OperationStatusModel returnValue = new OperationStatusModel();

        returnValue.setOperationName(RequestOperationName.DELETE.name());
        returnValue.setOperationResult(RequestOperationStatus.SUCCESS.name());

        underwriterService.deleteUnderwriter(id);

        return returnValue;
    }

    @GetMapping
    public List<UnderwriterRest> getUnderwriters(@RequestParam(value="page", defaultValue = "0") int page,
                                                 @RequestParam(value="limit", defaultValue = "25") int limit) {

        List<UnderwriterRest> returnValue = new ArrayList<>();

        List<UnderwriterDto> underwriters = underwriterService.getUnderwriters(page, limit);

        for(UnderwriterDto underwriterDto : underwriters) {
            UnderwriterRest underwriterModel = new UnderwriterRest();
            BeanUtils.copyProperties(underwriterDto, underwriterModel);
            returnValue.add(underwriterModel);
        }

        return returnValue;
    }

    @GetMapping(path="undEmail")
    public List<UnderwriterEntity> getUnderwritersByEmail(@RequestParam(value="undEmail") final String undEmail ) {

        return underwriterService.getUnderwritersByEmail(undEmail);
    }

    @GetMapping(path="undCompanyName")
    public List<UnderwriterEntity> getUnderwritersName(@RequestParam(value="undCompanyName") final String undCompanyName ) {

        return underwriterService.getUnderwritersByName(undCompanyName);
    }
}
