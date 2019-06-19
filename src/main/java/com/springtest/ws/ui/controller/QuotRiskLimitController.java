package com.springtest.ws.ui.controller;

import com.springtest.ws.service.QuotRiskLimitService;
import com.springtest.ws.shared.dto.QuotRiskLimitDto;
import com.springtest.ws.ui.model.request.QuotRiskLimitDetailsRequestModel;
import com.springtest.ws.ui.model.response.OperationStatusModel;
import com.springtest.ws.ui.model.response.QuotRiskLimitRest;
import com.springtest.ws.ui.model.response.RequestOperationName;
import com.springtest.ws.ui.model.response.RequestOperationStatus;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("quotrisklimits")// http://localhost/:8080/quotrisklimits
public class QuotRiskLimitController {
    @Autowired
    QuotRiskLimitService quotRiskLimitService;

    @GetMapping (path="/{id}")
    public QuotRiskLimitRest getQuotRiskLimit(@PathVariable int id) {
        QuotRiskLimitRest returnValue = new QuotRiskLimitRest();

        QuotRiskLimitDto quotRiskLimitDto = quotRiskLimitService.getQuotRiskLimitByQuotRiskLimitCode(id);
        BeanUtils.copyProperties(quotRiskLimitDto, returnValue);

        return returnValue;
    }

    @PostMapping
    public QuotRiskLimitRest createQuotRiskLimit(@RequestBody QuotRiskLimitDetailsRequestModel quotRiskLimitDetails) {
        QuotRiskLimitRest returnValue = new QuotRiskLimitRest();

        QuotRiskLimitDto quotRiskLimitDto = new QuotRiskLimitDto();
        BeanUtils.copyProperties(quotRiskLimitDetails, quotRiskLimitDto);

        QuotRiskLimitDto createdQuotRiskLimit = quotRiskLimitService.createQuotRiskLimit(quotRiskLimitDto);
        BeanUtils.copyProperties(createdQuotRiskLimit, returnValue);

        return returnValue;
    }

    @PutMapping (path="/{id}")
    public QuotRiskLimitRest updateQuotRiskLimit(@PathVariable int id, @RequestBody QuotRiskLimitDetailsRequestModel quotRiskLimitDetails) {
        QuotRiskLimitRest returnValue = new QuotRiskLimitRest();

        QuotRiskLimitDto quotRiskLimitDto = new QuotRiskLimitDto();
        BeanUtils.copyProperties(quotRiskLimitDetails, quotRiskLimitDto);

        QuotRiskLimitDto updatedQuotRiskLimit = quotRiskLimitService.updateQuotRiskLimit(id, quotRiskLimitDto);
        BeanUtils.copyProperties(updatedQuotRiskLimit, returnValue);

        return returnValue;
    }

    @DeleteMapping (path="/{id}")
    public OperationStatusModel deleteQuotRiskLimit(@PathVariable int id) {
        OperationStatusModel returnValue = new OperationStatusModel();

        returnValue.setOperationName(RequestOperationName.DELETE.name());
        returnValue.setOperationResult(RequestOperationStatus.SUCCESS.name());

        quotRiskLimitService.deleteQuotRiskLimit(id);

        return returnValue;
    }

    @GetMapping
    public List<QuotRiskLimitRest> getQuotRiskLimits(@RequestParam(value="page", defaultValue = "0") int page,
                                           @RequestParam(value="limit", defaultValue = "25") int limit) {

        List<QuotRiskLimitRest> returnValue = new ArrayList<>();

        List<QuotRiskLimitDto> quotRiskLimits = quotRiskLimitService.getQuotRiskLimits(page, limit);

        for(QuotRiskLimitDto quotRiskLimitDto: quotRiskLimits) {
            QuotRiskLimitRest quotRiskLimitModel = new QuotRiskLimitRest();
            BeanUtils.copyProperties(quotRiskLimitDto, quotRiskLimitModel);
            returnValue.add(quotRiskLimitModel);
        }
        return returnValue;
    }
}
