// Title: CMPE223 - HW1 - Question 1
// Author: Mübeccel Eylül Uzer
// ID: 10214914888   
// Section: 02       
// Assignment: 1 (Question 1)
// Description: Represents a passenger (passanger) who travels on the plane.
//              Inherits from Person and stores ticket type and priority.


public class Passanger extends Person {
 private String ticket;
 private int priority;
 
 public Passanger(String name, long ID, String ticket, int priority) {
	 super(name,"passanger",ID);
	 this.ticket=ticket;
	 this.priority=priority;
 }
 public String getTicket() {
	 return ticket;
 }
 public int getPriority() {
	 return priority;
 }
 @Override
 public String display() {
     return "Name: " + name + ", Type: " + type + ", ID: " + ID +
            " Ticket: " + ticket + ", Priority: " + priority;
 }
}
