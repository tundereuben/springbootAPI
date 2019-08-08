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

        clientEntity.setClntTitle(client.getClntTitle());
        clientEntity.setClntEmail(client.getClntEmail());
        clientEntity.setClntOthernames(client.getClntOthernames());
        clientEntity.setClntLastname(client.getClntLastname());
        clientEntity.setClntMobile(client.getClntMobile());
        clientEntity.setClntCompanyName(client.getClntCompanyName());
        clientEntity.setClntCountry(client.getClntCountry());
        clientEntity.setClntDescription(client.getClntDescription());
        clientEntity.setClntDob(client.getClntDob());
        clientEntity.setClntEmail(client.getClntEmail());
        clientEntity.setClntGender(client.getClntGender());
        clientEntity.setClntLeadDate(client.getClntLeadDate());
        clientEntity.setClntOccupation(client.getClntOccupation());
        clientEntity.setClntCity(client.getClntCity());
        clientEntity.setClntPostalAddress(client.getClntPostalAddress());
        clientEntity.setClntPostalCode(client.getClntPostalCode());
        clientEntity.setClntSector(client.getClntSector());
        clientEntity.setClntSource(client.getClntSource());
        clientEntity.setClntType(client.getClntType());
        clientEntity.setClntContactFirstname(client.getClntContactFirstname());
        clientEntity.setClntContactLastname(client.getClntLastname());
        clientEntity.setClntContactEmail(client.getClntEmail());
        clientEntity.setClntContactMobile(client.getClntMobile());
        clientEntity.setClntContactBirthday(client.getClntContactBirthday());
        
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
