package com.springtest.ws.io.repositories;

import com.springtest.ws.entity.PolicyProductEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PolicyProductRepository extends PagingAndSortingRepository<PolicyProductEntity, Long> {
    PolicyProductEntity findBySclCode(int sclCode);
    List<PolicyProductEntity> findAllBySclPolCode(int sclPolCode);
}
