package com.springtest.ws.service.impl;

import com.springtest.ws.entity.ClientEntity;
import com.springtest.ws.io.repositories.ClientRepository;
import com.springtest.ws.service.ClientService;
import com.springtest.ws.shared.dto.ClientDto;
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
public class ClientServiceImpl implements ClientService {

    @Autowired
    ClientRepository clientRepository;

    @Override
    public ClientDto createClient(ClientDto client) {
        if(clientRepository.findByClntCode(client.getClntCode()) != null) throw new RuntimeException("Record already exist");

        ClientEntity clientEntity = new ClientEntity();
        BeanUtils.copyProperties(client, clientEntity);

        ClientEntity storedClientDetails = clientRepository.save(clientEntity);

        ClientDto returnValue = new ClientDto();
        BeanUtils.copyProperties(storedClientDetails, returnValue);

        return returnValue;
    }

    @Override
    public ClientDto getClientByClientCode(long clntCode) {
        ClientDto returnValue = new ClientDto();
        ClientEntity clientEntity = clientRepository.findByClntCode(clntCode);

        BeanUtils.copyProperties(clientEntity, returnValue);

        return returnValue;
    }

    @Override
    public ClientDto updateClient(long clntCode, ClientDto client) {
        ClientDto returnValue = new ClientDto();
        ClientEntity clientEntity = clientRepository.findByClntCode(clntCode);

        clientEntity.setClntEmail(client.getClntEmail());
        clientEntity.setClntFirstname(client.getClntFirstname());
        clientEntity.setClntLastname(client.getClntLastname());
        clientEntity.setClntMiddlename(client.getClntMiddlename());
        clientEntity.setClntMobile(client.getClntMobile());
        
        ClientEntity updateClientDetails = clientRepository.save(clientEntity);

        BeanUtils.copyProperties(updateClientDetails, returnValue);

        return returnValue;
    }

    @Override
    public void deleteClient(long clntCode) {
        ClientEntity clientEntity = clientRepository.findByClntCode(clntCode);

        clientRepository.delete(clientEntity);

    }

    @Override
    public List<ClientDto> getClients(int page, int limit) {
        List<ClientDto> returnValue = new ArrayList<>();

        Pageable pageableRequest = PageRequest.of(page, limit, Sort.by("clntCode"));

        Page<ClientEntity> clientsPage = clientRepository.findAll(pageableRequest);
        List<ClientEntity> clients = clientsPage.getContent();

        for(ClientEntity clientEntity: clients) {
            ClientDto clientDto = new ClientDto();
            BeanUtils.copyProperties(clientEntity, clientDto);
            returnValue.add(clientDto);
        }

        return returnValue;
    }
}
