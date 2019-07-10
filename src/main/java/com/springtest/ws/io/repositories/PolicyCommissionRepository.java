package com.springtest.ws.io.repositories;

import com.springtest.ws.entity.PolicyCommissionEntity;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PolicyCommissionRepository extends PagingAndSortingRepository<PolicyCommissionEntity, Long> {
    PolicyCommissionEntity findByCommCode(int commCode);
}
