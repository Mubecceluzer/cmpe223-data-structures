// Title: CMPE223 - HW1 - Question 1
// Author: Mübeccel Eylül Uzer
// ID: 10214914888   
// Section: 02       
// Assignment: 1 (Question 1)
// Description: Base class that represents a person (passenger or cabin crew).



public class Person {
 
	protected String name;
	protected String type;
	protected long ID;
	
	public Person(String name, String type, long ID) {
		this.name=name;
		this.type=type;
		this.ID=ID;
	}
	public String display() {
		return "Name: "+ name + ", Type: " + type + ", ID: " + ID;
	}
}
