package com.springtest.ws.io.repositories;

import com.springtest.ws.entity.ContactEntity;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface ContactRepository extends PagingAndSortingRepository<ContactEntity, Long> {
    ContactEntity findByContCode(long contCode);
    List<ContactEntity> findAllByContClntCode(long contClntCode);
}
