package com.springtest.ws.service;

import com.springtest.ws.shared.dto.ClassDto;

import java.util.List;

public interface ClassService {
    ClassDto createClass(ClassDto _class);
    ClassDto getClassByClassCode(int claCode);
    ClassDto updateClass(int claCode, ClassDto _class);
    void deleteClass(int claCode);
    List<ClassDto> getClasses(int page, int limit);
}
