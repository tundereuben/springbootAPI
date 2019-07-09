package com.springtest.ws.ui.controller;

import com.springtest.ws.service.PolicyDiscountService;
import com.springtest.ws.shared.dto.PolicyDiscountDto;
import com.springtest.ws.ui.model.request.PolicyDiscountDetailsRequestModel;
import com.springtest.ws.ui.model.response.OperationStatusModel;
import com.springtest.ws.ui.model.response.PolicyDiscountRest;
import com.springtest.ws.ui.model.response.RequestOperationName;
import com.springtest.ws.ui.model.response.RequestOperationStatus;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("discounts") // http://localhost/:8080/discounts
public class PolicyDiscountController {

    @Autowired
    PolicyDiscountService policyDiscountService;

    @GetMapping(path="/{id}")
    public PolicyDiscountRest getDiscount(@PathVariable int id) {
        PolicyDiscountRest returnValue = new PolicyDiscountRest();

        PolicyDiscountDto policyDiscountDto = policyDiscountService.getDiscountByDiscountCode(id);
        BeanUtils.copyProperties(policyDiscountDto, returnValue);

        return returnValue;
    }

    @PostMapping()
    public PolicyDiscountRest createDiscount(@RequestBody PolicyDiscountDetailsRequestModel discountDetails) {
        PolicyDiscountRest returnValue = new PolicyDiscountRest();

        PolicyDiscountDto policyDiscountDto = new PolicyDiscountDto();
        BeanUtils.copyProperties(discountDetails, policyDiscountDto);

        PolicyDiscountDto createdDiscount = policyDiscountService.createDiscount(policyDiscountDto);
        BeanUtils.copyProperties(createdDiscount, returnValue);

        return returnValue;
    }

    @PutMapping(path="/{id}")
    public PolicyDiscountRest updateDiscount(@PathVariable int id, @RequestBody PolicyDiscountDetailsRequestModel discountDetails) {
        PolicyDiscountRest returnValue = new PolicyDiscountRest();

        PolicyDiscountDto policyDiscountDto = new PolicyDiscountDto();
        BeanUtils.copyProperties(discountDetails, policyDiscountDto);

        PolicyDiscountDto updatedDiscount = policyDiscountService.updateDiscount(id, policyDiscountDto);
        BeanUtils.copyProperties(updatedDiscount, returnValue);

        return returnValue;
    }

    @DeleteMapping(path="/{id}")
    public OperationStatusModel deleteDiscount(@PathVariable int id) {
        OperationStatusModel returnValue = new OperationStatusModel();

        returnValue.setOperationName(RequestOperationName.DELETE.name());
        returnValue.setOperationResult(RequestOperationStatus.SUCCESS.name());

        policyDiscountService.deleteDiscount(id);

        return returnValue;
    }

    @GetMapping()
    public List<PolicyDiscountRest> getDiscounts(@RequestParam(value="page", defaultValue = "0") int page,
                                     @RequestParam(value="limit", defaultValue = "25") int limit) {

        List<PolicyDiscountRest> returnValue = new ArrayList<>();

        List<PolicyDiscountDto> discounts = policyDiscountService.getDiscounts(page, limit);

        for(PolicyDiscountDto policyDiscountDto : discounts) {
            PolicyDiscountRest discountModel = new PolicyDiscountRest();
            BeanUtils.copyProperties(policyDiscountDto, discountModel);
            returnValue.add(discountModel);
        }

        return returnValue;
    }
}
