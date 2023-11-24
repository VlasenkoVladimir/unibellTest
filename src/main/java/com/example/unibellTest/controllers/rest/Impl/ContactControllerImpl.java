package com.example.unibellTest.controllers.rest.Impl;

import com.example.unibellTest.controllers.rest.ContactController;
import com.example.unibellTest.controllers.rest.base.BaseControllerImpl;
import com.example.unibellTest.domain.enums.ContactType;
import com.example.unibellTest.dto.ContactDto;
import com.example.unibellTest.services.ContactService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;
import static org.springframework.http.HttpStatus.OK;

/**
 * Реализация REST-контроллера по контактным записям клиента, версия 1
 */

@RestController
@RequestMapping(value = "/v1")
public class ContactControllerImpl extends BaseControllerImpl implements ContactController {

	private final ContactService contactService;

	public ContactControllerImpl(ObjectMapper objectMapper, ContactService contactService) {
		super(objectMapper);
		this.contactService = contactService;
	}


	@Override
	public ResponseEntity<HttpStatus> save(ContactDto contactDto) {
		contactService.save(contactDto);

		return new ResponseEntity<>(CREATED);
	}

	@Override
	public ResponseEntity<Set<ContactDto>> findAllContactsByClientId(Long id) {
		Set<ContactDto> result = contactService.findAllContactsByClientId(id);

		return !result.isEmpty()
				? new ResponseEntity<>(result, OK)
				: new ResponseEntity<>(null, NO_CONTENT);
	}

	@Override
	public ResponseEntity<Set<ContactDto>> findAllContactsByTypeAndById(Long id, ContactType contactType) {
		Set<ContactDto> result = contactService.findAllContactsByTypeAndById(contactType, id);

		return !result.isEmpty()
				? new ResponseEntity<>(result, OK)
				: new ResponseEntity<>(null, NO_CONTENT);
	}
}
