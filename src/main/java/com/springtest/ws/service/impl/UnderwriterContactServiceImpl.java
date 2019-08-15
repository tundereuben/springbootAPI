package com.springtest.ws.service.impl;

import com.springtest.ws.entity.UnderwriterContactEntity;
import com.springtest.ws.io.repositories.UnderwriterContactRepository;
import com.springtest.ws.service.UnderwriterContactService;
import com.springtest.ws.shared.dto.UnderwriterContactDto;
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
public class UnderwriterContactServiceImpl implements UnderwriterContactService{

    @Autowired
    UnderwriterContactRepository underwriterContactRepository;

    @Override
    public UnderwriterContactDto createContact(UnderwriterContactDto contact) {
        if(underwriterContactRepository.findByContCode(contact.getContCode()) != null) throw new RuntimeException("Record already exist");

        UnderwriterContactEntity underwriterContactEntity = new UnderwriterContactEntity();
        BeanUtils.copyProperties(contact, underwriterContactEntity);

        UnderwriterContactEntity storedContactDetails = underwriterContactRepository.save(underwriterContactEntity);

        UnderwriterContactDto returnValue = new UnderwriterContactDto();
        BeanUtils.copyProperties(storedContactDetails, returnValue);

        return returnValue;
    }

    @Override
    public UnderwriterContactDto getContactByContactCode(long contCode) {
        UnderwriterContactDto returnValue = new UnderwriterContactDto();
        UnderwriterContactEntity underwriterContactEntity = underwriterContactRepository.findByContCode(contCode);

        BeanUtils.copyProperties(underwriterContactEntity, returnValue);

        return returnValue;
    }

    @Override
    public UnderwriterContactDto updateContact(long contCode, UnderwriterContactDto contact) {
        UnderwriterContactDto returnValue = new UnderwriterContactDto();
        UnderwriterContactEntity underwriterContactEntity = underwriterContactRepository.findByContCode(contCode);

        underwriterContactEntity.setContUndCode(contact.getContUndCode());
        underwriterContactEntity.setContTitle(contact.getContTitle());
        underwriterContactEntity.setContEmail(contact.getContEmail());
        underwriterContactEntity.setContOthernames(contact.getContOthernames());
        underwriterContactEntity.setContLastname(contact.getContLastname());
        underwriterContactEntity.setContMobile(contact.getContMobile());
        underwriterContactEntity.setContCompanyName(contact.getContCompanyName());
        underwriterContactEntity.setContCountry(contact.getContCountry());
        underwriterContactEntity.setContDescription(contact.getContDescription());
        underwriterContactEntity.setContDob(contact.getContDob());
        underwriterContactEntity.setContEmail(contact.getContEmail());
        underwriterContactEntity.setContGender(contact.getContGender());
        underwriterContactEntity.setContLeadDate(contact.getContLeadDate());
        underwriterContactEntity.setContOccupation(contact.getContOccupation());
        underwriterContactEntity.setContCity(contact.getContCity());
        underwriterContactEntity.setContPostalAddress(contact.getContPostalAddress());
        underwriterContactEntity.setContPostalCode(contact.getContPostalCode());
        underwriterContactEntity.setContSector(contact.getContSector());
        underwriterContactEntity.setContSource(contact.getContSource());
        underwriterContactEntity.setContType(contact.getContType());

        UnderwriterContactEntity updateContactDetails = underwriterContactRepository.save(underwriterContactEntity);

        BeanUtils.copyProperties(updateContactDetails, returnValue);

        return returnValue;
    }

    @Override
    public void deleteContact(long contCode) {
        UnderwriterContactEntity contactEntity = underwriterContactRepository.findByContCode(contCode);

        underwriterContactRepository.delete(contactEntity);

    }

    @Override
    public List<UnderwriterContactDto> getContacts(int page, int limit) {
        List<UnderwriterContactDto> returnValue = new ArrayList<>();

        Pageable pageableRequest = PageRequest.of(page, limit, Sort.by("contCode"));

        Page<UnderwriterContactEntity> contactsPage = underwriterContactRepository.findAll(pageableRequest);
        List<UnderwriterContactEntity> contacts = contactsPage.getContent();

        for(UnderwriterContactEntity underwriterContactEntity: contacts) {
            UnderwriterContactDto contactDto = new UnderwriterContactDto();
            BeanUtils.copyProperties(underwriterContactEntity, contactDto);
            returnValue.add(contactDto);
        }

        return returnValue;
    }

    @Override
    public List<UnderwriterContactEntity> getUnderwriterContacts(long contUndCode) {
        List<UnderwriterContactEntity> returnValue = underwriterContactRepository.findAllByContUndCode(contUndCode);

        return returnValue;
    }
}
