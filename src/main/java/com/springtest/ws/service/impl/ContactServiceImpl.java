package com.springtest.ws.service.impl;

import com.springtest.ws.entity.ContactEntity;
import com.springtest.ws.io.repositories.ContactRepository;
import com.springtest.ws.service.ContactService;
import com.springtest.ws.shared.dto.ContactDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ContactServiceImpl implements ContactService{

    @Autowired
    ContactRepository contactRepository;


    @Override
    public ContactDto createContact(ContactDto contact) {
        if(contactRepository.findByContCode(contact.getContCode()) != null) throw new RuntimeException("Record already exist");

        ContactEntity contactEntity = new ContactEntity();
        BeanUtils.copyProperties(contact, contactEntity);

        ContactEntity storedContactDetails = contactRepository.save(contactEntity);

        ContactDto returnValue = new ContactDto();
        BeanUtils.copyProperties(storedContactDetails, returnValue);

        return returnValue;
    }

    @Override
    public ContactDto getContactByContactCode(long contCode) {
        ContactDto returnValue = new ContactDto();
        ContactEntity contactEntity = contactRepository.findByContCode(contCode);

        BeanUtils.copyProperties(contactEntity, returnValue);

        return returnValue;
    }

    @Override
    public ContactDto updateContact(long contCode, ContactDto contact) {
        ContactDto returnValue = new ContactDto();
        ContactEntity contactEntity = contactRepository.findByContCode(contCode);

        contactEntity.setContClntCode(contact.getContClntCode());
        contactEntity.setContTitle(contact.getContTitle());
        contactEntity.setContEmail(contact.getContEmail());
        contactEntity.setContOthernames(contact.getContOthernames());
        contactEntity.setContLastname(contact.getContLastname());
        contactEntity.setContMobile(contact.getContMobile());
        contactEntity.setContCompanyName(contact.getContCompanyName());
        contactEntity.setContCountry(contact.getContCountry());
        contactEntity.setContDescription(contact.getContDescription());
        contactEntity.setContDob(contact.getContDob());
        contactEntity.setContEmail(contact.getContEmail());
        contactEntity.setContGender(contact.getContGender());
        contactEntity.setContLeadDate(contact.getContLeadDate());
        contactEntity.setContOccupation(contact.getContOccupation());
        contactEntity.setContCity(contact.getContCity());
        contactEntity.setContPostalAddress(contact.getContPostalAddress());
        contactEntity.setContPostalCode(contact.getContPostalCode());
        contactEntity.setContSector(contact.getContSector());
        contactEntity.setContSource(contact.getContSource());
        contactEntity.setContType(contact.getContType());

        ContactEntity updateContactDetails = contactRepository.save(contactEntity);

        BeanUtils.copyProperties(updateContactDetails, returnValue);

        return returnValue;
    }

    @Override
    public void deleteContact(long contCode) {
        ContactEntity contactEntity = contactRepository.findByContCode(contCode);

        contactRepository.delete(contactEntity);
    }

    @Override
    public List<ContactDto> getContacts(int page, int limit) {
        List<ContactDto> returnValue = new ArrayList<>();

        Pageable pageableRequest = PageRequest.of(page, limit, Sort.by("contCode"));

        Page<ContactEntity> contactsPage = contactRepository.findAll(pageableRequest);
        List<ContactEntity> contacts = contactsPage.getContent();

        for(ContactEntity contactEntity: contacts) {
            ContactDto contactDto = new ContactDto();
            BeanUtils.copyProperties(contactEntity, contactDto);
            returnValue.add(contactDto);
        }

        return returnValue;
    }

    @Override
    public List<ContactEntity> getClientContacts(long contClntCode) {
        List<ContactEntity> returnValue = contactRepository.findAllByContClntCode(contClntCode);

        return returnValue;
    }


}
