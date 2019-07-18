package com.springtest.ws.ui.controller;

import com.springtest.ws.entity.PolicyRateEntity;
import com.springtest.ws.service.PolicyRateService;
import com.springtest.ws.shared.dto.PolicyRateDto;
import com.springtest.ws.ui.model.request.PolicyRateDetailsRequestModel;
import com.springtest.ws.ui.model.response.OperationStatusModel;
import com.springtest.ws.ui.model.response.PolicyRateRest;
import com.springtest.ws.ui.model.response.RequestOperationName;
import com.springtest.ws.ui.model.response.RequestOperationStatus;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("rates") // http://localhost/:8080/rates
public class PolicyRateController {

    @Autowired
    PolicyRateService policyRateService;

    @GetMapping(path="/{id}")
    public PolicyRateRest getRate(@PathVariable int id){
        PolicyRateRest returnValue = new PolicyRateRest();

        PolicyRateDto policyRateDto = policyRateService.getRateByRateCode(id);
        BeanUtils.copyProperties(policyRateDto, returnValue);

        return returnValue;
    }

    @PostMapping()
    public PolicyRateRest createRate(@RequestBody PolicyRateDetailsRequestModel rateDetails) {
        PolicyRateRest returnValue = new PolicyRateRest();

        PolicyRateDto policyRateDto = new PolicyRateDto();
        BeanUtils.copyProperties(rateDetails, policyRateDto);

        PolicyRateDto createdRate = policyRateService.createRate(policyRateDto);
        BeanUtils.copyProperties(createdRate, returnValue);

        return returnValue;
    }

    @PutMapping(path="/{id}")
    public PolicyRateRest updateRate(@PathVariable int id, @RequestBody PolicyRateDetailsRequestModel rateDetails) {
        PolicyRateRest returnValue = new PolicyRateRest();

        PolicyRateDto policyRateDto = new PolicyRateDto();
        BeanUtils.copyProperties(rateDetails, policyRateDto);

        PolicyRateDto updatedRate = policyRateService.updateRate(id, policyRateDto);
        BeanUtils.copyProperties(updatedRate, returnValue);

        return returnValue;
    }

    @DeleteMapping(path="/{id}")
    public OperationStatusModel deleteRate(@PathVariable int id) {
        OperationStatusModel returnValue = new OperationStatusModel();

        returnValue.setOperationName(RequestOperationName.DELETE.name());
        returnValue.setOperationResult(RequestOperationStatus.SUCCESS.name());

        policyRateService.deleteRate(id);

        return returnValue;
    }

    @GetMapping()
    public List<PolicyRateRest> getRates(@RequestParam(value="page", defaultValue = "0") int page,
                                         @RequestParam(value="limit", defaultValue = "25") int limit) {

        List<PolicyRateRest> returnValue = new ArrayList<>();

        List<PolicyRateDto> rates = policyRateService.getRates(page, limit);

        for(PolicyRateDto policyRateDto : rates) {
            PolicyRateRest rateModel = new PolicyRateRest();
            BeanUtils.copyProperties(policyRateDto, rateModel);
            returnValue.add(rateModel);
        }

        return returnValue;
    }

    @GetMapping(path="polCode")
    public List<PolicyRateEntity> getRatesByPolicyCode(@RequestParam(value = "polCode") final int ratePolCode){

        return policyRateService.getPolicyRates(ratePolCode);
    }

    @GetMapping(path="sclCode")
    public List<PolicyRateEntity> getRatesBySubclassCode(@RequestParam(value = "sclCode") final int rateSclCode){

        return policyRateService.getPolicyRatesBySubclassCode(rateSclCode);
    }
}
