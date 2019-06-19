package com.springtest.ws.ui.controller;

import com.springtest.ws.service.QuotProductService;
import com.springtest.ws.shared.dto.QuotProductDto;
import com.springtest.ws.ui.model.request.QuotProductDetailsRequestModel;
import com.springtest.ws.ui.model.response.OperationStatusModel;
import com.springtest.ws.ui.model.response.QuotProductRest;
import com.springtest.ws.ui.model.response.RequestOperationName;
import com.springtest.ws.ui.model.response.RequestOperationStatus;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("quotproducts") // http://localhost/:8080/quotproducts
public class QuotProductController {

    @Autowired
    QuotProductService quotProductService;

    @GetMapping (path="/{id}")
    public QuotProductRest getQuotProduct(@PathVariable int id) {
        QuotProductRest returnValue = new QuotProductRest();

        QuotProductDto quotProductDto = quotProductService.getQuotProductByQuotProductCode(id);
        BeanUtils.copyProperties(quotProductDto, returnValue);

        return returnValue;
    }

    @PostMapping
    public QuotProductRest createQuotProduct(@RequestBody QuotProductDetailsRequestModel quotProductDetails) {
        QuotProductRest returnValue = new QuotProductRest();

        QuotProductDto quotProductDto = new QuotProductDto();
        BeanUtils.copyProperties(quotProductDetails, quotProductDto);

        QuotProductDto createdQuotProduct = quotProductService.createQuotProduct(quotProductDto);
        BeanUtils.copyProperties(createdQuotProduct, returnValue);

        return returnValue;
    }

    @PutMapping (path="/{id}")
    public QuotProductRest updateQuotProduct(@PathVariable int id, @RequestBody QuotProductDetailsRequestModel quotProductDetails) {
        QuotProductRest returnValue = new QuotProductRest();

        QuotProductDto quotProductDto = new QuotProductDto();
        BeanUtils.copyProperties(quotProductDetails, quotProductDto);

        QuotProductDto updatedQuotProduct = quotProductService.updateQuotProduct(id, quotProductDto);
        BeanUtils.copyProperties(updatedQuotProduct, returnValue);

        return returnValue;
    }

    @DeleteMapping (path="/{id}")
    public OperationStatusModel deleteQuotProduct(@PathVariable int id) {
        OperationStatusModel returnValue = new OperationStatusModel();

        returnValue.setOperationName(RequestOperationName.DELETE.name());
        returnValue.setOperationResult(RequestOperationStatus.SUCCESS.name());

        quotProductService.deleteQuotProduct(id);

        return returnValue;
    }

    @GetMapping
    public List<QuotProductRest> getQuotProducts(@RequestParam(value="page", defaultValue = "0") int page,
                                             @RequestParam(value="limit", defaultValue = "25") int limit) {

        List<QuotProductRest> returnValue = new ArrayList<>();

        List<QuotProductDto> quotProducts = quotProductService.getQuotProducts(page, limit);

        for(QuotProductDto quotProductDto : quotProducts) {
            QuotProductRest quotProductModel = new QuotProductRest();
            BeanUtils.copyProperties(quotProductDto, quotProductModel);
            returnValue.add(quotProductModel);
        }

        return returnValue;
    }
}
