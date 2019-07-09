package com.springtest.ws.io.repositories;

import com.springtest.ws.entity.ClientEntity;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ClientRepository extends PagingAndSortingRepository<ClientEntity, Long> {
    ClientEntity findByClntCode(long clntCode);
}
