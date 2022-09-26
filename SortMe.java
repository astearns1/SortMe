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
    public static void main(String[] args) {
        List<String> namesList = new ArrayList<>();//List to hold the names read in from the file
        
        //Try catch to read names in from file and catch execption if file not found
        try{
            File names = new File("Sort Me.txt");
            Scanner read = new Scanner(names);
            //While loop to read in the names
            while(read.hasNextLine()){
                String name = read.nextLine();
                //System.out.println(name); //Done for testing to make sure names read in correctly
                namesList.add(name);
            }
        }catch(FileNotFoundException e){
            System.out.println("An error occurred.");
        }
        
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
            }
        });
        
        //Ouput the names
        for(String name:namesList){
            System.out.println(name);
        }
    }//Close of main method
}//Close of SortMe Class

