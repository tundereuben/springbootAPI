package com.springtest.ws.io.repositories;

import com.springtest.ws.entity.UnderwriterEntity;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface UnderwriterRepository extends PagingAndSortingRepository<UnderwriterEntity, Long> {
    UnderwriterEntity findByUndCode(long undCode);
    List<UnderwriterEntity> findAllByUndEmail(String undEmail);
    List<UnderwriterEntity> findAllByUndCompanyName(String undCompanyName);
}
