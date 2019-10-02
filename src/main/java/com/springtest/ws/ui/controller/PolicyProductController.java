package com.springtest.ws.ui.controller;

import com.springtest.ws.entity.PolicyProductEntity;
import com.springtest.ws.service.PolicyProductService;
import com.springtest.ws.shared.dto.PolicyProductDto;
import com.springtest.ws.ui.model.request.PolicyProductDetailsRequestModel;
import com.springtest.ws.ui.model.response.OperationStatusModel;
import com.springtest.ws.ui.model.response.PolicyProductRest;
import com.springtest.ws.ui.model.response.RequestOperationName;
import com.springtest.ws.ui.model.response.RequestOperationStatus;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("polproducts") // http://localhost/:8080/subclasses
public class PolicyProductController {

    @Autowired
    PolicyProductService policyProductService;

    @GetMapping (path="/{id}")
    public PolicyProductRest getSubclass(@PathVariable int id) {
        PolicyProductRest returnValue = new PolicyProductRest();

        PolicyProductDto policyProductDto = policyProductService.getSubclassBySubclassCode(id);
        BeanUtils.copyProperties(policyProductDto, returnValue);

        return returnValue;
    }

    @PostMapping
    public PolicyProductRest createSubclass(@RequestBody PolicyProductDetailsRequestModel subclassDetails) {
        PolicyProductRest returnValue = new PolicyProductRest();

        PolicyProductDto policyProductDto = new PolicyProductDto();
        BeanUtils.copyProperties(subclassDetails, policyProductDto);

        PolicyProductDto createdSubclass = policyProductService.createSubclass(policyProductDto);
        BeanUtils.copyProperties(createdSubclass, returnValue);

        return returnValue;
    }

    @PutMapping(path="/{id}")
    public PolicyProductRest updateSubclass(@PathVariable int id, @RequestBody PolicyProductDetailsRequestModel subclassDetails) {
        PolicyProductRest returnValue = new PolicyProductRest();

        PolicyProductDto policyProductDto = new PolicyProductDto();
        BeanUtils.copyProperties(subclassDetails, policyProductDto);

        PolicyProductDto updatedSubclass = policyProductService.updateSubclass(id, policyProductDto);
        BeanUtils.copyProperties(updatedSubclass, returnValue);

        return returnValue;
    }

    @DeleteMapping(path="/{id}")
    public OperationStatusModel deleteSubclass(@PathVariable int id) {
        OperationStatusModel returnValue = new OperationStatusModel();

        returnValue.setOperationName(RequestOperationName.DELETE.name());
        returnValue.setOperationResult(RequestOperationStatus.SUCCESS.name());

        policyProductService.deleteSubclass(id);

        return returnValue;
    }

    @GetMapping
    public List<PolicyProductRest> getSubclasses(@RequestParam(value="page", defaultValue = "0") int page,
                                                 @RequestParam(value="limit", defaultValue = "100") int limit) {

        List<PolicyProductRest> returnValue = new ArrayList<>();

        List<PolicyProductDto> subclasses = policyProductService.getSubclasses(page, limit);

        for(PolicyProductDto policyProductDto : subclasses) {
            PolicyProductRest subclassModel = new PolicyProductRest();
            BeanUtils.copyProperties(policyProductDto, subclassModel);
            returnValue.add(subclassModel);
        }

        return returnValue;
    }

    @GetMapping(path="polCode")
    public List<PolicyProductEntity> getSubclassesByPolicyCode(@RequestParam(value = "polCode") final int sclPolCode){

        return policyProductService.getPolicySubclasses(sclPolCode);
    }
}
