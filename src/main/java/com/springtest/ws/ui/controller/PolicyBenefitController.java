package com.springtest.ws.ui.controller;

import com.springtest.ws.entity.PolicyBenefitEntity;
import com.springtest.ws.service.PolicyBenefitService;
import com.springtest.ws.shared.dto.PolicyBenefitDto;
import com.springtest.ws.ui.model.request.PolicyBenefitDetailsRequestModel;
import com.springtest.ws.ui.model.response.OperationStatusModel;
import com.springtest.ws.ui.model.response.PolicyBenefitRest;
import com.springtest.ws.ui.model.response.RequestOperationName;
import com.springtest.ws.ui.model.response.RequestOperationStatus;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("benefits") // http://localhost/:8080/benefits
public class PolicyBenefitController {

    @Autowired
    PolicyBenefitService policyBenefitService;

    @GetMapping(path="/{id}")
    public PolicyBenefitRest getBenefit(@PathVariable int id){
        PolicyBenefitRest returnValue = new PolicyBenefitRest();

        PolicyBenefitDto policyBenefitDto = policyBenefitService.getBftByBftCode(id);
        BeanUtils.copyProperties(policyBenefitDto, returnValue);

        return returnValue;
    }

    @PostMapping()
    public PolicyBenefitRest createBenefit(@RequestBody PolicyBenefitDetailsRequestModel benefitDetails) {
        PolicyBenefitRest returnValue = new PolicyBenefitRest();

        PolicyBenefitDto policyBenefitDto = new PolicyBenefitDto();
        BeanUtils.copyProperties(benefitDetails, policyBenefitDto);

        PolicyBenefitDto createdBenefit = policyBenefitService.createBenefit(policyBenefitDto);
        BeanUtils.copyProperties(createdBenefit, returnValue);

        return returnValue;
    }

    @PutMapping(path="/{id}")
    public PolicyBenefitRest updateBenefit(@PathVariable int id, @RequestBody PolicyBenefitDetailsRequestModel benefitDetails) {
        PolicyBenefitRest returnValue = new PolicyBenefitRest();

        PolicyBenefitDto policyBenefitDto = new PolicyBenefitDto();
        BeanUtils.copyProperties(benefitDetails, policyBenefitDto);

        PolicyBenefitDto updatedBenefit = policyBenefitService.updateBenefit(id, policyBenefitDto);
        BeanUtils.copyProperties(updatedBenefit, returnValue);

        return returnValue;
    }

    @DeleteMapping(path="/{id}")
    public OperationStatusModel deleteCommission(@PathVariable int id) {
        OperationStatusModel returnValue = new OperationStatusModel();

        returnValue.setOperationName(RequestOperationName.DELETE.name());
        returnValue.setOperationResult(RequestOperationStatus.SUCCESS.name());

        policyBenefitService.deleteBenefit(id);

        return returnValue;
    }

    @GetMapping()
    public List<PolicyBenefitRest> getBenefits(@RequestParam(value="page", defaultValue = "0") int page,
                                                      @RequestParam(value="limit", defaultValue = "25") int limit) {

        List<PolicyBenefitRest> returnValue = new ArrayList<>();

        List<PolicyBenefitDto> benefits = policyBenefitService.getBenefits(page, limit);

        for(PolicyBenefitDto policyBenefitDto : benefits) {
            PolicyBenefitRest benefitModel = new PolicyBenefitRest();
            BeanUtils.copyProperties(policyBenefitDto, benefitModel);
            returnValue.add(benefitModel);
        }

        return returnValue;
    }

    @GetMapping(path="polCode")
    public List<PolicyBenefitEntity> getBenefitsByPolicyCode(@RequestParam(value = "polCode") final int bftPolCode){

        return policyBenefitService.getPolicyBenefits(bftPolCode);
    }

    @GetMapping(path="sclCode")
    public List<PolicyBenefitEntity> getBenefitsBySubclassCode(@RequestParam(value = "sclCode") final int bftSclCode){
        return policyBenefitService.getPolicyBenefitsByBftSclCode(bftSclCode);
    }
}
