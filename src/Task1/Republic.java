package Task1;
import java.io.*;
import java.util.*;

public class Republic extends State  {
    private String president;

    public Republic(String name, String capital, int population, String president) {
        super(name, capital, population);
        this.president = president;
    }

    public String getPresident() {
        return president;
    }

    public void setPresident(String president) {
        this.president = president;
    }

    public static Republic getRepublicFromInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nEnter the name of the Republic: ");
        String name = scanner.nextLine();

        System.out.print("Enter the capital of the Republic: ");
        String capital = scanner.nextLine();

        System.out.print("Enter the population of the Republic: ");
        int population = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter the name of the President: ");
        String president = scanner.nextLine();

        return new Republic(name, capital, population, president);
    }

//    public static List<Republic> readRepublicsFromFile(String fileName) {
//        List<Republic> republics = new ArrayList<>();
//        File file = new File(fileName);
//        if (!file.exists()) {
//            System.out.println("File not found.");
//            return republics;
//        }
//        try {
//            BufferedReader reader = new BufferedReader(new FileReader(file));
//            String line = reader.readLine();
//            while (line != null) {
//                String[] parts = line.split(" ");
//                String name = parts[0];
//                String capital = parts[1];
//                int population = Integer.parseInt(parts[2]);
//                String president = parts[3];
//                Republic republic = new Republic(name, capital, population, president);
//                republics.add(republic);
//                line = reader.readLine();
//            }
//            reader.close();
//        } catch (IOException e) {
//            System.out.println("Error reading file: " + e.getMessage());
//        }
//        return republics;
//    }

//    public static void writeRepublicToFile(String filePath, Republic republic) {
//        try {
//            BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true));
//            writer.write(republic.getName() + " " + republic.getCapital() + " " + republic.getPopulation() + " " + republic.getPresident());
//            writer.newLine();
//            writer.close();
//        } catch (IOException e) {
//            System.out.println("Error writing to file: " + e.getMessage());
//        }
//    }


    public void show() {
        System.out.println("Type: Republic");
        super.Show();
        System.out.println("President: " + getPresident());
    }
}
