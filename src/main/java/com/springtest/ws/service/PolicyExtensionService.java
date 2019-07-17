package com.springtest.ws.service;

import com.springtest.ws.entity.PolicyExtensionEntity;
import com.springtest.ws.shared.dto.PolicyExtensionDto;

import java.util.List;

public interface PolicyExtensionService {
    PolicyExtensionDto createExtension(PolicyExtensionDto extension);
    PolicyExtensionDto getExtensionByExtensionCode(int extCode);
    PolicyExtensionDto updateExtension(int extCode, PolicyExtensionDto extension);
    void deleteExtension(int extCode);
    List<PolicyExtensionDto> getExtensions(int page, int limit);
    List<PolicyExtensionEntity> getPolicyExtensions(int extPolCode);
    List<PolicyExtensionEntity> getPolicyExtensionsBySclCode(int extSclCode);
}
