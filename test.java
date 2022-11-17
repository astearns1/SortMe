package sortme;

import java.util.*;
import java.io.*;
import java.nio.file.*;

public class test {
    static void testing(){
                        
        File file1 = new File("Sorted.txt");
        File file2 = new File("StraightSortOutput.txt");
        
        if(CompareFiles(file1.toPath(), file2.toPath())){
            System.out.println("Test 1: Success");
        }else{
            System.out.println("Test 1: Fail");
        }       
        
        file1 = new File("SortedR.txt");
        file2 = new File("ReverseSortOutput.txt");
        
        if(CompareFiles(file1.toPath(), file2.toPath())){
            System.out.println("Test 2: Success");
        }else{
            System.out.println("Test 2: Fail");
        }    
    }
    
    private static boolean CompareFiles(Path file1, Path file2){
        try{
            if(Files.size(file1) != Files.size(file2)){
                return false;
            }
            
            byte[] first = Files.readAllBytes(file1);
            byte[] second = Files.readAllBytes(file2);
            return Arrays.equals(first, second);
        }catch(IOException e){
            e.printStackTrace();
        }
        return false;
    }
}
