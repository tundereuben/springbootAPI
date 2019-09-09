package com.springtest.ws.service;

import com.springtest.ws.shared.dto.SectorDto;

import java.util.List;

public interface SectorService {
    List<SectorDto> getSectors(int page, int limit);
}
