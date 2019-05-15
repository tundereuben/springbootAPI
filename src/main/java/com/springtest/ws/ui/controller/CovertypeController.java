package com.springtest.ws.ui.controller;

import com.springtest.ws.service.CovertypeService;
import com.springtest.ws.shared.dto.CovertypeDto;
import com.springtest.ws.ui.model.request.CovertypeDetailsRequestModel;
import com.springtest.ws.ui.model.response.CovertypeRest;
import com.springtest.ws.ui.model.response.OperationStatusModel;
import com.springtest.ws.ui.model.response.RequestOperationName;
import com.springtest.ws.ui.model.response.RequestOperationStatus;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("covertypes") // http://localhost/:8080/covertypes
public class CovertypeController {

    @Autowired
    CovertypeService covertypeService;

    @GetMapping (path="/{id}")
    public CovertypeRest getCovertpe(@PathVariable int id) {
        CovertypeRest returnValue = new CovertypeRest();

        CovertypeDto covertypeDto = covertypeService.getCovertypeByCovertypeCode(id);
        BeanUtils.copyProperties(covertypeDto, returnValue);

        return returnValue;
    }

    @PostMapping
    public CovertypeRest createCovertype(@RequestBody CovertypeDetailsRequestModel covertypeDetails) {
        CovertypeRest returnValue = new CovertypeRest();

        CovertypeDto covertypeDto = new CovertypeDto();
        BeanUtils.copyProperties(covertypeDetails, covertypeDto);

        CovertypeDto createdCovertype = covertypeService.createCovertype(covertypeDto);
        BeanUtils.copyProperties(createdCovertype, returnValue);

        return returnValue;
    }

    @PutMapping (path="/{id}")
    public CovertypeRest updateCovertype(@PathVariable int id, @RequestBody CovertypeDetailsRequestModel covertypeDetails) {
        CovertypeRest returnValue = new CovertypeRest();

        CovertypeDto covertypeDto = new CovertypeDto();
        BeanUtils.copyProperties(covertypeDetails, covertypeDto);

        CovertypeDto updatedCovertype = covertypeService.updtateCovertype(id, covertypeDto);
        BeanUtils.copyProperties(updatedCovertype, returnValue);

        return returnValue;
    }


    @DeleteMapping(path="/{id}")
    public OperationStatusModel deleteCovertype(@PathVariable int id) {
        OperationStatusModel returnValue = new OperationStatusModel();

        returnValue.setOperationName(RequestOperationName.DELETE.name());
        returnValue.setOperationResult(RequestOperationStatus.SUCCESS.name());

        covertypeService.deleteCovertype(id);

        return returnValue;
    }

    @GetMapping
    public List<CovertypeRest> getCovertypes(@RequestParam(value="page", defaultValue = "0") int page,
                                            @RequestParam(value="limit", defaultValue = "25") int limit) {

        List<CovertypeRest> returnValue = new ArrayList<>();

        List<CovertypeDto> covertypes = covertypeService.getCovertypes(page, limit);

        for(CovertypeDto covertypeDto : covertypes) {
            CovertypeRest covertypeModel = new CovertypeRest();
            BeanUtils.copyProperties(covertypeDto, covertypeModel);
            returnValue.add(covertypeModel);
        }

        return returnValue;
    }

}
