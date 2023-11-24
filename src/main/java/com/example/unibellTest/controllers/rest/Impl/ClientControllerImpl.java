package com.example.unibellTest.controllers.rest.Impl;

import com.example.unibellTest.controllers.rest.ClientController;
import com.example.unibellTest.controllers.rest.base.BaseControllerImpl;
import com.example.unibellTest.dto.ClientDto;
import com.example.unibellTest.services.ClientService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;
import static org.springframework.http.HttpStatus.OK;

/**
 * Реализация REST-контроллера по клиентам, версия 1
 */

@RestController
@RequestMapping(value = "/v1")
public class ClientControllerImpl extends BaseControllerImpl implements ClientController {

	private final ClientService clientService;

	public ClientControllerImpl(ObjectMapper objectMapper, ClientService clientService) {
		super(objectMapper);
		this.clientService = clientService;
	}

	@Override
	public ResponseEntity<HttpStatus> save(ClientDto clientDto) {
		clientService.save(clientDto);

		return new ResponseEntity<>(CREATED);
	}

	@Override
	public ResponseEntity<ClientDto> findById(Long id) {

		return clientService.findById(id)
				.map(clientDto -> new ResponseEntity<>(clientDto, OK))
				.orElseGet(() -> new ResponseEntity<>(null, NO_CONTENT));
	}

	@Override
	public ResponseEntity<List<ClientDto>> findAll() {
		List<ClientDto> result = clientService.findAll();

		return !result.isEmpty()
				? new ResponseEntity<>(result, OK)
				: new ResponseEntity<>(null, NO_CONTENT);
	}
}
