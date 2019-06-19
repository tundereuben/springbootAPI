package com.springtest.ws.io.repositories;

import com.springtest.ws.entity.QuotProductEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuotProductRepository extends PagingAndSortingRepository<QuotProductEntity, Long> {
    QuotProductEntity findByQpCode(int qpCode);
}
