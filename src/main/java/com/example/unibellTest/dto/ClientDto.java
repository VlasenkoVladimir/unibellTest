package com.example.unibellTest.dto;

import java.io.Serializable;

/**
 * DTO-объект по клиенту для выдачи наружу
 */

public class ClientDto implements Serializable {

	public Long id;
	public String name;

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		ClientDto clientDto = (ClientDto) o;

		if (!id.equals(clientDto.id)) return false;
		return name.equals(clientDto.name);
	}

	@Override
	public int hashCode() {
		int result = id.hashCode();
		result = 31 * result + name.hashCode();
		return result;
	}
}
