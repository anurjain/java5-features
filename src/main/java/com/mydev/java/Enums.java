package com.mydev.java;

enum Lifecycle {
	START (1),
	INPROGRESS(2),
	DONE(3);
	final int stage;
	private Lifecycle (int stage) {
		this.stage = stage;
	}
	 
	public int state () {
		return stage;
	}
}

public class Enums {
	public static void main(String[] args) {
		Lifecycle stage = Lifecycle.INPROGRESS;
		System.out.println(stage.toString());
		
		if (Lifecycle.INPROGRESS.state() == 2)
			System.out.println("true");
	}

}
