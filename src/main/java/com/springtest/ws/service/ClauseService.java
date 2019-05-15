package com.springtest.ws.service;

import com.springtest.ws.shared.dto.ClauseDto;

import java.util.List;

public interface ClauseService {
    ClauseDto createClause(ClauseDto clause);
    ClauseDto getClauseByClauseCode(int clsCode);
    ClauseDto updtateClause(int clsCode, ClauseDto clause);
    void deleteClause(int clsCode);
    List<ClauseDto> getClauses(int page, int limit);
}
