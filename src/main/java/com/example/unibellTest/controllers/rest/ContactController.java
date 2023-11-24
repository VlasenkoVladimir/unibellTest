package com.example.unibellTest.controllers.rest;

import com.example.unibellTest.controllers.rest.base.BaseController;
import com.example.unibellTest.domain.enums.ContactType;
import com.example.unibellTest.dto.ContactDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Set;

import static org.springframework.http.MediaType.ALL_VALUE;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * Интерфейс контроллера контактов клиента с описанием методов
 */

@Tag(name = "Контактные данные")
public interface ContactController extends BaseController {

	@Operation(summary = "Сохранение контакта в БД")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "201", description = "Запись сохранена")
	})
	@RequestMapping(value = "/contact", method = POST, consumes = APPLICATION_JSON_VALUE)
	ResponseEntity<HttpStatus> save(
			@RequestBody ContactDto contactDto
	);

	@Operation(summary = "Получение списка всех контактов клиента из БД")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Записи найдены",
					content = {@Content(
							mediaType = "application/json",
							array = @ArraySchema(
									schema = @Schema(implementation = ContactDto.class)
							)
					)}),
			@ApiResponse(responseCode = "204", description = "Записи отсутствуют",
					content = {@Content(schema = @Schema())})
	})
	@RequestMapping(value = "/contacts/{id}", method = GET, consumes = ALL_VALUE, produces = APPLICATION_JSON_VALUE)
	ResponseEntity<Set<ContactDto>> findAllContactsByClientId(
			@Parameter(name = "id", description = "Идентификатор клиента")
			@PathVariable Long id
	);

	@Operation(summary = "Получение списка заданного типа контактов клиента из БД")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Записи найдены",
					content = {@Content(
							mediaType = "application/json",
							array = @ArraySchema(
									schema = @Schema(implementation = Set.class)
							)
					)}),
			@ApiResponse(responseCode = "204", description = "Записи отсутствуют",
					content = {@Content(schema = @Schema())})
	})
	@RequestMapping(value = "/contacts/{id}/{type}", method = GET, consumes = ALL_VALUE, produces = APPLICATION_JSON_VALUE)
	ResponseEntity<Set<ContactDto>> findAllContactsByTypeAndById(
			@Parameter(name = "id", description = "Идентификатор клиента")
			@PathVariable Long id,
			@Parameter(name = "type", description = "Тип контакта")
			@PathVariable ContactType contactType
	);
}
