package com.cagdasmuldur.shapes;

public abstract class Shape {
	protected String name;
	protected double perimeter;
	protected double area;
	/** For each class, you must provide implementations for toString(),
	 *  at least one constructor, setters/getters, and the documentations 
	 *  for the entire class. */
	public Shape(String nameParam) {
		name = nameParam;
	}
	
	
	public abstract String toString();
	/** Abstract method getArea */
	public abstract double getArea();

	/** Abstract method getPerimeter */
	public abstract double getPerimeter();
	
}
