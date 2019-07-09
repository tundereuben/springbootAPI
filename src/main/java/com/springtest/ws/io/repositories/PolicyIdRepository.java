package com.springtest.ws.io.repositories;

import com.springtest.ws.entity.PolicyIdEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PolicyIdRepository extends PagingAndSortingRepository<PolicyIdEntity, Long> {
    PolicyIdEntity findByIdCode(int idCode);
}
