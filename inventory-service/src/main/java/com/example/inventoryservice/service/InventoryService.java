package com.example.inventoryservice.service;

import com.example.inventoryservice.model.Inventory;
import com.example.inventoryservice.repository.InventoryRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class InventoryService {

    private final InventoryRepository inventoryRepository;

    public boolean isInStock(String skuCode){
        log.info("isInStock - skuCode {}", skuCode);
        return inventoryRepository.findBySkuCode(skuCode).isPresent();
    }

}
