package com.springtest.ws.service;

import com.springtest.ws.shared.dto.CovertypeDto;

import java.util.List;

public interface CovertypeService {
    CovertypeDto createCovertype(CovertypeDto covertype);
    CovertypeDto getCovertypeByCovertypeCode(int covtCode);
    CovertypeDto updtateCovertype(int covtCode, CovertypeDto covertype);
    void deleteCovertype(int covtCode);
    List<CovertypeDto> getCovertypes(int page, int limit);
}
