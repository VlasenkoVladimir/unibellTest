package com.example.unibellTest.repositories;

import com.example.unibellTest.domain.Contact;
import com.example.unibellTest.domain.enums.ContactType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Set;

/**
 * Интерфейс репозитория контакта относящегося к клиентской сущности
 */

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {

	Set<Contact> findAllContactsByClientId(Long id);

	@Query(nativeQuery = true,
			value = """
					select *
					from contacts
					where client.id = id
					and contact_type = contactType
					""")
	Set<Contact> findAllContactsByTypeAndById(ContactType contactType, Long id);
}
