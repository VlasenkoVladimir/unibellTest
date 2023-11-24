package com.example.unibellTest.controllers.rest.base;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Абстрактный базовый контроллер с маппером
 */

public abstract class BaseControllerImpl implements BaseController {

	private final ObjectMapper objectMapper;

	public BaseControllerImpl(ObjectMapper objectMapper) {
		this.objectMapper = objectMapper;
	}

	protected String toJson(Object value) {
		try {
			return objectMapper.writeValueAsString(value);
		} catch (JsonProcessingException e) {
			throw new RuntimeException("Error while parsing JSON: " + e.getMessage());
		}
	}
}