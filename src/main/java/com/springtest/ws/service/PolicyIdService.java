package com.springtest.ws.service;

import com.springtest.ws.entity.PolicyIdEntity;
import com.springtest.ws.shared.dto.PolicyIdDto;

import java.util.List;

public interface PolicyIdService {
    PolicyIdDto createId(PolicyIdDto id);
    PolicyIdDto getIdByIdCode(int idCode);
    PolicyIdDto updateId(int idCode, PolicyIdDto id);
    void deleteId(int idCode);
    List<PolicyIdDto> getIds(int page, int limit);
    List<PolicyIdEntity> getPolicyIds(int idPolCode);
    List<PolicyIdEntity> getPolicyIdsBySclCode(int idSclCode);
}
