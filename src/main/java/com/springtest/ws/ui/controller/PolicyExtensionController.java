package com.springtest.ws.ui.controller;

import com.springtest.ws.entity.PolicyExtensionEntity;
import com.springtest.ws.service.PolicyExtensionService;
import com.springtest.ws.shared.dto.PolicyExtensionDto;
import com.springtest.ws.ui.model.request.PolicyExtensionDetailsRequestModel;
import com.springtest.ws.ui.model.response.OperationStatusModel;
import com.springtest.ws.ui.model.response.PolicyExtensionRest;
import com.springtest.ws.ui.model.response.RequestOperationName;
import com.springtest.ws.ui.model.response.RequestOperationStatus;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("extensions") // http://localhost/:8080/extensions
public class PolicyExtensionController {

    @Autowired
    PolicyExtensionService policyExtensionService;

    @GetMapping(path="/{id}")
    public PolicyExtensionRest getExtension(@PathVariable int id) {
        PolicyExtensionRest returnValue = new PolicyExtensionRest();

        PolicyExtensionDto policyExtensionDto = policyExtensionService.getExtensionByExtensionCode(id);
        BeanUtils.copyProperties(policyExtensionDto, returnValue);

        return returnValue;
    }

    @PostMapping
    public PolicyExtensionRest createExtension(@RequestBody PolicyExtensionDetailsRequestModel extensionDetails) {
        PolicyExtensionRest returnValue = new PolicyExtensionRest();

        PolicyExtensionDto policyExtensionDto = new PolicyExtensionDto();
        BeanUtils.copyProperties(extensionDetails, policyExtensionDto);

        PolicyExtensionDto createdClass = policyExtensionService.createExtension(policyExtensionDto);
        BeanUtils.copyProperties(createdClass, returnValue);

        return returnValue;
    }

    @PutMapping(path="/{id}")
    public PolicyExtensionRest updateExtension(@PathVariable int id, @RequestBody PolicyExtensionDetailsRequestModel extensionDetails) {
        PolicyExtensionRest returnValue = new PolicyExtensionRest();

        PolicyExtensionDto policyExtensionDto = new PolicyExtensionDto();
        BeanUtils.copyProperties(extensionDetails, policyExtensionDto);

        PolicyExtensionDto updatedExtension = policyExtensionService.updateExtension(id, policyExtensionDto);
        BeanUtils.copyProperties(updatedExtension, returnValue);

        return returnValue;
    }

    @DeleteMapping(path="/{id}")
    public OperationStatusModel deleteExtension(@PathVariable int id) {
        OperationStatusModel returnValue = new OperationStatusModel();

        returnValue.setOperationName(RequestOperationName.DELETE.name());
        returnValue.setOperationResult(RequestOperationStatus.SUCCESS.name());

        policyExtensionService.deleteExtension(id);

        return returnValue;
    }

    @GetMapping
    public List<PolicyExtensionRest> getExtensions(@RequestParam(value="page", defaultValue = "0") int page,
                                                @RequestParam(value="limit", defaultValue = "25") int limit) {

        List<PolicyExtensionRest> returnValue = new ArrayList<>();

        List<PolicyExtensionDto> extensions = policyExtensionService.getExtensions(page, limit);

        for(PolicyExtensionDto policyExtensionDto : extensions) {
            PolicyExtensionRest extensionModel = new PolicyExtensionRest();
            BeanUtils.copyProperties(policyExtensionDto, extensionModel);
            returnValue.add(extensionModel);
        }

        return returnValue;
    }

    @GetMapping(path="polCode")
    public List<PolicyExtensionEntity> getExtensionsByPolicyCode(@RequestParam(value = "polCode") final int extPolCode){

        return policyExtensionService.getPolicyExtensions(extPolCode);
    }

    @GetMapping(path="sclCode")
    public List<PolicyExtensionEntity> getExtensionsBySclCode(@RequestParam(value = "sclCode") final int extSclCode){

        return policyExtensionService.getPolicyExtensionsBySclCode(extSclCode);
    }
}
