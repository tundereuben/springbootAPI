package com.springtest.ws.io.repositories;

import com.springtest.ws.entity.SubclassEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubclassRepository extends PagingAndSortingRepository<SubclassEntity, Long> {
    SubclassEntity findBySclCode(int sclCode);
}
