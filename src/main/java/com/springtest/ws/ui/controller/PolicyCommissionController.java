package com.springtest.ws.ui.controller;

import com.springtest.ws.entity.PolicyCommissionEntity;
import com.springtest.ws.service.PolicyCommissionService;
import com.springtest.ws.shared.dto.PolicyCommissionDto;
import com.springtest.ws.ui.model.request.PolicyCommissionDetailsRequestModel;
import com.springtest.ws.ui.model.response.OperationStatusModel;
import com.springtest.ws.ui.model.response.PolicyCommissionRest;
import com.springtest.ws.ui.model.response.RequestOperationName;
import com.springtest.ws.ui.model.response.RequestOperationStatus;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("commissions") // http://localhost/:8080/commissions
public class PolicyCommissionController {

    @Autowired
    PolicyCommissionService policyCommissionService;

    @GetMapping(path="/{id}")
    public PolicyCommissionRest getCommission(@PathVariable int id){
        PolicyCommissionRest returnValue = new PolicyCommissionRest();

        PolicyCommissionDto policyCommissionDto = policyCommissionService.getCommByCommCode(id);
        BeanUtils.copyProperties(policyCommissionDto, returnValue);

        return returnValue;
    }

    @PostMapping()
    public PolicyCommissionRest createCommission(@RequestBody PolicyCommissionDetailsRequestModel commissionDetails) {
        PolicyCommissionRest returnValue = new PolicyCommissionRest();

        PolicyCommissionDto policyCommissionDto = new PolicyCommissionDto();
        BeanUtils.copyProperties(commissionDetails, policyCommissionDto);

        PolicyCommissionDto createdCommission = policyCommissionService.createCommission(policyCommissionDto);
        BeanUtils.copyProperties(createdCommission, returnValue);

        return returnValue;
    }

    @PutMapping(path="/{id}")
    public PolicyCommissionRest updateCommission(@PathVariable int id, @RequestBody PolicyCommissionDetailsRequestModel commissionDetails) {
        PolicyCommissionRest returnValue = new PolicyCommissionRest();

        PolicyCommissionDto policyCommissionDto = new PolicyCommissionDto();
        BeanUtils.copyProperties(commissionDetails, policyCommissionDto);

        PolicyCommissionDto updatedCommission = policyCommissionService.updateCommission(id, policyCommissionDto);
        BeanUtils.copyProperties(updatedCommission, returnValue);

        return returnValue;
    }

    @DeleteMapping(path="/{id}")
    public OperationStatusModel deleteCommission(@PathVariable int id) {
        OperationStatusModel returnValue = new OperationStatusModel();

        returnValue.setOperationName(RequestOperationName.DELETE.name());
        returnValue.setOperationResult(RequestOperationStatus.SUCCESS.name());

        policyCommissionService.deleteCommission(id);

        return returnValue;
    }

    @GetMapping()
    public List<PolicyCommissionRest> getCommissions(@RequestParam(value="page", defaultValue = "0") int page,
                                                     @RequestParam(value="limit", defaultValue = "25") int limit) {

        List<PolicyCommissionRest> returnValue = new ArrayList<>();

        List<PolicyCommissionDto> commissions = policyCommissionService.getCommissions(page, limit);

        for(PolicyCommissionDto policyCommissionDto : commissions) {
            PolicyCommissionRest commissionModel = new PolicyCommissionRest();
            BeanUtils.copyProperties(policyCommissionDto, commissionModel);
            returnValue.add(commissionModel);
        }

        return returnValue;
    }

    @GetMapping(path="polCode")
    public List<PolicyCommissionEntity> getCommissionsByPolicyCode(@RequestParam(value = "polCode") final int commPolCode){

        return policyCommissionService.getPolicyCommissions(commPolCode);
    }

    @GetMapping(path="sclCode")
    public List<PolicyCommissionEntity> getCommissionsBySclCode(@RequestParam(value = "sclCode") final int commSclCode){

        return policyCommissionService.getPolicyCommissionsBySubclassCode(commSclCode);
    }
}
