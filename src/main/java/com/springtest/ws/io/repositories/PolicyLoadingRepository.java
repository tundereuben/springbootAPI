package com.springtest.ws.io.repositories;

import com.springtest.ws.entity.PolicyLoadingEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PolicyLoadingRepository extends PagingAndSortingRepository<PolicyLoadingEntity, Long> {
    PolicyLoadingEntity findByLoadCode(int loadCode);
}
