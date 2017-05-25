package week1;

import java.util.ArrayList;
import java.util.List;

/**
 * A playground for people at the University of Toronto.
 */
public class UofT {

	public static void main(String[] args) {
		String[] name = new String[] { "Lindsey", "Shorser" };
		Person lindsey = new Person(name, "shorser");

		System.out.println(lindsey.toString());

		// This automagically calls paul.toString();
		// Whenever Java needs the String representation of an object,
		// it calls the toString method.
		System.out.println(lindsey);

		Student harry = new Student(
				new String[] {"Harry", "Potter"},
				"potterha",
				"123456789");

		System.out.println(harry);

		ArrayList people = new ArrayList();
		people.add(harry);
		people.add(lindsey);

		System.out.println("People at the UofT:");
		for (Object o : people) {
			System.out.println(o); // What's the output going to be?
		}
	}
}
