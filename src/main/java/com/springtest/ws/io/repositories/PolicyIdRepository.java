package com.springtest.ws.io.repositories;

import com.springtest.ws.entity.PolicyIdEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PolicyIdRepository extends PagingAndSortingRepository<PolicyIdEntity, Long> {
    PolicyIdEntity findByIdCode(int idCode);
    List<PolicyIdEntity> findAllByIdPolCode(int idPolCode);
    List<PolicyIdEntity> findAllByIdSclCode(int idSclCode);
}
