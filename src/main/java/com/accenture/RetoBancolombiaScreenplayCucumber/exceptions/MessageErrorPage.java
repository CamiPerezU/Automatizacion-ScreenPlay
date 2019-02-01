package com.accenture.RetoBancolombiaScreenplayCucumber.exceptions;

public class MessageErrorPage extends AssertionError {               
	
	private static final long serialVersionUID = 1L;

		public MessageErrorPage(String message, Throwable cause) {       
	        super(message, cause);
	    }
		
		public static String setMessage(String msg) {
			return String.format("El siguiente mensaje contiene un error", msg);
		}

}
