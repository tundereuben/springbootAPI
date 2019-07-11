package com.springtest.ws.service;

import com.springtest.ws.entity.PolicyClauseEntity;
import com.springtest.ws.shared.dto.PolicyClauseDto;

import java.util.List;

public interface PolicyClauseService {
    PolicyClauseDto createClause(PolicyClauseDto clause);
    PolicyClauseDto getClauseByClauseCode(int clsCode);
    PolicyClauseDto updateClause(int clsCode, PolicyClauseDto clause);
    void deleteClause(int clsCode);
    List<PolicyClauseDto> getClauses(int page, int limit);
    List<PolicyClauseEntity> getPolicyClauses(int clsPolCode);
}
