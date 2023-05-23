package com.ncrhackathon.CartPersonalization.client;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.ncrhackathon.CartPersonalization.model.MealDetailsDTO;
import com.ncrhackathon.CartPersonalization.model.MealsIdDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
public class TastyClient {

	//@Value("${config.api.key}")
	private String apiKey = "376ce525fbmshe9b327abf4a4694p18d760jsn45db2976220b";

    public MealDetailsDTO getRecipeDetailsById(String idMeal) {

        WebClient client = WebClient.create();

        MealDetailsDTO response = client.get()
                .uri("https://themealdb.p.rapidapi.com/lookup.php?i=" + idMeal)
                .header("X-RapidAPI-Key", apiKey)
                .header("X-RapidAPI-Host", "themealdb.p.rapidapi.com")
                .retrieve()
                .bodyToMono(MealDetailsDTO.class)
                .block();

        System.out.println(response);

        return response;

    }

    public MealsIdDTO findRecipeId(String ingredients) {
        //ingredients should be without spaces

        WebClient client = WebClient.create("https://themealdb.p.rapidapi.com");

        MealsIdDTO response = client.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/filter.php")
                        .queryParam("i", ingredients)
                        .build())
                .header("X-RapidAPI-Key", apiKey)
                .header("X-RapidAPI-Host", "themealdb.p.rapidapi.com")
                .retrieve()
                .bodyToMono(MealsIdDTO.class)
                .block();

        System.out.println(response);

        return response;

    }
}
