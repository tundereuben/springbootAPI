package com.springtest.ws.io.repositories;

import com.springtest.ws.entity.PolicyCommissionEntity;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface PolicyCommissionRepository extends PagingAndSortingRepository<PolicyCommissionEntity, Long> {
    PolicyCommissionEntity findByCommCode(int commCode);
    List<PolicyCommissionEntity> findAllByCommPolCode(int commPolCode);
    List<PolicyCommissionEntity> findAllByCommSclCode(int commSclCode);
}
