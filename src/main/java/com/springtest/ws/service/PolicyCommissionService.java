package com.springtest.ws.service;

import com.springtest.ws.shared.dto.PolicyCommissionDto;

import java.util.List;

public interface PolicyCommissionService {
    PolicyCommissionDto createCommission(PolicyCommissionDto commission);
    PolicyCommissionDto getCommByCommCode(int commCode);
    PolicyCommissionDto updateCommission(int commCode, PolicyCommissionDto commission);
    void deleteCommission(int commCode);
    List<PolicyCommissionDto> getCommissions(int page, int limit);
}
