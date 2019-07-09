package com.springtest.ws.io.repositories;

import com.springtest.ws.entity.PolicyClauseEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PolicyClauseRepository extends PagingAndSortingRepository<PolicyClauseEntity, Long> {
    PolicyClauseEntity findByClsCode(int clsCode);
}
