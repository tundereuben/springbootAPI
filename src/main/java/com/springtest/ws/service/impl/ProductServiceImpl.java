package com.springtest.ws.service.impl;

import com.springtest.ws.entity.ProductEntity;
import com.springtest.ws.io.repositories.ProductRepository;
import com.springtest.ws.service.ProductService;
import com.springtest.ws.shared.dto.ProductDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Override
    public ProductDto createProduct(ProductDto product) {
        if(productRepository.findByProCode(product.getProCode()) != null) throw new RuntimeException("Record already exists");

        ProductEntity productEntity = new ProductEntity();
        BeanUtils.copyProperties(product, productEntity);

        ProductEntity storedProductDetails = productRepository.save(productEntity);

        ProductDto returnValue = new ProductDto();
        BeanUtils.copyProperties(storedProductDetails, returnValue);

        return returnValue;
    }

    @Override
    public ProductDto getProductByProductCode(int proCode) {
        ProductDto returnValue = new ProductDto();
        ProductEntity productEntity = productRepository.findByProCode(proCode);

        BeanUtils.copyProperties(productEntity, returnValue);

        return returnValue;
    }

    @Override
    public ProductDto updateProduct(int proCode, ProductDto product) {
        ProductDto returnValue = new ProductDto();
        ProductEntity productEntity = productRepository.findByProCode(proCode);

        productEntity.setProCode(product.getProCode());
        productEntity.setProDesc(product.getProDesc());
        productEntity.setProShtDesc(product.getProShtDesc());

        ProductEntity updatedProductDetails = productRepository.save(productEntity);

        BeanUtils.copyProperties(updatedProductDetails, returnValue);

        return returnValue;
    }


    @Override
    public void deleteProduct(int proCode) {
        ProductEntity productEntity = productRepository.findByProCode(proCode);
        productRepository.delete(productEntity);
    }

    @Override
    public List<ProductDto> getProducts(int page, int limit) {
        List<ProductDto> returnValue = new ArrayList<>();

        Pageable pageableRequest = PageRequest.of(page, limit, Sort.by("proCode"));

        Page<ProductEntity> productsPage = productRepository.findAll(pageableRequest);
        List<ProductEntity> products = productsPage.getContent();

        for(ProductEntity productEntity: products) {
            ProductDto productDto = new ProductDto();
            BeanUtils.copyProperties(productEntity, productDto);
            returnValue.add(productDto);
        }

        return returnValue;
    }
}
