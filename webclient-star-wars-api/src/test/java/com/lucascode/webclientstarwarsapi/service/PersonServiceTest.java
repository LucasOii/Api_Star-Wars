package com.lucascode.webclientstarwarsapi.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import com.lucascode.webclientstarwarsapi.response.Person;
import com.lucascode.webclientstarwarsapi.response.Results;

class PersonServiceTest {

	@InjectMocks
	PersonService personService;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void testFindPerson() {
		Results result = personService.findPerson();
		Assertions.assertNotNull(result);
	}

	@Test
	void testFindPersonById() {
		List<Person> result = personService.findPersonById(1L);
		Assertions.assertNotNull(result);
	}

}
