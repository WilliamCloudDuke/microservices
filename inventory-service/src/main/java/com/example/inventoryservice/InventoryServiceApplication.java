package com.example.inventoryservice;

import com.example.inventoryservice.model.Inventory;
import com.example.inventoryservice.repository.InventoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.example.inventoryservice"})
public class InventoryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(InventoryServiceApplication.class, args);
    }

    @Bean
    public CommandLineRunner loadData(InventoryRepository inventoryRepository) {
        return args -> {
            Inventory inventory = Inventory.builder()
                    .skuCode("Iphone_13")
                    .quantity(100)
                    .build();

            Inventory inventory1 = Inventory.builder()
                    .skuCode("Iphone_13_red")
                    .quantity(0)
                    .build();

            inventoryRepository.save(inventory);
            inventoryRepository.save(inventory1);
        };
    }
}
