package sortme;
/*
Author: A.J. Stearns
Date: 09/12/2022
Program: Sorting App
Explanation: Sort a list of names by length first then alphabetically
*/
import java.util.*;
import java.io.*;

public class SortMe {
    public static void main(String[] args) throws FileNotFoundException {
        List<String> namesList = new ArrayList<>(); // List to hold the names read in from the file
        
        // No longer needed for menu choice
        // Scanner in = new Scanner(System.in);
        // int sortOrder = 0; // Variable to hold sort order choice
        
        //Try catch to read names in from file and catch execption if file not found
        File names = new File("Sort Me.txt");
        Scanner read = new Scanner(names);
        //While loop to read in the names
        while(read.hasNextLine()){
            String name = read.nextLine();
            //System.out.println(name); //Done for testing to make sure names read in correctly
            namesList.add(name);
        }
        
        
        // Commented out because the menu option was no longer needed
        
//        // Collects input from user for sort order & validates that it is an accpetable menu choice
//        do{
//            // Validate that input is of integer form so program can work correctly
//            try{
//                System.out.println("Output Order");
//                System.out.println("1. Shortest First & A-Z");
//                System.out.println("2. Longest First & Z-A");
//                System.out.println("Enter your choice: ");
//                sortOrder = in.nextInt();
//                in.nextLine();
//                if(sortOrder != 1 && sortOrder != 2)
//                System.out.println("Please ener a valid sort order option.");
//            }catch(InputMismatchException e){ // Catches error but allows program to continue running
//                System.out.println("Integer input only. Please try again.");
//                in.nextLine();
//            }
//            
//            System.out.println(); // Output spacing, purely for output appearance
//        }while(sortOrder != 1 && sortOrder != 2);
                
        //Code to sort the list first by length then alphabetically
        Collections.sort(namesList, new Comparator<String>(){
            //Overrides the original compare function so it compares the length first, then it compares lexigraphically
            @Override
            public int compare(String s1, String s2){
                if(s1.length() > s2.length()){ //If s1 is longer, want it after s2
                    return 1;
                }
                else if(s1.length() < s2.length()){//If s1 is shorter, want it before s2
                    return -1;
                }                
                else{
                    return s1.compareToIgnoreCase(s2);//If same length, compare alphabetically
                }
            }//End of compare function
        });//End of Collections.sort
        
        
        PrintStream o = new PrintStream(new File("StraightSortOutput.txt"));
        PrintStream console = System.out;
        System.setOut(o);
        
        // Ouput the names in straight sort to file
        for(String name:namesList){
            System.out.print(name);
            if(!name.equals(namesList.get(namesList.size()-1))){
                System.out.println();
            }
        }
        
        System.setOut(console);        
        
        // Reverses the order of the sorted list to be longest to shortest & Z-A
        Collections.reverse(namesList);
        
        o = new PrintStream(new File("ReverseSortOutput.txt"));
        System.setOut(o);
        
        //Ouput the names in reverse sort
        for(String name:namesList){
            System.out.print(name);
            if(!name.equals(namesList.get(namesList.size()-1))){
                System.out.println();
            }
        }
        
        System.setOut(console);
        test.testing();
    }//Close of main method
}//Close of SortMe Class

