package com.mydev.java;

import java.util.ArrayList;
import java.util.List;

class PrintData<T> {

	private T obj;

	void add(T obj) {
		this.obj = obj;
	}

	void print() {
		System.out.println("Class name - " + obj.getClass());
	}

}

class Shape {
	void draw() {
		System.out.println("Draw shape");
	}
}

class Rectangle extends Shape {
	void draw() {
		System.out.println("Draw Rectangle");
	}
}

class Square extends Rectangle {
	void draw() {
		System.out.println("Draw Square");
	}
}

/**
 * Generics basics Type safety, Type casting T - Type E - Element K - Key N -
 * Number V - Value
 */
public class Generics {
	public static void main(String[] args) {
		List names = new ArrayList();
		names.add("Bryan");
		names.add("Charles");
		// names.add(44); //Compile time error if using generics

		for (int i = 0; i < names.size(); i++) {
			String result = (String) names.get(i); // Type casting needed
			System.out.println(result);
		}

		List<String> namesList = new ArrayList<String>();
		namesList.add("Bryan");
		namesList.add("Charles");
		// namesList.add(44); //Hence type safety

		for (int i = 0; i < namesList.size(); i++) {
			String result = namesList.get(i); // type casting not needed with Generics
			System.out.println(result);
		}

		// Generic class

		PrintData<String> testObj1 = new PrintData<String>();
		testObj1.add("test");
		PrintData<Integer> testObj2 = new PrintData<Integer>();
		testObj2.add(2);
		PrintData<Double> testObj3 = new PrintData<Double>();
		testObj3.add(44.0);

		testObj1.print();
		testObj2.print();
		testObj3.print();

		// Generic method
		Integer[] intArray = { 10, 20, 30, 40, 50 };
		Character[] charArray = { 'J', 'A', 'V', 'A' };

		printArray(intArray);
		printArray(charArray);

		// Wildcards with generics

		Shape shape = new Shape();
		Rectangle rectanle = new Rectangle ();
		Square square = new Square ();
		List<Shape> shapeList1 = new ArrayList<Shape>();
		shapeList1.add(shape);
		drawShapeExtend(shapeList1);
		
		List<Rectangle> shapeList2 = new ArrayList<Rectangle>();
		shapeList2.add(rectanle);
		drawShapeExtend(shapeList2);
		
		List<Square> shapeList3 = new ArrayList<Square>();
		shapeList3.add(square);
		drawShapeExtend(shapeList3);
		
		drawShapeSuper(shapeList1);
		drawShapeSuper(shapeList2);
		//drawShapeSuper(shapeList3); // Cannot call Square as only super class are eligible
	}

	public static void drawShapeExtend (List<? extends Shape> shapes) {
		
		//For each introduced in Java 5
		for(Shape shape:shapes)
			shape.draw();
	}
	
	public static void drawShapeSuper (List<? super Rectangle> shapes) {
		System.out.println(shapes.getClass());
	}
	
	public static <E> void printArray(E[] elements) {
		for (E element : elements) {
			System.out.println(element);
		}
	}
}
