package com.springtest.ws.service;

import com.springtest.ws.entity.PolicyProductEntity;
import com.springtest.ws.shared.dto.PolicyProductDto;

import java.util.List;

public interface PolicyProductService {
    PolicyProductDto createSubclass(PolicyProductDto subclass);
    PolicyProductDto getSubclassBySubclassCode(int sclCode);
    PolicyProductDto updateSubclass(int sclCode, PolicyProductDto subclass);
    void deleteSubclass(int sclCode);
    List<PolicyProductDto> getSubclasses(int page, int limit);
    List<PolicyProductEntity> getPolicySubclasses(int sclPolCode);
}
