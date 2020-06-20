package com.LATAM.birthdate.exceptions;

public class TestException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6017470137130096512L;
	
	public TestException() {
		super();
	}
	
    /**
     * Instantiates a new testException
     *
     * @param message the message
     * @param cause the cause
     * @param enableSuppression the enable suppression
     * @param writableStackTrace the writable stack trace
     */
    public TestException(String message, Exception cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    /**
     * Instantiates a new testException
     *
     * @param message the message
     * @param cause the cause
     */
    public TestException(String message, Exception cause) {
        super(message, cause);
    }

    /**
     * Instantiates a new testException.
     *
     * @param message the message
     */
    public TestException(String message) {
        super(message);
    }

    /**
     * Instantiates a new testException logic
     *
     * @param cause the cause
     */
    public TestException(Exception cause) {
        super(cause);
    }

}
