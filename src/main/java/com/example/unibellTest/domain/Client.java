package com.example.unibellTest.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

/**
 * Клиентская сущность содержит множества контактных данных клиента
 */

@Entity
@Table(name = "clients", uniqueConstraints = {@UniqueConstraint(name = "uniqueName", columnNames = "name")})
@SequenceGenerator(name = "client_generator", sequenceName = "clients_seq", allocationSize = 1)
public class Client {

	@Id
	@Column(name = "id")
	private Long id;

	@Column(name = "name", nullable = false)
	private String name;

	public Client() {
	}

	public Client(Long id, String name) {
		this.id = id;
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}