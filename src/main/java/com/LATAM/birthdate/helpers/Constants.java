package com.LATAM.birthdate.helpers;

public final class Constants {
	
	public static final String URI_API = "https://www.poemist.com/api/v1/randompoems";
	
	/** The Constant EMPTY. */
	public static final String EMPTY 							= "";

	/** Key's Constants. */
	public static final String KEY_MAP_INDEX             		= "id";
	public static final String KEY_MAP_VALUE             		= "value";
	public static final String KEY_MAP_DESCRIPTION         		= "description";
	public static final String KEY_MAP_DETAIL            		= "detail";
	
	/** Database Exception values. */
	public static final Integer KEY_INTERNAL_SERVER_EXCEPTION 	= -1;
	public static final String VAL_INTERNAL_SERVER_EXCEPTION 	= "InternalServerError";
	public static final String DSC_INTERNAL_SERVER_EXCEPTION 	= "An unwarranted error has occurred";

	/** Database Exception values. */
	public static final Integer KEY_WRONG_DATE_EXCEPTION 			= -2;
	public static final String VAL_WRONG_DATE_EXCEPTION 			= "WrongDateFormat";
	public static final String DSC_WRONG_DATE_EXCEPTION 			= "The date must be in the format of DD-MM-YYYY";

	/** Entity data not valid */
	public static final Integer KEY_DATA_NOT_VALID			    = -3;
	public static final String VAL_DATA_NOT_VALID			    = "DataNotValidException";
	public static final String DSC_DATA_NOT_VALID			    = "Invalid Data";
	public static final String DET_DATA_NOT_VALID		        = "components do not have predominant knowledge or " +
												                  "have more than one ";
	public static final String DET_TAGS_NO_MANDATORY            = "The kit does not have the obligatory labels";

	/** Entity data not valid */
	public static final Integer KEY_INTERNAL_ERROR		        = -4;
	public static final String VAL_INTERNAL_ERROR			    = "InternalExceptionError";
	public static final String DSC_INTERNAL_ERROR		        = "Internal error";

	/**Invalid data request**/
	public static final Integer KEY_DATA_INVALID		    = -5;
	public static final String  VAL_DATA_INVALID			= "DataNotValidException";
	public static final String  DSC_DATA_INVALID			= "Invalid data";
	public static final String  DET_DATA_INVALID 		    = "invalid request data";

	/** The Constant EMPTY RESPONSE. */
	public static final String EMPTY_RESPONSE                   = "[]";

	/**
	 * Instantiates a new constants.
	 */
	private Constants() {
		super();
	}

}
