package com.cagdasmuldur.shapes;

public class Shape {
	private String name;
	private double xDimension;
	private double yDimension;
	private double zDimension;
	/** For each class, you must provide implementations for toString(),
	 *  at least one constructor, setters/getters, and the documentations 
	 *  for the entire class. */
	public Shape(String nameParam, double xParam, double yParam, double zParam) {
		name = nameParam;
		xDimension = xParam;
		yDimension = yParam;
		zDimension = zParam;
	}
}
