package com.springtest.ws.service;

import com.springtest.ws.shared.dto.ProductDto;

import java.util.List;

public interface ProductService {
    ProductDto createProduct(ProductDto product);
    ProductDto getProductByProductCode(int proCode);
    ProductDto updateProduct(int proCode, ProductDto product);
    void deleteProduct(int proCode);
    List<ProductDto> getProducts(int page, int limit);
}
