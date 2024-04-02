package com.example.productservice;

import com.example.productservice.dto.ProductRequest;
import com.example.productservice.dto.ProductResponse;
import com.example.productservice.model.Product;
import com.example.productservice.repository.ProductRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.testcontainers.containers.MongoDBContainer;
import org.testcontainers.junit.jupiter.Container;

import java.math.BigDecimal;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class ProductServiceApplicationTests {

	@Container
    static MongoDBContainer mongoDBContainer = new MongoDBContainer("mongo:4.4.2");
	@Autowired
	private MockMvc mockMvc;
	@Autowired
	private ObjectMapper objectMapper;//from jackson library - it will convert the POJO object to JSON and JSON to POJO

	@Autowired
	private ProductRepository productRepository;


	static {
		mongoDBContainer.start();
	}

	@DynamicPropertySource
	static void setProperties(DynamicPropertyRegistry dynamicPropertyRegistry){
		dynamicPropertyRegistry.add("spring.data.mongodb.uri", mongoDBContainer::getReplicaSetUrl);
	}

	@Test
	void shouldCreateProduct() throws Exception {
		var productRequest = getProductRequest();
		//need to convert the POJO to String
		String productRequestAsString = objectMapper.writeValueAsString(productRequest);

		mockMvc.perform(MockMvcRequestBuilders.post("/api/product")
				.contentType(MediaType.APPLICATION_JSON)
				.content(productRequestAsString))
				.andExpect(status().isCreated());
		Assertions.assertEquals(1, productRepository.findAll().size());
	}

	private ProductRequest getProductRequest() {
		return ProductRequest.builder()
				.name("iPhone 13")
				.description("iPhone 13")
				.price(BigDecimal.valueOf(1200))
				.build();
	}


	private List<ProductResponse> getProductResponseList() {
		ProductResponse prA = ProductResponse.builder()
				.id("6604ec9d2512723aef1d3791")
				.name("iPhone 13")
				.description("iPhone 13")
				.price(BigDecimal.valueOf(1200))
				.build();
		return List.of(prA);
	}



	private Product mapToProduct(ProductResponse productResponse) {
		return Product.builder()
				.id(productResponse.getId())
				.name(productResponse.getName())
				.description(productResponse.getDescription())
				.price(productResponse.getPrice()).build();
	}
}
