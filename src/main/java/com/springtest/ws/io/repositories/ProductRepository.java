package com.springtest.ws.io.repositories;

import com.springtest.ws.entity.ProductEntity;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ProductRepository extends PagingAndSortingRepository<ProductEntity, Long> {
    ProductEntity findByProCode(int proCode);
}
