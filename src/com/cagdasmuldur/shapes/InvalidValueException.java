package com.cagdasmuldur.shapes;

public class InvalidValueException extends Exception {
	InvalidValueException(){
		super("Invalid value for length");
	}
	InvalidValueException(String message){
		super(message);
	}
}
