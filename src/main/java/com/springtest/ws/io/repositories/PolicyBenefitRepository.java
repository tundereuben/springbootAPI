package com.springtest.ws.io.repositories;

import com.springtest.ws.entity.PolicyBenefitEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PolicyBenefitRepository extends PagingAndSortingRepository<PolicyBenefitEntity, Long> {
    PolicyBenefitEntity findByBftCode(int bftCode);
}
