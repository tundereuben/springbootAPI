package com.springtest.ws.service;

import com.springtest.ws.shared.dto.SubclassDto;

import java.util.List;

public interface SubclassService {
    SubclassDto createSubclass(SubclassDto subclass);
    SubclassDto getSubclassBySubclassCode(int sclCode);
    SubclassDto updateSubclass(int sclCode, SubclassDto subclass);
    void deleteSubclass(int sclCode);
    List<SubclassDto> getSubclasses(int page, int limit);
}
