package com.springtest.ws.ui.controller;

import com.springtest.ws.service.ProductService;
import com.springtest.ws.shared.dto.ProductDto;
import com.springtest.ws.ui.model.request.ProductDetailsRequestModel;
import com.springtest.ws.ui.model.response.OperationStatusModel;
import com.springtest.ws.ui.model.response.ProductRest;
import com.springtest.ws.ui.model.response.RequestOperationName;
import com.springtest.ws.ui.model.response.RequestOperationStatus;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("products") // http://localhost/:8080/products
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping (path="/{id}")
    public ProductRest getProduct(@PathVariable int id) {

        ProductRest returnValue = new ProductRest();

        ProductDto productDto = productService.getProductByProductCode(id);
        BeanUtils.copyProperties(productDto, returnValue);

        return returnValue;
    }

    @PostMapping
    public ProductRest createProduct(@RequestBody ProductDetailsRequestModel productDetails) {
        ProductRest returnValue = new ProductRest();

        ProductDto productDto = new ProductDto();
        BeanUtils.copyProperties(productDetails, productDto);

        ProductDto createdProduct = productService.createProduct(productDto);
        BeanUtils.copyProperties(createdProduct, returnValue);

        return returnValue;
    }

    @PutMapping(path="/{id}")
    public ProductRest updateProduct(@PathVariable int id, @RequestBody ProductDetailsRequestModel productDetails) {
        ProductRest returnValue = new ProductRest();

        ProductDto productDto = new ProductDto();
        BeanUtils.copyProperties(productDetails, productDto);

        ProductDto updatedProduct = productService.updateProduct(id, productDto);
        BeanUtils.copyProperties(updatedProduct, returnValue);

        return returnValue;
    }

    @DeleteMapping(path="/{id}")
    public OperationStatusModel deleteProduct(@PathVariable int id) {
        OperationStatusModel returnValue = new OperationStatusModel();

        returnValue.setOperationName(RequestOperationName.DELETE.name());
        returnValue.setOperationResult(RequestOperationStatus.SUCCESS.name());

        productService.deleteProduct(id);

        return returnValue;
    }

    @GetMapping
    public List<ProductRest> getProducts(@RequestParam(value="page", defaultValue = "0") int page,
                                            @RequestParam(value="limit", defaultValue = "100") int limit) {

        List<ProductRest> returnValue = new ArrayList<>();

        List<ProductDto> products = productService.getProducts(page, limit);

        for(ProductDto productDto : products) {
            ProductRest productModel = new ProductRest();
            BeanUtils.copyProperties(productDto, productModel);
            returnValue.add(productModel);
        }

        return returnValue;
    }
}
