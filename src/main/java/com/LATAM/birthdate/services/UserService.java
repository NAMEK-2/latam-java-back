package com.LATAM.birthdate.services;

import com.LATAM.birthdate.dto.UserEntryDto;
import com.LATAM.birthdate.dto.UserReturnBirthdayMessageDto;

public interface UserService {
	
	public UserReturnBirthdayMessageDto SendBirthdateMessage(UserEntryDto user);

}
