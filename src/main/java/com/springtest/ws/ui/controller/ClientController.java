package com.springtest.ws.ui.controller;

import com.springtest.ws.entity.ClientEntity;
import com.springtest.ws.service.ClientService;
import com.springtest.ws.shared.dto.ClientDto;
import com.springtest.ws.ui.model.request.ClientDetailsRequestModel;
import com.springtest.ws.ui.model.response.ClientRest;
import com.springtest.ws.ui.model.response.OperationStatusModel;
import com.springtest.ws.ui.model.response.RequestOperationName;
import com.springtest.ws.ui.model.response.RequestOperationStatus;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("clients") // http://localhost/:8080/clients
public class ClientController {

    @Autowired
    ClientService clientService;

    @GetMapping (path="/{id}")
    public ClientRest getClient(@PathVariable int id) {
        ClientRest returnValue = new ClientRest();

        ClientDto clientDto = clientService.getClientByClientCode(id);
        BeanUtils.copyProperties(clientDto, returnValue);

        return returnValue;
    }

    @PostMapping
    public ClientRest createClient(@RequestBody ClientDetailsRequestModel clientDetails) {
        ClientRest returnValue = new ClientRest();

        ClientDto clientDto = new ClientDto();
        BeanUtils.copyProperties(clientDetails, clientDto);

        ClientDto createdClient = clientService.createClient(clientDto);
        BeanUtils.copyProperties(createdClient, returnValue);

        return returnValue;
    }

    @PutMapping(path="/{id}")
    public ClientRest updateClient(@PathVariable int id, @RequestBody ClientDetailsRequestModel clientDetails) {
        ClientRest returnValue = new ClientRest();

        ClientDto clientDto = new ClientDto();
        BeanUtils.copyProperties(clientDetails, clientDto);

        ClientDto updatedClient = clientService.updateClient(id, clientDto);
        BeanUtils.copyProperties(updatedClient, returnValue);

        return returnValue;
    }

    @DeleteMapping(path="/{id}")
    public OperationStatusModel deleteClient(@PathVariable int id) {
        OperationStatusModel returnValue = new OperationStatusModel();

        returnValue.setOperationName(RequestOperationName.DELETE.name());
        returnValue.setOperationResult(RequestOperationStatus.SUCCESS.name());

        clientService.deleteClient(id);

        return returnValue;
    }

    @GetMapping
    public List<ClientRest> getClients(@RequestParam(value="page", defaultValue = "0") int page,
                                       @RequestParam(value="limit", defaultValue = "25") int limit) {

        List<ClientRest> returnValue = new ArrayList<>();

        List<ClientDto> clients = clientService.getClients(page, limit);

        for(ClientDto clientDto : clients) {
            ClientRest clientModel = new ClientRest();
            BeanUtils.copyProperties(clientDto, clientModel);
            returnValue.add(clientModel);
        }

        return returnValue;
    }

    @GetMapping(path="clntEmail")
    public List<ClientEntity> getClientsByEmail(@RequestParam(value="clntEmail") final String clntEmail ) {

        return clientService.getClientsByEmail(clntEmail);
    }

    @GetMapping(path="clntLastname")
    public List<ClientEntity> getClientsByLastname(@RequestParam(value="clntLastname") final String clntLastname ) {

        return clientService.getClientsByLastname(clntLastname);
    }

    @GetMapping(path="clntCompanyName")
    public List<ClientEntity> getClientsByCompanyName(@RequestParam(value="clntCompanyName") final String clntCompanyName ) {

        return clientService.getClientsByCompanyName(clntCompanyName);
    }
}
