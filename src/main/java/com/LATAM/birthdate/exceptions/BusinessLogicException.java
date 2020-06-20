package com.LATAM.birthdate.exceptions;

public class BusinessLogicException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8000809404498849888L;
	
	/**
     * Instantiates a new busines logic
     */
    public BusinessLogicException() {
        super();
    }

    /**
     * Instantiates a new busines logic
     *
     * @param message the message
     * @param cause the cause
     * @param enableSuppression the enable suppression
     * @param writableStackTrace the writable stack trace
     */
    public BusinessLogicException(String message, Exception cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    /**
     * Instantiates a new busines logic
     *
     * @param message the message
     * @param cause the cause
     */
    public BusinessLogicException(String message, Exception cause) {
        super(message, cause);
    }

    /**
     * Instantiates a new busines logic.
     *
     * @param message the message
     */
    public BusinessLogicException(String message) {
        super(message);
    }

    /**
     * Instantiates a new busines logic
     *
     * @param cause the cause
     */
    public BusinessLogicException(Exception cause) {
        super(cause);
    }

}
