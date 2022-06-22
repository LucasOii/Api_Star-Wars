package com.lucascode.webclientstarwarsapi.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class FilmsResponse {
	private String id;
	private String title;
	private List<String> characters;
	private String url;
}



