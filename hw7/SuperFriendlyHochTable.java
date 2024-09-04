package com.gradescope.hw7;

import java.util.ArrayList;

/**
 * A table at the Hoch with chairs and people. Hoch tables are never full!
 * (There's always room for N+1.) At a super friendly table, whenever a person
 * is or removed added, they say hello or bye to everyone else at the table.
 * When class starts, everyone says bye.
 */
public class SuperFriendlyHochTable {
	/**
	 * The default number of chairs.
	 */
	public static final int NUMBER_OF_CHAIRS = 10;

	private int numChairs;
	private int numPeople;
	private ArrayList<String> people;

	/**
	 * Constructs a table with the default number of chairs.
	 */
	public SuperFriendlyHochTable() {
		this(SuperFriendlyHochTable.NUMBER_OF_CHAIRS);
	}

	/**
	 * Constructs a table with the specified number of chairs.
	 * 
	 * @param capacity - the number of seats
	 * @throws IllegalArgumentException if the capacity is less than 0
	 */
	public SuperFriendlyHochTable(int capacity) {
		if (capacity < 0) {
			throw new IllegalArgumentException("Tables must start with a capacity of 0 or more");
		}
		numChairs = capacity;
		numPeople = 0;
		people = new ArrayList<String>();
	}

	/**
	 * Returns the number of chairs at this table.
	 */
	public int getNumChairs() {
		return numChairs;
	}

	/**
	 * Returns the number of people at this table.
	 */
	public int getNumPeople() {
		return numPeople;
	}

	/**
	 * Returns list of people at this table.
	 */
	public String getPeople() {
		return people.toString();
	}

	/**
	 * Returns true because Hoch tables are never full.
	 */
	public boolean emptySeat() {
		return true;
	}

	/**
	 * Adds a person to this table if there is space.
	 * 
	 * @param name - the name of the person to add
	 * @return a welcome message
	 */
	public String addPerson(String name) {
		// add a chair if needed
		if (numChairs == numPeople) {
			numChairs++;
		}

		// greet the person
		String welcome = "";
		if (emptySeat()) {
			numPeople++;
			people.add(name);
			if (numPeople == 1) {
				welcome = "(Silence - no one is here to say hello.)";
			} else {
				welcome = "Welcome " + name + "!";
			}
		} else {
			if (numPeople == 0) {
				welcome = "(Silence - no one is here to say sorry.)";
			} else {
				welcome = "Sorry - there is no space for you " + name + ".";
			}
		}

		String thanks = "";
		if (numPeople > 1) {
			String oldNames = people.subList(0, people.size() - 1).toString();
			oldNames = oldNames.substring(1, oldNames.length() - 1); // strip square brackets
			thanks = "Thanks " + oldNames + "!!!!!";
		}

		if (welcome != "" && thanks != "") {
			welcome += " ";
		}

		return welcome + thanks;
	}

	/**
	 * Removes a person from this table.
	 * 
	 * @param name - the name of the person to remove
	 * @return a goodbye message
	 */
	public String removePerson(String name) {
		boolean wasRemoved = people.remove(name);
		if (!wasRemoved) {
			return "Weird! " + name + " was not here!";
		}

		numPeople--;
		if (numPeople == 0) {
			return "(Silence - no one is here to say goodbye.)";
		}
		String names = people.toString();
		names = names.substring(1, names.length() - 1); // strip square brackets
		return "Bye " + name + ". " + "Bye " + names + ".";
	}

	/**
	 * Clears the table as everyone goes to class.
	 * 
	 * @return a goodbye message
	 */
	public String classStartingSoon() {
		String message;
		if (numPeople > 1) {
			message = "Bye everyone!";
		} else {
			message = "(Silence - no one is here to say goodbye.)";
		}
		numPeople = 0;
		people.clear();
		return message;
	}
}
