package com.springtest.ws.ui.controller;

import com.springtest.ws.service.PolicyService;
import com.springtest.ws.shared.dto.PolicyDto;
import com.springtest.ws.ui.model.request.PolicyDetailsRequestModel;
import com.springtest.ws.ui.model.response.OperationStatusModel;
import com.springtest.ws.ui.model.response.PolicyRest;
import com.springtest.ws.ui.model.response.RequestOperationName;
import com.springtest.ws.ui.model.response.RequestOperationStatus;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("policies") // http://localhost/:8080/policies
public class PolicyController {

    @Autowired
    PolicyService policyService;

    @GetMapping(path="/{id}")
    public PolicyRest getPolicy(@PathVariable int id) {
        PolicyRest returnValue = new PolicyRest();

        PolicyDto policyDto = policyService.getPolicyByPolicyCode(id);
        BeanUtils.copyProperties(policyDto, returnValue);

        return returnValue;
    }

    @PostMapping
    public PolicyRest createPolicy(@RequestBody PolicyDetailsRequestModel policyDetails) {
        PolicyRest returnValue = new PolicyRest();

        PolicyDto policyDto = new PolicyDto();
        BeanUtils.copyProperties(policyDetails, policyDto);

        PolicyDto createdPolicy = policyService.createPolicy(policyDto);
        BeanUtils.copyProperties(createdPolicy, returnValue);

        return returnValue;
    }

    @PutMapping(path="/{id}")
    public PolicyRest updatePolicy(@PathVariable int id, @RequestBody PolicyDetailsRequestModel policyDetails) {
        PolicyRest returnValue = new PolicyRest();

        PolicyDto policyDto = new PolicyDto();
        BeanUtils.copyProperties(policyDetails, policyDto);

        PolicyDto updatedPolicy = policyService.updatePolicy(id, policyDto);
        BeanUtils.copyProperties(updatedPolicy, returnValue);

        return returnValue;
    }

    @DeleteMapping(path="/{id}")
    public OperationStatusModel deletePolicy(@PathVariable int id) {
        OperationStatusModel returnValue = new OperationStatusModel();

        returnValue.setOperationName(RequestOperationName.DELETE.name());
        returnValue.setOperationResult(RequestOperationStatus.SUCCESS.name());

        policyService.deletePolicy(id);

        return returnValue;
    }

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE })
    public List<PolicyRest> getPolicies(@RequestParam(value="page", defaultValue = "0") int page,
                                      @RequestParam(value="limit", defaultValue = "25") int limit) {

        List<PolicyRest> returnValue = new ArrayList<>();

        List<PolicyDto> policies = policyService.getPolicies(page, limit);

        for(PolicyDto policyDto : policies) {
            PolicyRest policyModel = new PolicyRest();
            BeanUtils.copyProperties(policyDto, policyModel);
            returnValue.add(policyModel);
        }

        return returnValue;
    }
}
