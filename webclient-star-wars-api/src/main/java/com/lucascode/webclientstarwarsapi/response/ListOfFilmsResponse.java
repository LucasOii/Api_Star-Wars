package com.lucascode.webclientstarwarsapi.response;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class ListOfFilmsResponse {
	
	List<FilmsResponse> results;

}
