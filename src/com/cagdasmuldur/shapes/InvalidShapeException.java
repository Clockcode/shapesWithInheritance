package com.cagdasmuldur.shapes;
// CUSTOM EXCEPTION FOR THE SITTUATIONS WHERE SHAPE IS NULL
public class InvalidShapeException extends Exception {
	public InvalidShapeException() {
		super("Not a Suitable Shape");
	}
}
