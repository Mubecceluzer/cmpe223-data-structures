// Title: CMPE223 - HW1 - Question 1
// Author: Mübeccel Eylül Uzer
// ID: 10214914888   
// Section: 02       
// Assignment: 1 (Question 1)
// Description: Represents a cabin crew member who works on the airplane.
//              Inherits from Person and stores job title and credit score.


public class Cabin_Crew extends Person {
private String job;
private double credit;

public Cabin_Crew(String name, long ID, String job, double credit) {
	super(name,"cabin-crew",ID);
	this.job=job;
	this.credit=credit;
}
public String getJob() {
return job;
}
public double getCredit() {
return credit;
}
@Override
public String display() {
	return super.display() + " Job: " + job + ", Credit: " + credit;
}
}
