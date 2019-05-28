package com.springtest.ws.io.repositories;

import com.springtest.ws.entity.QuotationEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuotationRepository extends PagingAndSortingRepository<QuotationEntity, Long> {
    QuotationEntity findByQuotCode(int quotCode);
}
