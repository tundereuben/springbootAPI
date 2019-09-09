package com.springtest.ws.io.repositories;

import com.springtest.ws.entity.SectorEntity;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface SectorRepository extends PagingAndSortingRepository<SectorEntity, Long> {
    SectorEntity findBySecCode(long secCode);
}
