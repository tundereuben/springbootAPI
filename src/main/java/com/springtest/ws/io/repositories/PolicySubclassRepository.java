package com.springtest.ws.io.repositories;

import com.springtest.ws.entity.PolicySubclassEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PolicySubclassRepository extends PagingAndSortingRepository<PolicySubclassEntity, Long> {
    PolicySubclassEntity findBySclCode(int sclCode);
    List<PolicySubclassEntity> findAllBySclPolCode(int sclPolCode);
}
