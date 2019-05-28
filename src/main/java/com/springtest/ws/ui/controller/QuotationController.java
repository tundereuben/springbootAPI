package com.springtest.ws.ui.controller;

import com.springtest.ws.service.QuotationService;
import com.springtest.ws.shared.dto.QuotationDto;
import com.springtest.ws.ui.model.request.QuotationDetailsRequestModel;
import com.springtest.ws.ui.model.response.OperationStatusModel;
import com.springtest.ws.ui.model.response.QuotationRest;
import com.springtest.ws.ui.model.response.RequestOperationName;
import com.springtest.ws.ui.model.response.RequestOperationStatus;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("quotations") // http://localhost/:8080/quotations
public class QuotationController {

    @Autowired
    QuotationService quotationService;

    @GetMapping (path="/{id}")
    public QuotationRest getQuotation (@PathVariable int id) {
        QuotationRest returnValue = new QuotationRest();

        QuotationDto quotationDto = quotationService.getQuotationByQuotationCode(id);
        BeanUtils.copyProperties(quotationDto, returnValue);

        return returnValue;
    }

    @PostMapping
    public QuotationRest createQuotation(@RequestBody QuotationDetailsRequestModel quotationDetails) {
        QuotationRest returnValue = new QuotationRest();

        QuotationDto quotationDto = new QuotationDto();
        BeanUtils.copyProperties(quotationDetails, quotationDto);

        QuotationDto createdQuotation = quotationService.createQuotation(quotationDto);
        BeanUtils.copyProperties(createdQuotation, returnValue);

        return returnValue;
    }

    @PutMapping (path="/{id}")
    public QuotationRest updateQuotation(@PathVariable int id, @RequestBody QuotationDetailsRequestModel quotationDetails) {
        QuotationRest returnValue = new QuotationRest();

        QuotationDto quotationDto = new QuotationDto();
        BeanUtils.copyProperties(quotationDetails, quotationDto);

        QuotationDto updatedQuotation = quotationService.updateQuotation(id, quotationDto);
        BeanUtils.copyProperties(updatedQuotation, returnValue);

        return returnValue;
    }

    @DeleteMapping (path="/{id}")
    public OperationStatusModel deleteQuotation(@PathVariable int id) {
        OperationStatusModel returnValue = new OperationStatusModel();

        returnValue.setOperationName(RequestOperationName.DELETE.name());
        returnValue.setOperationResult(RequestOperationStatus.SUCCESS.name());

        quotationService.deleteQuotation(id);

        return returnValue;
    }

    @GetMapping
    public List<QuotationRest> getQuotations(@RequestParam(value="page", defaultValue = "0") int page,
                                            @RequestParam(value="limit", defaultValue = "25") int limit) {

        List<QuotationRest> returnValue = new ArrayList<>();

        List<QuotationDto> quotations = quotationService.getQuotations(page, limit);

        for(QuotationDto quotationDto : quotations) {
            QuotationRest quotationModel = new QuotationRest();
            BeanUtils.copyProperties(quotationDto, quotationModel);
            returnValue.add(quotationModel);
        }

        return returnValue;
    }
}
