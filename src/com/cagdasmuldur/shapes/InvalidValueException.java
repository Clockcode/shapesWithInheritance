package com.cagdasmuldur.shapes;
// CUSTOM EXCEPTION FOR INVALID LENGTH OR SHAPE NAME
public class InvalidValueException extends Exception {
	InvalidValueException(){
		super("Invalid value for length");
	}
	InvalidValueException(String message){
		super(message);
	}
}
