package com.ncrhackathon.CartPersonalization.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MealsIdDTO {

    @JsonProperty("meals")
    private List<MiniMealDTO> meals;
}
