package com.LATAM.birthdate.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.LATAM.birthdate.dto.UserEntryDto;
import com.LATAM.birthdate.dto.UserReturnBirthdayMessageDto;
import com.LATAM.birthdate.helpers.Util;
import com.LATAM.birthdate.services.UserService;

@Service
public class UserImpl implements UserService {
	
	@Autowired
	Util util;

	@Override
	public UserReturnBirthdayMessageDto SendBirthdateMessage(UserEntryDto user) {
		
		Integer age = util.getAge(user.getBirthdate());
		Integer daysToBirthday = util.getDaysToBirthDate(user.getBirthdate());
		
		UserReturnBirthdayMessageDto newReturnUser = new UserReturnBirthdayMessageDto();
		newReturnUser.setName(util.cleanDataEntry(user.getName()));
		newReturnUser.setLastName(util.cleanDataEntry(user.getLastName()));
		newReturnUser.setBirthdate(util.formatDateToReturn(user.getBirthdate()));
		newReturnUser.setAge(age);
		newReturnUser.setDaysToBirthdate(daysToBirthday);
		
		if (daysToBirthday.equals(0)) {
			newReturnUser.setBirthdateMessage(util.callApiPoems());
		} 
		
		return newReturnUser;
	}

}
