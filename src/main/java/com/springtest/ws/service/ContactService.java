package com.springtest.ws.service;

import com.springtest.ws.entity.ContactEntity;
import com.springtest.ws.shared.dto.ContactDto;

import java.util.List;

public interface ContactService {
    ContactDto createContact(ContactDto contact);
    ContactDto getContactByContactCode(long contCode);
    ContactDto updateContact(long contCode, ContactDto contact);
    void deleteContact(long contCode);
    List<ContactDto> getContacts(int page, int limit);
    List<ContactEntity> getClientContacts(long contClntCode);
}
