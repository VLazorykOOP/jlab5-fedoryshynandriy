package Checkers;

import static Checkers.onlyNumbers.getInt;
public class positive {
    public static int getPositiveInteger(){
        int positve = -3;
        while(positve<0){
            System.out.println("Enter a positive integer");
            positve= getInt();
        }
        return positve;
    }
}
