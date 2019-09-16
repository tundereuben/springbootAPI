package com.springtest.ws.service;

import com.springtest.ws.entity.UnderwriterEntity;
import com.springtest.ws.shared.dto.UnderwriterDto;

import java.util.List;

public interface UnderwriterService {
    UnderwriterDto createUnderwriter(UnderwriterDto underwriter);
    UnderwriterDto getUnderwriterByUndCode(long undCode);
    UnderwriterDto updateUnderwriter(long undCode, UnderwriterDto underwriter);
    void deleteUnderwriter(long undCode);
    List<UnderwriterDto> getUnderwriters(int page, int limit);
    List<UnderwriterEntity> getUnderwritersByEmail(String undEmail);
    List<UnderwriterEntity> getUnderwritersByName(String undCompanyName);
}
