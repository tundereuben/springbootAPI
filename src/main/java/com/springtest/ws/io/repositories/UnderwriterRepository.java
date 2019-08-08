package com.springtest.ws.io.repositories;

import com.springtest.ws.entity.UnderwriterEntity;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UnderwriterRepository extends PagingAndSortingRepository<UnderwriterEntity, Long> {
    UnderwriterEntity findByUndCode(long undCode);

}
