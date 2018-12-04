package com.mydev.java;

/**
 * Add variable arguments to method Rule 1) There can be only one variable
 * argument in the method 2) Variable argument (varargs) must be the last
 * argument.
 * 
 * @author
 *
 */
public class VariableArgument {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		display ("one");
		display ("one","two", "three", "four");
	}

	public static void display(String... names) {
		for (String name : names)
			System.out.println(name);
	}
}
