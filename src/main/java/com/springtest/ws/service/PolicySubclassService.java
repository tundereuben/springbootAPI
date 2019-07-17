package com.springtest.ws.service;

import com.springtest.ws.entity.PolicySubclassEntity;
import com.springtest.ws.shared.dto.PolicySubclassDto;

import java.util.List;

public interface PolicySubclassService {
    PolicySubclassDto createSubclass(PolicySubclassDto subclass);
    PolicySubclassDto getSubclassBySubclassCode(int sclCode);
    PolicySubclassDto updateSubclass(int sclCode, PolicySubclassDto subclass);
    void deleteSubclass(int sclCode);
    List<PolicySubclassDto> getSubclasses(int page, int limit);
    List<PolicySubclassEntity> getPolicySubclasses(int sclPolCode);
}
