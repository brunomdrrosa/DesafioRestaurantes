package com.dbserver.restaurantes;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import com.dbserver.restaurantes.controllers.RestaurantController;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc
public class RestaurantResourceTest {

	@Autowired
	private MockMvc mockMvc;

	@InjectMocks
	private RestaurantController restaurantController;

	@Test
	public void addRestaurant() throws Exception {
		String json = "{\"restaurant\": \"Pasmania\",\"address\": \"R. Papa João XXIII, 60\",\"website\": \"https://pasmania.com.br/\",\"description\": \"Lanchonete e delivery especializado em pastéis.\"}";
		mockMvc.perform(post("/restaurants").contentType(MediaType.APPLICATION_JSON).content(json))
				.andExpect(status().isOk()).andExpect(jsonPath("$.restaurant", Matchers.is("Pasmania")))
				.andExpect(jsonPath("$.address", Matchers.is("R. Papa João XXIII, 60")))
				.andExpect(jsonPath("$.website", Matchers.is("https://pasmania.com.br/")))
				.andExpect(jsonPath("$.description", Matchers.is("Lanchonete e delivery especializado em pastéis.")))
				.andExpect(jsonPath("$.*", Matchers.hasSize(6)));
	}
}
