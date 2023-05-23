package com.ncrhackathon.CartPersonalization.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MiniMealDTO {

        @JsonProperty("strMeal")
        private String strMeal;
        @JsonProperty("strMealThumb")
        private String strMealThumb;
        @JsonProperty("idMeal")
        private String idMeal;
}
