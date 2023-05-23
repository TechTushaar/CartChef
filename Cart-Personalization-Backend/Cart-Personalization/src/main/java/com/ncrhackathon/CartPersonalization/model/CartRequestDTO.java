package com.ncrhackathon.CartPersonalization.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartRequestDTO {

    private List<String> shoppingCart;
}
