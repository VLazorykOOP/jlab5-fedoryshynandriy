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

//    public static List<Kingdom> readKingdomsFromFile(String filePath) {
//        List<Kingdom> kingdoms = new ArrayList<>();
//        try {
//            BufferedReader reader = new BufferedReader(new FileReader(filePath));
//            String line;
//            while ((line = reader.readLine()) != null) {
//                String[] fields = line.split(" ");
//                String name = fields[0];
//                String capital = fields[1];
//                int population = Integer.parseInt(fields[2]);
//                String king = fields[3];
//                Kingdom kingdom = new Kingdom(name, capital, population, king);
//                kingdoms.add(kingdom);
//            }
//            reader.close();
//        } catch (IOException e) {
//            System.out.println("Error reading file: " + e.getMessage());
//        }
//        return kingdoms;
//    }

//    public static void writeKingdomToFile(String filePath, Kingdom kingdom) {
//        try {
//            BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true));
//            writer.write(kingdom.getName() + " " + kingdom.getCapital() + " " + kingdom.getPopulation() + " " + kingdom.getKing());
//            writer.newLine();
//            writer.close();
//        } catch (IOException e) {
//            System.out.println("Error writing to file: " + e.getMessage());
//        }
//    }

    @Override
    public void Show() {
        System.out.println("Type: Kingdom");
        super.Show();
        System.out.println("King: " + getKing());
    }
}



