package com.example.inventoryservice.util;

import com.example.inventoryservice.model.Inventory;
import com.example.inventoryservice.repository.InventoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {

    private final InventoryRepository inventoryRepository;

    @Override
    public void run(String... args) throws Exception {


        Inventory inventory = Inventory.builder()
                .skuCode("iphone-13")
                .quantity(100)
                .build();

        Inventory inventory1 = Inventory.builder()
                .skuCode("iphone-13-red")
                .quantity(0)
                .build();

        inventoryRepository.save(inventory);
        inventoryRepository.save(inventory1);

    }
}
