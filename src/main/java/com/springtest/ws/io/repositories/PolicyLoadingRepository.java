package com.springtest.ws.io.repositories;

import com.springtest.ws.entity.PolicyLoadingEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PolicyLoadingRepository extends PagingAndSortingRepository<PolicyLoadingEntity, Long> {
    PolicyLoadingEntity findByLoadCode(int loadCode);
    List<PolicyLoadingEntity> findAllByLoadPolCode(int loadPolCode);
    List<PolicyLoadingEntity> findAllByLoadSclCode(int loadSclCode);
}
