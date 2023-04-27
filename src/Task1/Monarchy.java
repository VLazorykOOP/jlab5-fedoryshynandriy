package Task1;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Monarchy extends Kingdom {
    private String family;

    public Monarchy(String name, String capital, int population, String king, String family) {
        super(name, capital, population, king);
        this.family = family;
    }

    public String getFamily(){
        return family;
    }
    public void setFamily (String family){
        this.family=family;
    }

    public static Monarchy getMonarchyFromInput(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nEnter the name of the Monarchy : ");
        String name = scanner.nextLine();

        System.out.print("Enter the capital of the Monarchy: ");
        String capital = scanner.nextLine();

        System.out.print("Enter the population of the Monarchy: ");
        int population = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter the name of the king: ");
        String king = scanner.nextLine();

        System.out.print("Enter the name of the family: ");
        String family = scanner.nextLine();

        return new Monarchy(name, capital, population, king, family);
    }

//    public static List<Monarchy> readMonarchyFromFile(String filePath) {
//        List<Monarchy> monarchies = new ArrayList<>();
//        try {
//            BufferedReader reader = new BufferedReader(new FileReader(filePath));
//            String line;
//            while ((line = reader.readLine()) != null) {
//                String[] fields = line.split(" ");
//                String name = fields[0];
//                String capital = fields[1];
//                int population = Integer.parseInt(fields[2]);
//                String king = fields[3];
//                String family = fields[4];
//                Monarchy monarchy = new Monarchy(name, capital, population, king, family);
//                monarchies.add(monarchy);
//            }
//            reader.close();
//        } catch (IOException e) {
//            System.out.println("Error reading file: " + e.getMessage());
//        }
//        return monarchies;
//    }

//    public static void writeMonarchyToFile(String filePath, Monarchy monarchy) {
//        try {
//            BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true));
//            writer.write(monarchy.getName() + " " + monarchy.getCapital() + " " + monarchy.getPopulation() + " " + monarchy.getKing()+ " " + monarchy.getFamily());
//            writer.newLine();
//            writer.close();
//        } catch (IOException e) {
//            System.out.println("Error writing to file: " + e.getMessage());
//        }
//    }

    @Override
    public void Show() {
        System.out.println("Type: Monarchy");
        System.out.println("State: " + getName());
        System.out.println("Capital: " + getCapital());
        System.out.println("Population: " + getPopulation());
        System.out.println("King: " + getKing());
        System.out.println("Family: " + getFamily());
    }

}
