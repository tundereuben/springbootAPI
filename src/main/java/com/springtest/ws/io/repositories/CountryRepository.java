package com.springtest.ws.io.repositories;

import com.springtest.ws.entity.CountryEntity;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CountryRepository extends PagingAndSortingRepository<CountryEntity, Long> {
    CountryEntity findByCouCode(long couCode);
}
