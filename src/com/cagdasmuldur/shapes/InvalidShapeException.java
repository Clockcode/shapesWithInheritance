package com.cagdasmuldur.shapes;

public class InvalidShapeException extends Exception {
	public InvalidShapeException() {
		super("Not a Suitable Shape");
	}
}
