package com.springtest.ws.io.repositories;

import com.springtest.ws.entity.ClassEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassRepository extends PagingAndSortingRepository<ClassEntity, Long> {
    ClassEntity findByClaCode(int claCode);
}
