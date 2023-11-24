package com.example.unibellTest.services;

import com.example.unibellTest.domain.enums.ContactType;
import com.example.unibellTest.dto.ContactDto;
import com.example.unibellTest.mappers.ObjectMapper;
import com.example.unibellTest.repositories.ContactRepository;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

/**
 * Сервисный слой для бизнес-логики сущности Contact
 */

@Service
public class ContactService {

	protected final ContactRepository contactRepository;

	private final ObjectMapper objectMapper;

	public ContactService(ContactRepository contactRepository, ObjectMapper objectMapper) {
		this.contactRepository = contactRepository;
		this.objectMapper = objectMapper;
	}

	public void save(ContactDto contactDto) {
		contactRepository.save(objectMapper.contactDtoToContact(contactDto));
	}

	public Set<ContactDto> findAllContactsByClientId(Long id) {

		return contactRepository
				.findAllContactsByClientId(id)
				.stream()
				.map(objectMapper::contactToContactDto)
				.collect(Collectors.toSet());
	}

	public Set<ContactDto> findAllContactsByTypeAndById(ContactType contactType, Long id) {

		return contactRepository
				.findAllContactsByTypeAndById(contactType, id)
				.stream()
				.map(objectMapper::contactToContactDto)
				.collect(Collectors.toSet());
	}
}
