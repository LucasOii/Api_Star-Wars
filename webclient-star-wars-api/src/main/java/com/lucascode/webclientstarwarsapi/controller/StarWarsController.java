package com.lucascode.webclientstarwarsapi.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.lucascode.webclientstarwarsapi.client.StarWarsClient;
import com.lucascode.webclientstarwarsapi.response.FilmsResponse;
import com.lucascode.webclientstarwarsapi.response.ListOfFilmsResponse;
import com.lucascode.webclientstarwarsapi.response.PeopleResponse;
import lombok.AllArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@AllArgsConstructor
@RequestMapping("/webclient")
public class StarWarsController {
	
	StarWarsClient starWarsClient;


    @GetMapping("/People/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<PeopleResponse> getPeoplerById(@PathVariable String id) {
        return starWarsClient.findAndPeopleById(id);

    }
    
    @GetMapping("/films/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<FilmsResponse> getFilmsById(@PathVariable String id) {
        return starWarsClient.findAndFilmsById(id);

    }


    @GetMapping("/films")
    @ResponseStatus(HttpStatus.OK)
    public Flux<ListOfFilmsResponse> ListAllFilms() {
        return starWarsClient.ListAllFilms();

    }

}
