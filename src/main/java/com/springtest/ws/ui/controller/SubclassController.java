package com.springtest.ws.ui.controller;

import com.springtest.ws.service.SubclassService;
import com.springtest.ws.shared.dto.SubclassDto;
import com.springtest.ws.ui.model.request.SubclassDetailsRequestModel;
import com.springtest.ws.ui.model.response.OperationStatusModel;
import com.springtest.ws.ui.model.response.RequestOperationName;
import com.springtest.ws.ui.model.response.RequestOperationStatus;
import com.springtest.ws.ui.model.response.SubclassRest;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("subclasses") // http://localhost/:8080/subclasses
public class SubclassController {

    @Autowired
    SubclassService subclassService;

    @GetMapping (path="/{id}")
    public SubclassRest getSubclass(@PathVariable int id) {
        SubclassRest returnValue = new SubclassRest();

        SubclassDto subclassDto = subclassService.getSubclassBySubclassCode(id);
        BeanUtils.copyProperties(subclassDto, returnValue);

        return returnValue;
    }

    @PostMapping
    public SubclassRest createSubclass(@RequestBody SubclassDetailsRequestModel subclassDetails) {
        SubclassRest returnValue = new SubclassRest();

        SubclassDto subclassDto = new SubclassDto();
        BeanUtils.copyProperties(subclassDetails, subclassDto);

        SubclassDto createdSubclass = subclassService.createSubclass(subclassDto);
        BeanUtils.copyProperties(createdSubclass, returnValue);

        return returnValue;
    }

    @PutMapping(path="/{id}")
    public SubclassRest updateSubclass(@PathVariable int id, @RequestBody SubclassDetailsRequestModel subclassDetails) {
        SubclassRest returnValue = new SubclassRest();

        SubclassDto subclassDto = new SubclassDto();
        BeanUtils.copyProperties(subclassDetails, subclassDto);

        SubclassDto updatedSubclass = subclassService.updateSubclass(id, subclassDto);
        BeanUtils.copyProperties(updatedSubclass, returnValue);

        return returnValue;
    }

    @DeleteMapping(path="/{id}")
    public OperationStatusModel deleteSubclass(@PathVariable int id) {
        OperationStatusModel returnValue = new OperationStatusModel();

        returnValue.setOperationName(RequestOperationName.DELETE.name());
        returnValue.setOperationResult(RequestOperationStatus.SUCCESS.name());

        subclassService.deleteSubclass(id);

        return returnValue;
    }

    @GetMapping
    public List<SubclassRest> getSubclasses(@RequestParam(value="page", defaultValue = "0") int page,
                                            @RequestParam(value="limit", defaultValue = "100") int limit) {

        List<SubclassRest> returnValue = new ArrayList<>();

        List<SubclassDto> subclasses = subclassService.getSubclasses(page, limit);

        for(SubclassDto subclassDto : subclasses) {
            SubclassRest subclassModel = new SubclassRest();
            BeanUtils.copyProperties(subclassDto, subclassModel);
            returnValue.add(subclassModel);
        }

        return returnValue;
    }
}
