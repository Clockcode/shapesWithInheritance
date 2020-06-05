package com.cagdasmuldur.shapes;

//import simple.SampleAbstract.GeometricObject.Override;

public class Circle extends Shape{
	private double radius;
	public static class Builder {
		private double radius;

		Builder(){};
		public void setRadius(double radius) {
			this.radius = radius;
		}
		public double getRadius() {
			return this.radius;
		}
		
	}
	Circle(String name, double radius){
		super(name);
//		radius = radiusParam;
	}
	@Override /** Return perimeter */
	  public double getPerimeter() {
	    return 2 * xDimension * Math.PI;
	  }
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public double getArea() {
		// TODO Auto-generated method stub
		return 0;
	}
}
