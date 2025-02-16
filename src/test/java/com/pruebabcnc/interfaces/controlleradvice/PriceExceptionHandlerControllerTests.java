package com.pruebabcnc.interfaces.controlleradvice;

import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.pruebabcnc.exceptions.DateParserException;
import com.pruebabcnc.exceptions.NotFoundException;
import com.pruebabcnc.utils.ExceptionHandlerConstants;

@SpringBootTest
class PriceExceptionHandlerControllerTests {

	private PriceExceptionHandlerController controller = new PriceExceptionHandlerController();

	@Test
	void testHandleDateParserException() {
	    DateParserException ex = new DateParserException("Incorrect date format. Dates must use the yyyy-MM-dd HH:mm:ss format");

	    ResponseEntity<Map<String, Object>> response = controller.handleDateParserException(ex);

	    assertEquals(ExceptionHandlerConstants.ERROR_TYPE_BAD_REQUEST, response.getBody().get(ExceptionHandlerConstants.ERROR));
	    assertEquals("Incorrect date format. Dates must use the yyyy-MM-dd HH:mm:ss format", response.getBody().get(ExceptionHandlerConstants.MESSAGE));
	}
	
	@Test
	void testHandleNotFoundException() {
		NotFoundException ex = new NotFoundException("No results found for the filters provided");

	    ResponseEntity<Map<String, Object>> response = controller.handleNotFoundException(ex);

	    assertEquals(ExceptionHandlerConstants.ERROR_TYPE_NOT_FOUND, response.getBody().get(ExceptionHandlerConstants.ERROR));
	    assertEquals("No results found for the filters provided", response.getBody().get(ExceptionHandlerConstants.MESSAGE));
	}
	
	@Test
	void testMissingServletRequestParameterException() {
		MissingServletRequestParameterException ex = new MissingServletRequestParameterException("productId", "Long");

	    ResponseEntity<Map<String, Object>> response = controller.handleMissingServletRequestParameterException(ex);

	    assertEquals(ExceptionHandlerConstants.ERROR_TYPE_BAD_REQUEST, response.getBody().get(ExceptionHandlerConstants.ERROR));
	    assertEquals("Required request parameter: 'productId' not provided.", response.getBody().get(ExceptionHandlerConstants.MESSAGE));
	}
	
	@Test
	void testMethodArgumentTypeMismatchException() {
	       MethodArgumentTypeMismatchException ex = new MethodArgumentTypeMismatchException("identifier", Long.class, "productId", null,null);

	    ResponseEntity<Map<String, Object>> response = controller.handleTypeMismatchException(ex);

	    assertEquals(ExceptionHandlerConstants.ERROR_TYPE_BAD_REQUEST, response.getBody().get(ExceptionHandlerConstants.ERROR));
	    assertEquals("The parameter: 'productId' has an incorrect type.", response.getBody().get(ExceptionHandlerConstants.MESSAGE));
	}
}
