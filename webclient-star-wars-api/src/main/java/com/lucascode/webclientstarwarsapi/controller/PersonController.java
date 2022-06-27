package com.lucascode.webclientstarwarsapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.lucascode.webclientstarwarsapi.service.PersonService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("persons")
@RequiredArgsConstructor
public class PersonController {

	@Autowired
	PersonService service;

	@GetMapping("/")
	private ResponseEntity<?> listAll() {
		return new ResponseEntity<>(service.findPerson(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	private ResponseEntity<?> getPersonId(@PathVariable Long id) {
		return new ResponseEntity<>(service.findPersonById(id), HttpStatus.OK);
	}

}
