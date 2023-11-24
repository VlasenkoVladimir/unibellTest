package com.example.unibellTest.services;

import com.example.unibellTest.dto.ClientDto;
import com.example.unibellTest.mappers.ObjectMapper;
import com.example.unibellTest.repositories.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Сервисный слой для бизнес-логики сущности Client
 */

@Service
public class ClientService {

	protected final ClientRepository clientRepository;
	private final ObjectMapper objectMapper;

	public ClientService(ClientRepository clientRepository, ObjectMapper objectMapper) {
		this.clientRepository = clientRepository;
		this.objectMapper = objectMapper;
	}

	public void save(ClientDto clientDto) {
		clientRepository.save(objectMapper.clientDtoToClient(clientDto));
	}

	public Optional<ClientDto> findById(Long id) {

		return clientRepository.findById(id).map(objectMapper::clientToClientDto);
	}

	public List<ClientDto> findAll() {

		return clientRepository.findAll().stream().map(objectMapper::clientToClientDto).toList();
	}
}
