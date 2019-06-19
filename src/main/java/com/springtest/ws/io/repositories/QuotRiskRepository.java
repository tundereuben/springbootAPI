package com.springtest.ws.io.repositories;

import com.springtest.ws.entity.QuotRiskEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuotRiskRepository extends PagingAndSortingRepository<QuotRiskEntity, Long> {
    QuotRiskEntity findByQrCode(int qrCode);
}
