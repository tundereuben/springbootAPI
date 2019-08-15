package com.springtest.ws.io.repositories;

import com.springtest.ws.entity.UnderwriterContactEntity;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface UnderwriterContactRepository extends PagingAndSortingRepository <UnderwriterContactEntity, Long>{
    UnderwriterContactEntity findByContCode(long contCode);
    List<UnderwriterContactEntity> findAllByContUndCode(long contUndCode);
}
