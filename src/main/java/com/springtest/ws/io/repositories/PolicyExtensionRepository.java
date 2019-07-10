package com.springtest.ws.io.repositories;

import com.springtest.ws.entity.PolicyExtensionEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PolicyExtensionRepository extends PagingAndSortingRepository<PolicyExtensionEntity, Long> {
    PolicyExtensionEntity findByExtCode(int extCode);
}
