package com.lucascode.webclientstarwarsapi.client;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import com.lucascode.webclientstarwarsapi.response.FilmsResponse;
import com.lucascode.webclientstarwarsapi.response.ListOfFilmsResponse;
import com.lucascode.webclientstarwarsapi.response.PeopleResponse;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@Slf4j
public class StarWarsClient {
	
	 private final WebClient webClient;
	 private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(StarWarsClient.class);


    public StarWarsClient(WebClient.Builder builder) {
        webClient = builder.baseUrl("https://swapi.dev/api/").build();
    }
	    
    public Mono<PeopleResponse> findAndPeopleById(String id) {
        log.info("Buscando pessoa com o id {}", id);
        return webClient
        		.get()
	            .uri("/people/" + id)
	            .accept(APPLICATION_JSON)
	            .retrieve()
	            .onStatus(HttpStatus::is4xxClientError,
	            error -> Mono.error(new RuntimeException("verifique os parâmetros informados")))
	            .bodyToMono(PeopleResponse.class);
        }
    public Mono<FilmsResponse> findAndFilmsById(String id) {
        log.info("Buscando filmes com o id [{}]", id);
        return webClient
                .get()
                .uri("/films/" + id)
                .accept(APPLICATION_JSON)
                .retrieve()
                .onStatus(HttpStatus::is4xxClientError,
                        error -> Mono.error(new RuntimeException("verifique os parâmetros informados")))
                .bodyToMono(FilmsResponse.class);
    }

    public Flux<ListOfFilmsResponse> ListAllFilms() {
        log.info("Listando todos os filmes cadastrados");
        return webClient
                .get()
                .uri("/films")
                .accept(APPLICATION_JSON)
                .retrieve()
                .onStatus(HttpStatus::is4xxClientError,
                        error -> Mono.error(new RuntimeException("verifique os parâmetros informados")))
                .bodyToFlux(ListOfFilmsResponse.class);
    }

}
