package com.example.unibellTest.mappers;

import com.example.unibellTest.domain.Client;
import com.example.unibellTest.domain.Contact;
import com.example.unibellTest.dto.ClientDto;
import com.example.unibellTest.dto.ContactDto;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import static org.mapstruct.NullValuePropertyMappingStrategy.IGNORE;

/**
 * Маппер
 */

@Mapper(componentModel = "spring")
public abstract class ObjectMapper {

	public abstract Client clientDtoToClient(ClientDto clientDto);

	public abstract ClientDto clientToClientDto(Client client);

	@BeanMapping(nullValuePropertyMappingStrategy = IGNORE)
	public abstract void updateClientFromClientDto(ClientDto clientDto, @MappingTarget Client client);

	public abstract Contact contactDtoToContact(ContactDto contactDto);

	public abstract ContactDto contactToContactDto(Contact contact);

	@BeanMapping(nullValuePropertyMappingStrategy = IGNORE)
	public abstract void updateContactFromContactDto(ContactDto contactDto, @MappingTarget Contact contact);
}
