package com.springtest.ws.ui.controller;

import com.springtest.ws.entity.UnderwriterContactEntity;
import com.springtest.ws.service.UnderwriterContactService;
import com.springtest.ws.shared.dto.UnderwriterContactDto;
import com.springtest.ws.ui.model.request.ContactDetailsRequestModel;
import com.springtest.ws.ui.model.request.UnderwriterContactDetailsRequestModel;
import com.springtest.ws.ui.model.response.OperationStatusModel;
import com.springtest.ws.ui.model.response.RequestOperationName;
import com.springtest.ws.ui.model.response.RequestOperationStatus;
import com.springtest.ws.ui.model.response.UnderwriterContactRest;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("underwriter-contacts") // http://localhost/:8080/underwriter-contacts
public class UnderwriterContactController {

    @Autowired
    UnderwriterContactService underwriterContactService;

    @GetMapping(path="/{id}")
    public UnderwriterContactRest getContact(@PathVariable int id) {
        UnderwriterContactRest returnValue = new UnderwriterContactRest();

        UnderwriterContactDto contactDto = underwriterContactService.getContactByContactCode(id);
        BeanUtils.copyProperties(contactDto, returnValue);

        return returnValue;
    }

    @PostMapping
    public UnderwriterContactRest createContact(@RequestBody ContactDetailsRequestModel contactDetails) {
        UnderwriterContactRest returnValue = new UnderwriterContactRest();

        UnderwriterContactDto contactDto = new UnderwriterContactDto();
        BeanUtils.copyProperties(contactDetails, contactDto);

        UnderwriterContactDto createdContact = underwriterContactService.createContact(contactDto);
        BeanUtils.copyProperties(createdContact, returnValue);

        return returnValue;
    }

    @PutMapping(path="/{id}")
    public UnderwriterContactRest updateContact(@PathVariable int id, @RequestBody UnderwriterContactDetailsRequestModel contactDetails) {
        UnderwriterContactRest returnValue = new UnderwriterContactRest();

        UnderwriterContactDto contactDto = new UnderwriterContactDto();
        BeanUtils.copyProperties(contactDetails, contactDto);

        UnderwriterContactDto updatedContact = underwriterContactService.updateContact(id, contactDto);
        BeanUtils.copyProperties(updatedContact, returnValue);

        return returnValue;
    }

    @DeleteMapping(path="/{id}")
    public OperationStatusModel deleteContact(@PathVariable int id) {
        OperationStatusModel returnValue = new OperationStatusModel();

        returnValue.setOperationName(RequestOperationName.DELETE.name());
        returnValue.setOperationResult(RequestOperationStatus.SUCCESS.name());

        underwriterContactService.deleteContact(id);

        return returnValue;
    }

    @GetMapping
    public List<UnderwriterContactRest> getContacts(@RequestParam(value="page", defaultValue = "0") int page,
                                         @RequestParam(value="limit", defaultValue = "25") int limit) {

        List<UnderwriterContactRest> returnValue = new ArrayList<>();

        List<UnderwriterContactDto> contacts = underwriterContactService.getContacts(page, limit);

        for(UnderwriterContactDto contactDto : contacts) {
            UnderwriterContactRest contactModel = new UnderwriterContactRest();
            BeanUtils.copyProperties(contactDto, contactModel);
            returnValue.add(contactModel);
        }

        return returnValue;
    }

    @GetMapping(path="clntCode")
    public List<UnderwriterContactEntity> getUnderwriterContacts(@RequestParam(value="contUndCode") final long contUndCode ) {

        return underwriterContactService.getUnderwriterContacts(contUndCode);
    }
}
