package com.springtest.ws.io.repositories;

import com.springtest.ws.entity.PolicyRateEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PolicyRateRepository extends PagingAndSortingRepository<PolicyRateEntity, Long> {
    PolicyRateEntity findByRateCode(int rateCode);
    List<PolicyRateEntity> findAllByRatePolCode(int ratePolCode);
    List<PolicyRateEntity> findAllByRateSclCode(int rateSclCode);
}
