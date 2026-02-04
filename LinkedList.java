// Title: CMPE223 - HW1 - Question 1
// Author: Mübeccel Eylül Uzer
// ID: 10214914888   
// Section: 02       
// Assignment: 1 (Question 1)
// Description:Single LinkedList class that can store either people (Person,
//Passanger, Cabin_Crew) or other LinkedList instances as nodes.
//Has exactly ONE public insertion method: insert(Object x).



import java.util.ArrayList;
import java.util.List;

public class LinkedList {

  
    private static class Node {
        Object data;
        Node next;
        Node(Object d) { this.data = d; }
    }

    private Node head;

    private String listType;

    public LinkedList(String listType) {
        this.listType = listType;
    }

    public boolean isEmpty() { return head == null; }

    public void insert(Object x) {
        if (x instanceof LinkedList) {
           
            addLast(x);
            return;
        }

        if (x instanceof Passanger) {
            Passanger p = (Passanger) x;
            if (listType.equals("passengers")) {
                insertSortedByPassengerPriority(p);
            } else if (listType.equals("combined")) {
                insertSortedByPersonID(p);
            } else {
               
                insertSortedByPassengerPriority(p);
            }
            return;
        }

        if (x instanceof Cabin_Crew) {
            Cabin_Crew c = (Cabin_Crew) x;
            if (listType.equals("crew")) {
                insertSortedByCrewCredit(c);
            } else if (listType.equals("combined")) {
                insertSortedByPersonID(c);
            } else {
            
                insertSortedByCrewCredit(c);
            }
            return;
        }

        if (x instanceof Person) {
          
            insertSortedByPersonID((Person) x);
            return;
        }

       
        addLast(x);
    }

  
    public void displayList() {
        if (listType.equals("lists")) {
            Node w = head;
            while (w != null) {
                if (w.data instanceof LinkedList) {
                    ((LinkedList) w.data).displayList();
                }
                w = w.next;
            }
            return;
        }

        Node cur = head;
        while (cur != null) {
            if (cur.data instanceof Person) {
                System.out.println(((Person) cur.data).display());
            }
            cur = cur.next;
        }
    }


    public void removeById(long id) {
        while (head != null && (head.data instanceof Person) && ((Person) head.data).ID == id) {
            head = head.next;
        }
        if (head == null) return;

        Node cur = head;
        while (cur.next != null) {
            if (cur.next.data instanceof Person && ((Person) cur.next.data).ID == id) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
    }

    public List<Person> toPersonList() {
        List<Person> out = new ArrayList<>();
        Node cur = head;
        while (cur != null) {
            if (cur.data instanceof Person) out.add((Person) cur.data);
            cur = cur.next;
        }
        return out;
    }

    private void addLast(Object x) {
        Node nn = new Node(x);
        if (head == null) { head = nn; return; }
        Node cur = head;
        while (cur.next != null) cur = cur.next;
        cur.next = nn;
    }

    private void insertSortedByPassengerPriority(Passanger p) {
        Node nn = new Node(p);
        if (head == null || getPassengerPriority(head.data) > p.getPriority()) {
            nn.next = head;
            head = nn;
            return;
        }
        Node cur = head;
        while (cur.next != null && getPassengerPriority(cur.next.data) <= p.getPriority()) {
            cur = cur.next;
        }
        nn.next = cur.next;
        cur.next = nn;
    }

    private int getPassengerPriority(Object o) {
        if (o instanceof Passanger) return ((Passanger) o).getPriority();
        return Integer.MAX_VALUE;
    }

    private void insertSortedByCrewCredit(Cabin_Crew c) {
        Node nn = new Node(c);
        if (head == null || getCrewCredit(head.data) > c.getCredit()) {
            nn.next = head;
            head = nn;
            return;
        }
        Node cur = head;
        while (cur.next != null && getCrewCredit(cur.next.data) <= c.getCredit()) {
            cur = cur.next;
        }
        nn.next = cur.next;
        cur.next = nn;
    }

    private double getCrewCredit(Object o) {
        if (o instanceof Cabin_Crew) return ((Cabin_Crew) o).getCredit();
        return Double.POSITIVE_INFINITY;
    }

    private void insertSortedByPersonID(Person p) {
        Node nn = new Node(p);
        if (head == null || getPersonID(head.data) > p.ID) {
            nn.next = head;
            head = nn;
            return;
        }
        Node cur = head;
        while (cur.next != null && getPersonID(cur.next.data) <= p.ID) {
            cur = cur.next;
        }
        nn.next = cur.next;
        cur.next = nn;
    }

    private long getPersonID(Object o) {
        if (o instanceof Person) return ((Person) o).ID;
        return Long.MAX_VALUE;
    }
}

