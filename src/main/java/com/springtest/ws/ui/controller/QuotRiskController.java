package com.springtest.ws.ui.controller;

import com.springtest.ws.service.QuotRiskService;
import com.springtest.ws.shared.dto.QuotRiskDto;
import com.springtest.ws.ui.model.request.QuotRiskDetailsRequestModel;
import com.springtest.ws.ui.model.response.OperationStatusModel;
import com.springtest.ws.ui.model.response.QuotRiskRest;
import com.springtest.ws.ui.model.response.RequestOperationName;
import com.springtest.ws.ui.model.response.RequestOperationStatus;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("quotrisks")// http://localhost/:8080/quotrisks
public class QuotRiskController {

    @Autowired
    QuotRiskService quotRiskService;

    @GetMapping (path="/{id}")
    public QuotRiskRest getQuotRisk(@PathVariable int id) {
        QuotRiskRest returnValue = new QuotRiskRest();

        QuotRiskDto quotRiskDto = quotRiskService.getQuotRiskByQuotRisk(id);
        BeanUtils.copyProperties(quotRiskDto, returnValue);


        return returnValue;
    }

    @PostMapping
    public QuotRiskRest createQuotRisk(@RequestBody QuotRiskDetailsRequestModel quotRiskDetails) {
        QuotRiskRest returnValue = new QuotRiskRest();

        QuotRiskDto quotRiskDto = new QuotRiskDto();
        BeanUtils.copyProperties(quotRiskDetails, quotRiskDto);

        QuotRiskDto createdQuotRisk = quotRiskService.createQuotRisk(quotRiskDto);
        BeanUtils.copyProperties(createdQuotRisk, returnValue);

        return returnValue;
    }

    @PutMapping (path="/{id}")
    public QuotRiskRest updateQuotRisk(@PathVariable int id, @RequestBody QuotRiskDetailsRequestModel quotRiskDetails) {
        QuotRiskRest returnValue = new QuotRiskRest();

        QuotRiskDto quotRiskDto = new QuotRiskDto();
        BeanUtils.copyProperties(quotRiskDetails, quotRiskDto);

        QuotRiskDto updatedQuotRisk = quotRiskService.updateQuotRisk(id, quotRiskDto);
        BeanUtils.copyProperties(updatedQuotRisk, returnValue);

        return returnValue;
    }

    @DeleteMapping (path="/{id}")
    public OperationStatusModel deleteQuotRisk(@PathVariable int id) {
        OperationStatusModel returnValue = new OperationStatusModel();

        returnValue.setOperationName(RequestOperationName.DELETE.name());
        returnValue.setOperationResult(RequestOperationStatus.SUCCESS.name());

        quotRiskService.deleteQuotRisk(id);

        return returnValue;
    }

    @GetMapping
    public List<QuotRiskRest> getQuotRisks(@RequestParam(value="page", defaultValue = "0") int page,
                                           @RequestParam(value="limit", defaultValue = "25") int limit) {

        List<QuotRiskRest> returnValue = new ArrayList<>();

        List<QuotRiskDto> quotRisks = quotRiskService.getQuotRisks(page, limit);

        for(QuotRiskDto quotRiskDto: quotRisks) {
            QuotRiskRest quorRiskModel = new QuotRiskRest();
            BeanUtils.copyProperties(quotRiskDto, quorRiskModel);
            returnValue.add(quorRiskModel);
        }
        return returnValue;
    }
}

