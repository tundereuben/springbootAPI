package com.springtest.ws.service;

import com.springtest.ws.shared.dto.OccupationDto;

import java.util.List;

public interface OccupationService {
    List<OccupationDto> getOccupations(int page, int limit);
}
