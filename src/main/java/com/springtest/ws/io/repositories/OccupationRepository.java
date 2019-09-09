package com.springtest.ws.io.repositories;

import com.springtest.ws.entity.OccupationEntity;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface OccupationRepository extends PagingAndSortingRepository<OccupationEntity, Long> {
    OccupationEntity findByOccCode(long occCode);
}
