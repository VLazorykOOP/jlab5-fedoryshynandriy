package Checkers;

import java.util.Scanner;

public class onlyNumbers {
    static Scanner input=new Scanner(System.in);
    public static int getInt(){
        while (!input.hasNextInt()){
            System.out.println("Enter an integer");
            input.next();
        }
        int a = input.nextInt();
        return a;
    }

    public static double getDouble(){
        while (!input.hasNextDouble()){
            System.out.println("Enter a double");
            input.next();
        }
        double a = input.nextDouble();
        return a;
    }
}
