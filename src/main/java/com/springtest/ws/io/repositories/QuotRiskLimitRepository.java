package com.springtest.ws.io.repositories;

import com.springtest.ws.entity.QuotRiskLimitEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuotRiskLimitRepository extends PagingAndSortingRepository<QuotRiskLimitEntity, Long> {
    QuotRiskLimitEntity findByQrlCode(int qrlCode);
}
