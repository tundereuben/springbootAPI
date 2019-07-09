package com.springtest.ws.service;

import com.springtest.ws.shared.dto.ClientDto;

import java.util.List;

public interface ClientService {
    ClientDto createClient(ClientDto client);
    ClientDto getClientByClientCode(long clntCode);
    ClientDto updateClient(long clntCode, ClientDto client);
    void deleteClient(long clntCode);
    List<ClientDto> getClients(int page, int limit);
}
