package com.cagdasmuldur.shapes;

public abstract class Shape {
	protected String name;
	/** For each class, you must provide implementations for toString(),
	 *  at least one constructor, setters/getters, and the documentations 
	 *  for the entire class. */
	public Shape(String name, double[] sides) {
		this.name = name;
	}
	
	  public String toString() {
	    return "Shape: " + name ;
	  }

	  /** Abstract method getArea */
	  public abstract double getArea();

	  /** Abstract method getPerimeter */
	  public abstract double getPerimeter();
}
