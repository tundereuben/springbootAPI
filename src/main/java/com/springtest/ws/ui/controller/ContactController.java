package com.springtest.ws.ui.controller;

import com.springtest.ws.entity.ContactEntity;
import com.springtest.ws.service.ContactService;
import com.springtest.ws.shared.dto.ContactDto;
import com.springtest.ws.ui.model.request.ContactDetailsRequestModel;
import com.springtest.ws.ui.model.response.ContactRest;
import com.springtest.ws.ui.model.response.OperationStatusModel;
import com.springtest.ws.ui.model.response.RequestOperationName;
import com.springtest.ws.ui.model.response.RequestOperationStatus;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("contacts") // http://localhost/:8080/contacts
public class ContactController {

    @Autowired
    ContactService contactService;

    @GetMapping(path="/{id}")
    public ContactRest getContact(@PathVariable int id) {
        ContactRest returnValue = new ContactRest();

        ContactDto contactDto = contactService.getContactByContactCode(id);
        BeanUtils.copyProperties(contactDto, returnValue);

        return returnValue;
    }

    @PostMapping
    public ContactRest createContact(@RequestBody ContactDetailsRequestModel contactDetails) {
        ContactRest returnValue = new ContactRest();

        ContactDto contactDto = new ContactDto();
        BeanUtils.copyProperties(contactDetails, contactDto);

        ContactDto createdContact = contactService.createContact(contactDto);
        BeanUtils.copyProperties(createdContact, returnValue);

        return returnValue;
    }

    @PutMapping(path="/{id}")
    public ContactRest updateContact(@PathVariable int id, @RequestBody ContactDetailsRequestModel contactDetails) {
        ContactRest returnValue = new ContactRest();

        ContactDto contactDto = new ContactDto();
        BeanUtils.copyProperties(contactDetails, contactDto);

        ContactDto updatedContact = contactService.updateContact(id, contactDto);
        BeanUtils.copyProperties(updatedContact, returnValue);

        return returnValue;
    }

    @DeleteMapping(path="/{id}")
    public OperationStatusModel deleteContact(@PathVariable int id) {
        OperationStatusModel returnValue = new OperationStatusModel();

        returnValue.setOperationName(RequestOperationName.DELETE.name());
        returnValue.setOperationResult(RequestOperationStatus.SUCCESS.name());

        contactService.deleteContact(id);

        return returnValue;
    }

    @GetMapping
    public List<ContactRest> getContacts(@RequestParam(value="page", defaultValue = "0") int page,
                                         @RequestParam(value="limit", defaultValue = "25") int limit) {

        List<ContactRest> returnValue = new ArrayList<>();

        List<ContactDto> contacts = contactService.getContacts(page, limit);

        for(ContactDto contactDto : contacts) {
            ContactRest contactModel = new ContactRest();
            BeanUtils.copyProperties(contactDto, contactModel);
            returnValue.add(contactModel);
        }

        return returnValue;
    }

    @GetMapping(path="clntCode")
    public List<ContactEntity> getClientContacts(@RequestParam(value="contClntCode") final long contClntCode ) {

        return contactService.getClientContacts(contClntCode);
    }

}
