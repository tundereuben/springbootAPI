package com.springtest.ws.io.repositories;

import com.springtest.ws.entity.SectionEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SectionRepository extends PagingAndSortingRepository<SectionEntity, Long> {
    SectionEntity findBySectCode(int sectCode);
}
