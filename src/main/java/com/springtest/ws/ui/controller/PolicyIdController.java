package com.springtest.ws.ui.controller;

import com.springtest.ws.service.PolicyIdService;
import com.springtest.ws.shared.dto.PolicyIdDto;
import com.springtest.ws.ui.model.request.PolicyIdDetailsRequestModel;
import com.springtest.ws.ui.model.response.PolicyIdRest;
import com.springtest.ws.ui.model.response.OperationStatusModel;
import com.springtest.ws.ui.model.response.RequestOperationName;
import com.springtest.ws.ui.model.response.RequestOperationStatus;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("ids") // http://localhost/:8080/ids
public class PolicyIdController {
    @Autowired
    PolicyIdService policyIdService;

    @GetMapping(path="/{id}")
    public PolicyIdRest getId(@PathVariable int id) {
        PolicyIdRest returnValue = new PolicyIdRest();

        PolicyIdDto policyIdDto = policyIdService.getIdByIdCode(id);
        BeanUtils.copyProperties(policyIdDto, returnValue);

        return returnValue;
    }

    @PostMapping()
    public PolicyIdRest createId(@RequestBody PolicyIdDetailsRequestModel idDetails) {
        PolicyIdRest returnValue = new PolicyIdRest();

        PolicyIdDto policyIdDto = new PolicyIdDto();
        BeanUtils.copyProperties(idDetails, policyIdDto);

        PolicyIdDto createdId = policyIdService.createId(policyIdDto);
        BeanUtils.copyProperties(createdId, returnValue);

        return returnValue;
    }

    @PutMapping(path="/{id}")
    public PolicyIdRest updateId(@PathVariable int id, @RequestBody PolicyIdDetailsRequestModel idDetails) {
        PolicyIdRest returnValue = new PolicyIdRest();

        PolicyIdDto policyIdDto = new PolicyIdDto();
        BeanUtils.copyProperties(idDetails, policyIdDto);

        PolicyIdDto updatedId = policyIdService.updateId(id, policyIdDto);
        BeanUtils.copyProperties(updatedId, returnValue);

        return returnValue;
    }

    @DeleteMapping(path="/{id}")
    public OperationStatusModel deleteId(@PathVariable int id) {
        OperationStatusModel returnValue = new OperationStatusModel();

        returnValue.setOperationName(RequestOperationName.DELETE.name());
        returnValue.setOperationResult(RequestOperationStatus.SUCCESS.name());

        policyIdService.deleteId(id);

        return returnValue;
    }

    @GetMapping()
    public List<PolicyIdRest> getIds(@RequestParam(value="page", defaultValue = "0") int page,
                                     @RequestParam(value="limit", defaultValue = "25") int limit) {

        List<PolicyIdRest> returnValue = new ArrayList<>();

        List<PolicyIdDto> ids = policyIdService.getIds(page, limit);

        for(PolicyIdDto policyIdDto : ids) {
            PolicyIdRest idModel = new PolicyIdRest();
            BeanUtils.copyProperties(policyIdDto, idModel);
            returnValue.add(idModel);
        }

        return returnValue;
    }
}
