package com.springtest.ws.io.repositories;

import com.springtest.ws.entity.PolicyExtensionEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PolicyExtensionRepository extends PagingAndSortingRepository<PolicyExtensionEntity, Long> {
    PolicyExtensionEntity findByExtCode(int extCode);
    List<PolicyExtensionEntity> findAllByExtPolCode(int extPolCode);
    List<PolicyExtensionEntity> findAllByExtSclCode(int extSclCode);
}
