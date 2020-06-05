package com.cagdasmuldur.shapes;

import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner;
public class Main {
	public static Shape createShapes(String[] arrOfData) {
		Shape shapes;
        //check the name and send appropriate builder
		switch(arrOfData[0]) {
        case "Circle":
            //check if all fields are correct and full
        	
	        //call builder constructor
        	shapes = new Circle(name, radius);
          break;
        case "Square":
            //check if all fields are correct and full
        	
	        //call builder constructor
        	shapes = new Square(name, xParam);
          break;
        case "Triangle":
            //check if all fields are correct and full
        	
	        //call builder constructor
        	shapes = new Triangle(name, xParam, yParam, zParam);
	          break;
        case "Parallelogram":
            //check if all fields are correct and full
        	
	        //call builder constructor
        	shapes = new Parallelogram(name, xParam, yParam, zParam);
	          break;
        case "Rectangle":
            //check if all fields are correct and full
        	
	        //call builder constructor
        	shapes = new Rectangle(name, xParam, yParam);
	          break;
        default:
          break;
      }
	}
	public static void main(String[] args) {
// If a line is not properly formatted or it does not contain the 
//necessary number of values to correctly describe a shape, your 
//program must ignore that line.
		try {
		      File myObj = new File("shapes.txt");
		      Scanner myReader = new Scanner(myObj);
		      for (int i=0;myReader.hasNextLine();i++) {
		        String data = myReader.nextLine();
		        String[] arrOfData = data.split(",");
		        //Create Shapes by shape name
		        createShapes(arrOfData);


		        
		      }
		      myReader.close();
		    } catch (FileNotFoundException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
//If you cannot build the geometrical shapes with the given values
//(ex. zero or negative values for dimensions, wrong values for 
//three sides of a triangle, etc.), you should throw an exception.
//Therefore, there is a need to define some custom Exception classes
//for some of your classes.

//Your program must be capable of storing all the geometrical shapes 
//read from the file in one data structure. 
//Since arrays are the only data structure that we have covered so far,
//you must use just one array to contain all the shapes in this assignment. 


	}

}
