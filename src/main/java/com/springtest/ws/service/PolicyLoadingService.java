package com.springtest.ws.service;

import com.springtest.ws.entity.PolicyLoadingEntity;
import com.springtest.ws.shared.dto.PolicyLoadingDto;

import java.util.List;

public interface PolicyLoadingService {
    PolicyLoadingDto createLoading(PolicyLoadingDto loading);
    PolicyLoadingDto getLoadingByLoadingCode(int loadCode);
    PolicyLoadingDto updateLoading(int loadCode, PolicyLoadingDto loading);
    void deleteLoading(int loadCode);
    List<PolicyLoadingDto> getLoadings(int page, int limit);
    List<PolicyLoadingEntity> getPolicyLoadings(int loadPolCode);
    List<PolicyLoadingEntity> getPolicyLoadingsBySubclassCode(int loadSclCode);
}
