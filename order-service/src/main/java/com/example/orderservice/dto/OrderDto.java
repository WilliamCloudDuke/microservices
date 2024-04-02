package com.example.orderservice.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class OrderDto {
    private Long id;
    private String orderNumber;
    private List<OrderLineItemsDto> orderLineItemsDtoList;
}
