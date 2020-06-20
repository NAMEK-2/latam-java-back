package com.LATAM.birthdate.helpers;

import java.util.HashMap;
import java.util.LinkedHashMap;

import com.google.gson.Gson;

public class MessageErrorHelper {
	
	/**
     * Instantiates a new message error helper.
     */
    private MessageErrorHelper(){
        super();
    }
    
    public static final String dateErrorException(String message) {
    	HashMap<String, Object> error = new LinkedHashMap<>();
    	error.put(Constants.KEY_MAP_INDEX, Constants.KEY_WRONG_DATE_EXCEPTION);
        error.put(Constants.KEY_MAP_VALUE, Constants.VAL_WRONG_DATE_EXCEPTION);
        error.put(Constants.KEY_MAP_DESCRIPTION, Constants.DSC_WRONG_DATE_EXCEPTION);
        error.put(Constants.KEY_MAP_DETAIL, (null != message ? message : Constants.EMPTY));
    	return new Gson().toJson(error);
    }
    
    public static final String dataRequestInvalid(String message) {
        HashMap<String, Object> error = new LinkedHashMap<>();
        error.put(Constants.KEY_MAP_INDEX, Constants.KEY_DATA_INVALID);
        error.put(Constants.KEY_MAP_VALUE, Constants.VAL_DATA_INVALID);
        error.put(Constants.KEY_MAP_DESCRIPTION, Constants.DSC_DATA_INVALID);
        error.put(Constants.KEY_MAP_DETAIL, (null != message ? message : Constants.EMPTY) );
        return new Gson().toJson(error);
    }

    public static final String internalError(Exception exception) {
        HashMap<String, Object> error = new LinkedHashMap<>();
        error.put(Constants.KEY_MAP_INDEX, Constants.KEY_INTERNAL_ERROR);
        error.put(Constants.KEY_MAP_VALUE, Constants.VAL_INTERNAL_ERROR);
        error.put(Constants.KEY_MAP_DESCRIPTION, exception);
        return new Gson().toJson(error);
    }
    

}
