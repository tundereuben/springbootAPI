package com.springtest.ws.io.repositories;

import com.springtest.ws.entity.ClientEntity;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface ClientRepository extends PagingAndSortingRepository<ClientEntity, Long> {
    ClientEntity findByClntCode(long clntCode);
    List<ClientEntity> findAllByClntEmail(String clntEmail);
    List<ClientEntity> findAllByClntLastname(String clntLastname);
    List<ClientEntity> findAllByClntCompanyName(String clntCompanyName);
}
