// Title: CMPE223 - HW1 - Question 1
// Author: Mübeccel Eylül Uzer
// ID: 10214914888   
// Section: 02       
// Assignment: 1 (Question 1)
// Description:Program entry. Builds 4 people lists + list_of_lists, provides menu
//              to add/display/delete/combine according to the spec.
package cmpe223H;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner; 

public class Main {
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        LinkedList economy        = new LinkedList("passengers");
        LinkedList economyPremium = new LinkedList("passengers");
        LinkedList business       = new LinkedList("passengers");
        LinkedList crew           = new LinkedList("crew");

        LinkedList listOfLists = new LinkedList("lists");
        listOfLists.insert(economy);
        listOfLists.insert(economyPremium);
        listOfLists.insert(business);
        listOfLists.insert(crew);

  while (true) {
      System.out.println("Enter the operation:");
      System.out.println("1: Add a person");
      System.out.println("2: Print all the lists");
      System.out.println("3: Delete all the people with the given ID");
      System.out.println("4: Combine all the lists by ID, print and then exit");

            String line = in.nextLine().trim();
            if (line.isEmpty()) continue;

            int op;
            try { op = Integer.parseInt(line); }
            catch (NumberFormatException e) { continue; }

            if (op == 1) {
              
                System.out.print("Enter the name: ");
                String name = in.nextLine().trim();

                System.out.print("Enter the ID: ");
                long id = Long.parseLong(in.nextLine().trim());

                System.out.print("Enter the type (passanger or cabin-crew): ");
                String type = in.nextLine().trim().toLowerCase();

                if (type.equals("passanger")) {
                    System.out.print("Enter the ticket type (economy, economy-premium, business): ");
                    String ticket = in.nextLine().trim().toLowerCase();

                    System.out.print("Enter the priority: ");
                    int priority = Integer.parseInt(in.nextLine().trim());

                    Passanger p = new Passanger(name, id, ticket, priority);
                    switch (ticket) {
                        case "economy":
                            economy.insert(p);
                            break;
                        case "economy-premium":
                            economyPremium.insert(p);
                            break;
                        case "business":
                            business.insert(p);
                            break;
                        default:
                            
                            economy.insert(p);
                            break;
                    }

                } else if (type.equals("cabin-crew")) {
                    System.out.print("Enter the job: ");
                    String job = in.nextLine().trim();

                    System.out.print("Enter the credit: ");
                    double credit = Double.parseDouble(in.nextLine().trim());

                    Cabin_Crew c = new Cabin_Crew(name, id, job, credit);
                    crew.insert(c);

                } else {
                    System.out.println("Unknown type. Use 'passanger' or 'cabin-crew'.");
                }

            } else if (op == 2) {
               
                listOfLists.displayList();

            } else if (op == 3) {
                
  System.out.print("Enter the ID to delete: ");
  long delId = Long.parseLong(in.nextLine().trim());
  economy.removeById(delId);
  economyPremium.removeById(delId);
  business.removeById(delId);
  crew.removeById(delId);

            } else if (op == 4) {
                
                List<Person> all = new ArrayList<>();
  all.addAll(economy.toPersonList());
  all.addAll(economyPremium.toPersonList());
  all.addAll(business.toPersonList());
  all.addAll(crew.toPersonList());
  all.sort(Comparator.comparingLong(p -> p.ID));

  LinkedList combined = new LinkedList("combined");
  for (Person p : all) combined.insert(p);

  combined.displayList();
   break; 
    }
    }

   in.close();
    }
}

