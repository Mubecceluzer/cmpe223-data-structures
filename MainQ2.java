// Title: CMPE223 - HW1 - Question 2
// Author: Mübeccel Eylül Uzer
// ID: 10214914888   
// Section: 02       
// Assignment: 1 (Question 2)
// Description:Reads a file, pushes all chars to a queue and a stack,
//              then prints alphanumeric-only cleaned string (from queue order)
//              and its reverse (from stack order), matching sample output
package cmpe223H;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;
import java.util.Scanner;

public class MainQ2 {
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

       
        System.out.print("Enter the file name: ");

        String fileName = in.nextLine().trim();

        
        StringBuilder sb = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            int ch;
            while ((ch = br.read()) != -1) {
                sb.append((char) ch);
            }
        } catch (IOException e) {
            return;
        }

        String content = sb.toString();

        
        Queue<Character> q = new ArrayDeque<>();
        Deque<Character> st = new ArrayDeque<>(); 

        for (int i = 0; i < content.length(); i++) {
            char c = content.charAt(i);
            q.add(c);
            st.push(c);
        }

        
        StringBuilder cleaned = new StringBuilder();
        while (!q.isEmpty()) {
            char c = q.remove();
            if (Character.isLetterOrDigit(c)) {
                cleaned.append(c);
            }
        }

        StringBuilder reversed = new StringBuilder();
        while (!st.isEmpty()) {
            char c = st.pop();
            if (Character.isLetterOrDigit(c)) {
                reversed.append(c);
            }
        }

        
        System.out.println("Cleaned string: " + cleaned.toString());
        System.out.println("Cleaned string in reverse:" + reversed.toString());

        in.close();
    }
}

