package com.example.unibellTest.domain;

import com.example.unibellTest.domain.enums.ContactType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

/**
 * Сущность контактной информации по клиенту (ContactType тип контакта)
 */

@Entity
@Table(name = "contacts")
@SequenceGenerator(name = "contact_generator", sequenceName = "contacts_seq", allocationSize = 1)
public class Contact {

	@Id
	@Column(name = "id")
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "client_id", nullable = false, foreignKey = @ForeignKey(name = "FK_CLIENT_CONTACT"))
	private Client client;

	@Column(name = "contact_type", nullable = false)
	private ContactType contactType;

	@Column(name = "contact", nullable = false)
	private String contact;

	public Contact() {
	}

	public Contact(Long id, Client client, ContactType contactType, String contact) {
		this.id = id;
		this.client = client;
		this.contactType = contactType;
		this.contact = contact;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public ContactType getContactType() {
		return contactType;
	}

	public void setContactType(ContactType contactType) {
		this.contactType = contactType;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}
}
