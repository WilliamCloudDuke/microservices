package com.example.inventoryservice.controller;


import com.example.inventoryservice.dto.InventoryResponse;
import com.example.inventoryservice.service.InventoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/inventory")
@RequiredArgsConstructor
@Slf4j
public class InventoryController {

    private final InventoryService inventoryService;


    // http://localhost:8082/api/inventory?skuCode=iphone-13&skuCode=iphone13-red
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<InventoryResponse> isInStock(@RequestParam List<String> skuCodes){
        log.info("Received inventory check for skuCodes: {}", skuCodes);
        return inventoryService.isInStock(skuCodes);
    }


}
