package com.cagdasmuldur.shapes;

import java.math.RoundingMode;
import java.text.DecimalFormat;

public class Square extends Rectangle {
	
	//CONSTRUCTOR
	public Square(String name, double[] sides) {
		super(name, sides);
		width = sides[0];
		height = sides[0];
	}
	//RETURNS A STRING OF EVERY FIELD AND ITS' VALUE
	public String toString() {
		DecimalFormat df = new DecimalFormat("#.##");
		df.setRoundingMode(RoundingMode.DOWN);
	    return this.getClass().getSimpleName() +
	    		" { Side: " + width + 
	    		" } Perimeter: " + df.format(getPerimeter()) + " | Area:" + df.format(getArea.calculate());
	  }
	  public void setWidth(double width) {
		if (width <= 0) {
			throw new IllegalArgumentException("Input width must be positive value: " + width);
		}
		this.width = width;
		this.height = width;
	}
	public void setHeight(double height) {
		if (height <= 0) {
			throw new IllegalArgumentException("Input height must be positive value: " + width);
		}
		this.width = height;
		this.height = height;
	}

}
