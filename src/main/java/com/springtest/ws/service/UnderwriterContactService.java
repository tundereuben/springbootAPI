package com.springtest.ws.service;

import com.springtest.ws.entity.UnderwriterContactEntity;
import com.springtest.ws.shared.dto.UnderwriterContactDto;

import java.util.List;

public interface UnderwriterContactService {
    UnderwriterContactDto createContact(UnderwriterContactDto contact);
    UnderwriterContactDto getContactByContactCode(long contCode);
    UnderwriterContactDto updateContact(long contCode, UnderwriterContactDto contact);
    void deleteContact(long contCode);
    List<UnderwriterContactDto> getContacts(int page, int limit);
    List<UnderwriterContactEntity> getUnderwriterContacts(long contUndCode);
}
