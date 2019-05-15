package com.springtest.ws.service;

import com.springtest.ws.shared.dto.SectionDto;

import java.util.List;

public interface SectionService {
    SectionDto createSection(SectionDto section);
    SectionDto getSectionBySectionCode(int sectCode);
    SectionDto updateSection(int sectCode, SectionDto section);
    void deleteSection(int sectCode);
    List<SectionDto> getSections(int page, int limit);
}
