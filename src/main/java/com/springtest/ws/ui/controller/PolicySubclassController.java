package com.springtest.ws.ui.controller;

import com.springtest.ws.entity.PolicySubclassEntity;
import com.springtest.ws.service.PolicySubclassService;
import com.springtest.ws.shared.dto.PolicySubclassDto;
import com.springtest.ws.ui.model.request.PolicySubclassDetailsRequestModel;
import com.springtest.ws.ui.model.response.OperationStatusModel;
import com.springtest.ws.ui.model.response.PolicySubclassRest;
import com.springtest.ws.ui.model.response.RequestOperationName;
import com.springtest.ws.ui.model.response.RequestOperationStatus;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("subclasses") // http://localhost/:8080/subclasses
public class PolicySubclassController {

    @Autowired
    PolicySubclassService policySubclassService;

    @GetMapping (path="/{id}")
    public PolicySubclassRest getSubclass(@PathVariable int id) {
        PolicySubclassRest returnValue = new PolicySubclassRest();

        PolicySubclassDto policySubclassDto = policySubclassService.getSubclassBySubclassCode(id);
        BeanUtils.copyProperties(policySubclassDto, returnValue);

        return returnValue;
    }

    @PostMapping
    public PolicySubclassRest createSubclass(@RequestBody PolicySubclassDetailsRequestModel subclassDetails) {
        PolicySubclassRest returnValue = new PolicySubclassRest();

        PolicySubclassDto policySubclassDto = new PolicySubclassDto();
        BeanUtils.copyProperties(subclassDetails, policySubclassDto);

        PolicySubclassDto createdSubclass = policySubclassService.createSubclass(policySubclassDto);
        BeanUtils.copyProperties(createdSubclass, returnValue);

        return returnValue;
    }

    @PutMapping(path="/{id}")
    public PolicySubclassRest updateSubclass(@PathVariable int id, @RequestBody PolicySubclassDetailsRequestModel subclassDetails) {
        PolicySubclassRest returnValue = new PolicySubclassRest();

        PolicySubclassDto policySubclassDto = new PolicySubclassDto();
        BeanUtils.copyProperties(subclassDetails, policySubclassDto);

        PolicySubclassDto updatedSubclass = policySubclassService.updateSubclass(id, policySubclassDto);
        BeanUtils.copyProperties(updatedSubclass, returnValue);

        return returnValue;
    }

    @DeleteMapping(path="/{id}")
    public OperationStatusModel deleteSubclass(@PathVariable int id) {
        OperationStatusModel returnValue = new OperationStatusModel();

        returnValue.setOperationName(RequestOperationName.DELETE.name());
        returnValue.setOperationResult(RequestOperationStatus.SUCCESS.name());

        policySubclassService.deleteSubclass(id);

        return returnValue;
    }

    @GetMapping
    public List<PolicySubclassRest> getSubclasses(@RequestParam(value="page", defaultValue = "0") int page,
                                                  @RequestParam(value="limit", defaultValue = "100") int limit) {

        List<PolicySubclassRest> returnValue = new ArrayList<>();

        List<PolicySubclassDto> subclasses = policySubclassService.getSubclasses(page, limit);

        for(PolicySubclassDto policySubclassDto : subclasses) {
            PolicySubclassRest subclassModel = new PolicySubclassRest();
            BeanUtils.copyProperties(policySubclassDto, subclassModel);
            returnValue.add(subclassModel);
        }

        return returnValue;
    }

    @GetMapping(path="polCode")
    public List<PolicySubclassEntity> getSubclassesByPolicyCode(@RequestParam(value = "polCode") final int sclPolCode){

        return policySubclassService.getPolicySubclasses(sclPolCode);
    }
}
