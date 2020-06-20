package com.LATAM.test.util;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.LATAM.birthdate.BirthdateApplication;
import com.LATAM.birthdate.helpers.Util;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = BirthdateApplication.class)
public class UtilTest {
	
	@Test
	public void GetAgeOkTest() {
		
		Util util = new Util();
		
		LocalDate today = LocalDate.now();
		today = today.minusYears(10);
		String dateTen = (today.getDayOfMonth() + "-" + today.getMonthValue() + "-" + today.getYear());
		
		Integer ageTen = util.getAge(dateTen);
		
		assertNotNull(ageTen);
		assertTrue(ageTen.equals(10));
	}
	
	public void GetAgeNotOkTest() {
		
		Util util = new Util();
		
		LocalDate today = LocalDate.now();
		String dateBirthday = (today.getDayOfMonth() + "-" + today.getMonthValue() + "-" + today.getYear());
		
		Integer ageZero = util.getAge(dateBirthday);
		
		assertNotNull(ageZero);
		assertFalse(!ageZero.equals(0));
	}
	
	@Test
	public void GetDaysOk() {
		
		Util util = new Util();
		
		LocalDate today = LocalDate.now();
		String dateBirthday = (today.getDayOfMonth() + "-" + today.getMonthValue() + "-" + (today.getYear()-10));
		
		assertTrue(util.getDaysToBirthDate(dateBirthday).equals(0));
	}

	@Test
	public void getDaysNotOk() {
		
		Util util = new Util();
		
		LocalDate today = LocalDate.now();
		today = today.plusDays(3);
		
		String dateBirthday = (today.getDayOfMonth() + "-" + today.getMonthValue() + "-" + (today.getYear()-10));
		
		System.out.println("chao" + util.getDaysToBirthDate(dateBirthday));
		
		assertFalse(!util.getDaysToBirthDate(dateBirthday).equals(3));
	}
	

}
