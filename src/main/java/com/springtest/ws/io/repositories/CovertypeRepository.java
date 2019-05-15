package com.springtest.ws.io.repositories;

import com.springtest.ws.entity.CovertypeEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CovertypeRepository extends PagingAndSortingRepository<CovertypeEntity, Long> {
    CovertypeEntity findByCovtCode(int covtCode);
}
