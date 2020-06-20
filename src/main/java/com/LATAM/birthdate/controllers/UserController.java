package com.LATAM.birthdate.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.LATAM.birthdate.dto.StandarResponseDto;
import com.LATAM.birthdate.dto.UserEntryDto;
import com.LATAM.birthdate.services.UserService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


@RestController
@RequestMapping(path="/user/")
@CrossOrigin
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping(path="birthdate/congrats")
	public ResponseEntity<String> getBirthdayDate(
			@Valid @RequestBody UserEntryDto user
		){
	
		Gson g = new GsonBuilder().disableHtmlEscaping().setPrettyPrinting().serializeNulls().create();
		
		StandarResponseDto response = new StandarResponseDto();
		response.setStatus(true);
		response.setData(userService.SendBirthdateMessage(user));
		
    	return ResponseEntity.ok(g.toJson(response));
	}
	
}
