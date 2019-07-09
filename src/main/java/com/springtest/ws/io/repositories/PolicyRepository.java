package com.springtest.ws.io.repositories;

import com.springtest.ws.entity.PolicyEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PolicyRepository extends PagingAndSortingRepository<PolicyEntity, Long> {
    PolicyEntity findByPolCode(long polCode);
}
