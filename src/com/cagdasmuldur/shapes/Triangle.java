package com.cagdasmuldur.shapes;

import java.math.RoundingMode;
import java.text.DecimalFormat;

public class Triangle implements Shape {
	private double xSide;
	private double ySide;
	private double zSide;

	// CONSTRUCTOR
	public Triangle(String name, double[] sides) throws InvalidValueException {
		if (sides[0] > 0 && sides[1] > 0 && sides[2] > 0) {
			if(sides[0] + sides[1] > sides[2] && sides[2] + sides[1] > sides[0] && sides[0] + sides[2] > sides[1]){
				xSide = sides[0];
				ySide = sides[1];
				zSide = sides[2];
			} else {
				throw new InvalidValueException("All of the Triangle sides must satisfy side rule!");
			}
		} else {
			throw new IllegalArgumentException(
					"Input side(s) must be positive value: " + sides[0] + ", " + sides[1] + ", " + sides[2]);
		}
	}

	// RETURNS A STRING OF EVERY FIELD AND ITS' VALUE
	public String toString() {
		DecimalFormat df = new DecimalFormat("#.##");
		df.setRoundingMode(RoundingMode.DOWN);
		return this.getClass().getSimpleName() + " { SideX: " + xSide + " SideY: " + ySide + " SideZ: "
				+ zSide + " } Perimeter: " + df.format(getPerimeter());
	}

	// GETTERS AND SETTERS

	@Override
	public double getPerimeter() {
		return xSide + ySide + zSide;
	}

	public double getxSide() {
		return xSide;
	}

	public void setxSide(double xSide) {
		if (xSide <= 0) {
			throw new IllegalArgumentException("Input xSide must be positive value: " + xSide);
		}
		this.xSide = xSide;
	}

	public double getySide() {
		return ySide;
	}

	public void setySide(double ySide) {
		if (ySide <= 0) {
			throw new IllegalArgumentException("Input ySide must be positive value: " + ySide);
		}
		this.ySide = ySide;
	}

	public double getzSide() {
		return zSide;
	}

	public void setzSide(double zSide) {
		if (zSide <= 0) {
			throw new IllegalArgumentException("Input zSide must be positive value: " + zSide);
		}
		this.zSide = zSide;
	}

	@Override
	public String getName() {
		return this.getClass().getSimpleName();
	}

}
