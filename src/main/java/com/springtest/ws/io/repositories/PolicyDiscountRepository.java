package com.springtest.ws.io.repositories;

import com.springtest.ws.entity.PolicyDiscountEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PolicyDiscountRepository extends PagingAndSortingRepository<PolicyDiscountEntity, Long> {
    PolicyDiscountEntity findByDsctCode(int dsctCode);
}
