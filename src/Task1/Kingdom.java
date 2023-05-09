package Task1;

import java.util.*;
import java.io.*;
public class Kingdom extends State {
    private String king;

    public Kingdom(String name, String capital, int population, String king) {
        super(name, capital, population);
        this. king= king;
    }

    public String getKing(){
        return king;
    }

    public void setKing(String king){
        this.king=king;
    }

    public static Kingdom getKingdomFromInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nEnter the name of the Kingdom: ");
        String name = scanner.nextLine();

        System.out.print("Enter the capital of the Kingdom: ");
        String capital = scanner.nextLine();

        System.out.print("Enter the population of the Kingdom: ");
        int population = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter the name of the King: ");
        String king = scanner.nextLine();
        return new Kingdom(name, capital, population, king);
    }

    @Override
    public void Show() {
        System.out.println("Type: Kingdom");
        super.Show();
        System.out.println("King: " + getKing());
    }
}



