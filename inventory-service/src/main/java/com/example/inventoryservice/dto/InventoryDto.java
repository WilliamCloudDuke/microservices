package com.example.inventoryservice.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class InventoryDto {
    private Long Id;
    private String skuCode;
    private Integer quantity;
}
