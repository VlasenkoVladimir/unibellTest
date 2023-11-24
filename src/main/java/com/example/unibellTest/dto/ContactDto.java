package com.example.unibellTest.dto;

import com.example.unibellTest.domain.Client;
import com.example.unibellTest.domain.enums.ContactType;

import java.io.Serializable;

/**
 * DTO-объект по контакту клиента для выдачи наружу
 */


public class ContactDto implements Serializable {

	public Long id;

	public Client client;

	public ContactType contactType;

	public String contact;
}
