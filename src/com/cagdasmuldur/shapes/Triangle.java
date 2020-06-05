package com.cagdasmuldur.shapes;

public class Triangle extends Shape{
	private double base;
	private double height;
	private double xSide;
	private double ySide;
	public static class Builder {
		private double base;
		private double height;
		private double xSide;
		private double ySide;
		Builder(){};
		public double getBase() {
			return this.base;
		}
		public void setBase(double base) {
			this.base = base;
		}
		public void setxSide(double side) {
			this.xSide = side;
		}
		public double getxSide() {
			return xSide;
		}
		public void setySide(double side) {
			this.ySide = side;
		}
		public double getySide() {
			return ySide;
		}
		public void setHeight(double height) {
			this.height = height;
		}
		public double getHeight() {
			return height;
		}
		
	}
	public Triangle(String nameParam, double base, double xSide, double ySide, double height) {
		super(nameParam);
		// TODO Auto-generated constructor stub
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

	@Override
	public double getPerimeter() {
		// TODO Auto-generated method stub
		return 0;
	}

}
