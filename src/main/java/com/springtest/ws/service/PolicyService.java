package com.springtest.ws.service;

import com.springtest.ws.shared.dto.PolicyDto;

import java.util.List;

public interface PolicyService {
    PolicyDto createPolicy(PolicyDto policy);
    PolicyDto getPolicyByPolicyCode(int polCode);
    PolicyDto updatePolicy(int polCode, PolicyDto policy);
    void deletePolicy(int polCode);
    List<PolicyDto> getPolicies(int page, int limit);
}
