package com.LATAM.birthdate.helpers;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Random;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.LATAM.birthdate.dto.PoemReturn;
import com.LATAM.birthdate.exceptions.BusinessLogicException;

@Component
public class Util {
	
	/**
	 * Calcula la Edad del usuario
	 * @param birthdate: fecha de nacimiento del usuario en string (DD-MM-YYYY)
	 * @return
	 */
	public Integer getAge(String birthdate) {
		
        LocalDate today = LocalDate.now();
        LocalDate birth = this.formatterDate(birthdate);
        
		Period period = Period.between(birth, today); 
		
		return period.getYears();
	}
	
	/**
	 * Calcula cuantos dias faltan para el cumpleaños del usuario
	 * @param birthdate: fecha de nacimiento del usuario en string (DD-MM-YYYY)
	 * @return Integer dias para cumpleaños
	 */
	public Integer getDaysToBirthDate(String birthdate) {
		
		LocalDate today = LocalDate.now();
		LocalDate birth = this.formatterDate(birthdate);
	
        birth = birth.withYear(today.getYear());
		
        Integer days = (int) ChronoUnit.DAYS.between(today, birth);
        
        if (today.isAfter(birth)) {
        	birth = birth.plusYears(1);
        	days = (int) ChronoUnit.DAYS.between(today ,birth);
        }
        
        if (days == 0) {
        	if (this.getAge(birthdate) == 0) {
        		days = (int) ChronoUnit.DAYS.between(today,today.plusYears(1));
        	}
        }
        
        return days;
	}
	
	/**
	 * Retorna un poema al azar llamando a la api de poemas
	 * @return Poem
	 */
	public PoemReturn callApiPoems() {
		
		RestTemplate restTemplate = new RestTemplate();
		
		PoemReturn[] poems = restTemplate.getForObject(Constants.URI_API, PoemReturn[].class);
		
		Random number = new Random();
		Integer indice = number.nextInt(poems.length);
		
		return poems[indice];
		
	}
	
	
	/**
	 * Pasa String de fecha a LocalDate
	 * @param birthdate
	 * @return
	 */
	public LocalDate formatterDate(String birthdate) {
		
		Date birthdateDate = null;
		
		try {
        	SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        	birthdateDate = formatter.parse(birthdate);
        } catch(Exception e) {
        	throw new BusinessLogicException(MessageErrorHelper.dateErrorException("Las fechas enviadas solo deben ser numeros"));
        }

		LocalDate birth = birthdateDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		
		if (birth.isAfter(LocalDate.now())) {
			throw new BusinessLogicException(MessageErrorHelper.dateErrorException("Las fechas enviada no puede ser superior a hoy."));
		}
		
		return birth;
	}
	
	/**
	 * Formate la fecha en el formato de entrega
	 * @param birthdate
	 * @return
	 */
	public String formatDateToReturn(String birthdate) {
		
		LocalDate birth = this.formatterDate(birthdate);
		
		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yy");
        return birth.format(format);
	}
	
	/**
	 * Limpia una string de espacios y devuelve el primer valor antes de un especio
	 * se usa para obtener 1 nombre y apellido si llegan 2 a la api
	 * @param word : string
	 * @return
	 */
	public String cleanDataEntry(String word) {
		return word.trim().split(" ")[0];
	}

}
