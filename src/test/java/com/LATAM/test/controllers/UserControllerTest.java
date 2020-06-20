package com.LATAM.test.controllers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDate;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.LATAM.birthdate.BirthdateApplication;
import com.LATAM.birthdate.dto.UserEntryDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = BirthdateApplication.class)
@AutoConfigureMockMvc
public class UserControllerTest {

	@Autowired
	MockMvc mockmvc;
	
	@Autowired
	ObjectMapper objectMapper;
	
	@Test
	public void returnStatusOk() throws JsonProcessingException, Exception {
		
		LocalDate today = LocalDate.now();
		
		UserEntryDto userEntry = new UserEntryDto();
		userEntry.setName("Daniel");
		userEntry.setLastName("Leon");
		userEntry.setBirthdate((today.getDayOfMonth() + "-" + today.getMonthValue() + "-" + today.getYear()).toString());
	
		mockmvc.perform(MockMvcRequestBuilders.post("/user/birthdate/congrats")
            .contentType("application/json")
            .content(objectMapper.writeValueAsString(userEntry)))
			.andExpect(jsonPath("$.status").value(true));
	}
	
	
	@Test
	public void returnStatusOkItsBirthday() throws JsonProcessingException, Exception {
		
		LocalDate today = LocalDate.now();
		today = today.minusYears(10);
		
		UserEntryDto userEntry = new UserEntryDto();
		userEntry.setName("Daniel");
		userEntry.setLastName("Leon");
		userEntry.setBirthdate((today.getDayOfMonth() + "-" + today.getMonthValue() + "-" + today.getYear()).toString());
	
		mockmvc.perform(MockMvcRequestBuilders.post("/user/birthdate/congrats")
            .contentType("application/json")
            .content(objectMapper.writeValueAsString(userEntry)))
			.andExpect(jsonPath("$.data.birthdateMessage").isNotEmpty());
	}
	
	@Test
	public void returnStatusOkNotBirthday() throws JsonProcessingException, Exception {
		
		LocalDate today = LocalDate.now();
		today = today.minusYears(10);
		today = today.minusDays(2);
		
		UserEntryDto userEntry = new UserEntryDto();
		userEntry.setName("Daniel");
		userEntry.setLastName("Leon");
		userEntry.setBirthdate((today.getDayOfMonth() + "-" + today.getMonthValue() + "-" + today.getYear()).toString());
	
		mockmvc.perform(MockMvcRequestBuilders.post("/user/birthdate/congrats")
            .contentType("application/json")
            .content(objectMapper.writeValueAsString(userEntry)))
			.andExpect(jsonPath("$.data.birthdateMessage").isEmpty());
	}
	
	@Test
	public void returnStatusNotOk() throws JsonProcessingException, Exception {
		
		LocalDate today = LocalDate.now();
		
		UserEntryDto userEntry = new UserEntryDto();
		userEntry.setName(null);
		userEntry.setLastName("Leon");
		userEntry.setBirthdate((today.getDayOfMonth() + "-" + today.getMonthValue() + "-" + today.getYear()).toString());
	
		mockmvc.perform(MockMvcRequestBuilders.post("/user/birthdate/congrats")
            .contentType("application/json")
            .content(objectMapper.writeValueAsString(userEntry)))
			.andExpect(status().isBadRequest());
	}
	
}
