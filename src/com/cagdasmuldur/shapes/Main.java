package com.cagdasmuldur.shapes;

import java.util.Arrays;

import java.util.Scanner;
import java.io.File; // Import the File class
import java.io.FileNotFoundException; // Import this class to handle errors

public class Main {
	// Filename variable for safer and easier reading
	private static final String fileName = "shapes.txt";

	/**
	 * Main method reads the file catches FileNotFoundException splits each line
	 * until hasNextLine returns null Catches a custom exception if any of the
	 * values on any line is not correct. Then decrements the counter by one to
	 * overwrite garbage value At last calls the printShapes method to print all
	 * shapes
	 */
	public static void main(String[] args) {
		// How to get rid of this
		int arrSize = lineCounter(fileName);
		Shape[] shapes = new Shape[arrSize];
		int i = 0;
		try {
			File myObj = new File(fileName);
			Scanner myReader = new Scanner(myObj);
			while (myReader.hasNextLine()) {
				String data = myReader.nextLine();
				String[] arrOfData = data.split(",");
				try {
					shapes[i] = setShape(arrOfData);
					i++;
				} catch (InvalidValueException | InvalidShapeException | IllegalArgumentException e) {
					System.out.println(e.getMessage());
					i--;
				}

			}
			myReader.close();
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}

		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~Array Of Shapes~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		printShapes(shapes);
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("~~~Array Of Shapes Without The Least Perimetered Triangle~~~");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		printShapes(deleteMinShapePerimeter(shapes, "Triangle"));
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~Total Perimeters~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		displayTotalPerimterOfShape(shapes, "Parallelogram");
		displayTotalPerimterOfShape(shapes, "Triangle");
		displayTotalPerimterOfShape(shapes, "Circle");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
	}

	/** Line counter */
	public static int lineCounter(String fileName) {
		int i = 0;
		try {
			File myObj = new File(fileName);
			Scanner myReader = new Scanner(myObj);
			while (myReader.hasNextLine()) {
				myReader.nextLine();
				i++;
			}
			myReader.close();
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}
		return i;
	}

	/**
	 * Gets String array and the side counter by the shapes' need. Returns a double
	 * array containing the "valid" array of sides Checks the each value and if its
	 * not valid ( <= 0 ) throws a custom exception Named it doubleArrayParser
	 * because of the naming convention in double class
	 */
	public static double[] doubleArrayParser(String[] arrOfData, int sideCount) {
		double[] arrOfSides = new double[sideCount];
		for (int i = 0; i < sideCount; i++) {
			arrOfSides[i] = Double.parseDouble(arrOfData[i]);
		}
		return arrOfSides;
	}

	/**
	 * Checks the validity of all sides if there is a valid value for each side
	 * returns true otherwise false
	 */
	public static boolean checkValues(String[] arrOfData, int sideCount) {
		boolean isCorrect = false;
		double[] arrOfSides = new double[sideCount];
		try {
			arrOfSides = doubleArrayParser(arrOfData, sideCount);
			for (double side : arrOfSides) {
				if (side > 0) {
					isCorrect = true;
				} else {
					isCorrect = false;
				}
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println(e.getMessage());
		}

		return isCorrect;
	}

	/**
	 * Calls appropriate constructor by the first index of the array. Returns a
	 * Shape object if there is no match for the shape name throws a custom
	 * exception
	 * 
	 * @throws InvalidShapeException
	 */
	public static Shape setShape(String[] arrOfData) throws InvalidValueException, InvalidShapeException {
		Shape shape = null;
		double[] sides;
		String[] arrOfSides = Arrays.copyOfRange(arrOfData, 1, arrOfData.length);
		switch (arrOfData[0]) {
			case "Circle":
				// if (checkValues(arrOfSides, 1)) {
					sides = doubleArrayParser(arrOfSides, 1);
					shape = new Circle(arrOfData[0], sides);
				// }
				break;
			case "Rectangle":
				// if (checkValues(arrOfSides, 2)) {
					sides = doubleArrayParser(arrOfSides, 2);
					shape = new Rectangle(arrOfData[0], sides);
				// }
				break;
			case "Square":
				// if (checkValues(arrOfSides, 1)) {
					sides = doubleArrayParser(arrOfSides, 1);
					shape = new Square(arrOfData[0], sides);
				// }
				break;
			case "Triangle":
				// if (checkValues(arrOfSides, 3)) {
					sides = doubleArrayParser(arrOfSides, 3);
					shape = new Triangle(arrOfData[0], sides);
				// }
				break;
			case "Parallelogram":
				// if (checkValues(arrOfSides, 2)) {
					sides = doubleArrayParser(arrOfSides, 2);
					shape = new Parallelogram(arrOfData[0], sides);
				// }
				break;
			default:
				throw new InvalidValueException("Wrong Shape name!!");
		}
		if (shape == null) {
			throw new InvalidShapeException();
		}
		return shape;
	}

	/**
	 * Calls toString function for every Shape element inside the array catches the
	 * ArrayIndexOutOfBoundsException and NullPointerException.
	 */
	public static void printShapes(Shape[] shapes) {
		int i = 0;
		try {
			for (i = 0; i <= shapes.length; i++) {
				System.out.println(shapes[i].toString());
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println(e.getMessage());
		} catch (NullPointerException e) {

			System.out.println("Total Shapes: " + i);
		}
	}

	/**
	 * Gets array of shapes and a shape name to delete desired shape's member which
	 * has the smallest perimeter. Iterated through array and compares each
	 * perimeter which belongs to desired shape. If it is less than leastPerimeter's
	 * value that becomes the new least and its' index gets assigned to
	 * leatPerimeterIndex Finally deleteIndexAndPushArray method gets called and
	 * return new array without smallest perimetered shape.
	 */
	public static Shape[] deleteMinShapePerimeter(Shape[] arrOfShapes, String shapeName) {
		double leastPerimeter = 100;
		int leastPerimeterIndex = 0;
		int i = 0;
		try {
			for (i = 0; i < arrOfShapes.length; i++) {
				if (arrOfShapes[i].getName().equals(shapeName)) {
					if (arrOfShapes[i].getPerimeter() < leastPerimeter) {
						leastPerimeter = arrOfShapes[i].getPerimeter();
						leastPerimeterIndex = i;
					}
				}
			}
		} catch (NullPointerException | ArrayIndexOutOfBoundsException e) {

		}
		return deleteIndexAndPushArray(arrOfShapes, leastPerimeterIndex);

	}

	/**
	 * Gets shape array, index of number that will be deleted and a length. Iterates
	 * over the array until iterator is not less than leastPerimeterIndex from that
	 * point it starts to overwrite each element with the next one
	 */
	public static Shape[] deleteIndexAndPushArray(Shape[] arrOfShapes, int leastPerimeterIndex) {
		Shape[] newArrOfShapes = new Shape[arrOfShapes.length - 1];

		try {
			for (int i = 0; i < arrOfShapes.length; i++) {
				if (i < leastPerimeterIndex) {
					newArrOfShapes[i] = arrOfShapes[i];
				} else {
					newArrOfShapes[i] = arrOfShapes[i + 1];
				}
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println(e.getMessage());
		}
		return newArrOfShapes;
	}

	/**
	 * Gets an array of shapes and the name of shape. Iterates over the array until
	 * the index value is null. Prints the value with the shape name
	 */
	public static void displayTotalPerimterOfShape(Shape[] arrOfShapes, String shapeName) {
		double totalPerimeters = 0;
		try {
			for (Shape shape : arrOfShapes) {
				if (shape.getName().equalsIgnoreCase(shapeName)) {
					totalPerimeters += shape.getPerimeter();
				}
			}
		} catch (NullPointerException e) {
		}
		;
		System.out.println("Total Perimeter of " + shapeName + ": " + totalPerimeters);
	}
}
