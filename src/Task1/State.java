package Task1;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public abstract class State implements Comparable<State> {
        private String name;
        private String capital;
        private int population;

        public State(String name, String capital, int population) {
            this.name = name;
            this.capital = capital;
            this.population = population;
        }

        public String getName(){
            return name;
        }
        public void setName(String name){
            this.name=name;
        }

        public String getCapital (){
            return capital;
        }
        public void setCapital(String capital){
            this.capital=capital;
        }

        public int getPopulation (){
            return population;
        }
        public void setPopulation(int population){
            this.population=population;
        }

    public static <T> List<T> readFromFile(String fileName, Class<T> TypeOfState) {
        List<T> objects = new ArrayList<>();
        File file = new File(fileName);
        if (!file.exists()) {
            System.out.println("File not found.");
            return objects;
        }
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line = reader.readLine();
            while (line != null) {
                String[] parts = line.split(" ");
                String name = parts[0];
                String capital = parts[1];
                int population = Integer.parseInt(parts[2]);
                if (TypeOfState.equals(Republic.class)) {
                    String president = parts[3];
                    T object = TypeOfState.getConstructor(String.class, String.class, int.class, String.class)
                            .newInstance(name, capital, population, president);
                    objects.add(object);
                } else if (TypeOfState.equals(Kingdom.class)) {
                    String king = parts[3];
                    T object = TypeOfState.getConstructor(String.class, String.class, int.class, String.class)
                            .newInstance(name, capital, population, king);
                    objects.add(object);
                } else if (TypeOfState.equals(Monarchy.class)) {
                    String king = parts[3];
                    String family = parts[4];
                    T object = TypeOfState.getConstructor(String.class, String.class, int.class, String.class, String.class)
                            .newInstance(name, capital, population, king, family);
                    objects.add(object);
                }
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        } catch (ReflectiveOperationException e) {
            System.out.println("Error creating object: " + e.getMessage());
        }
        return objects;
    }


    public static void writeToFile(String fileName, Object object) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
            if (object instanceof Republic) {
                Republic republic = (Republic) object;
                writer.write(republic.getName() + " " + republic.getCapital() + " " + republic.getPopulation() + " " + republic.getPresident());
                writer.newLine();
            } else if (object instanceof Kingdom) {
                Kingdom kingdom = (Kingdom) object;
                writer.write(kingdom.getName() + " " + kingdom.getCapital() + " " + kingdom.getPopulation() + " " + kingdom.getKing());
                writer.newLine();
            } else if (object instanceof Monarchy) {
                Monarchy monarchy = (Monarchy) object;
                writer.write(monarchy.getName() + " " + monarchy.getCapital() + " " + monarchy.getPopulation() + " " + monarchy.getKing()+ " " + monarchy.getFamily());
                writer.newLine();
            } else {
                System.out.println("Invalid object type.");
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }

        public void Show() {
            System.out.println("State: " + getName());
            System.out.println("Capital: " + getCapital());
            System.out.println("Population: " + getPopulation());
        }
        public int compareTo(State other) {
            // Compare the Country objects based on their population
            if (this.population < other.population) {
                return -1;
            } else if (this.population > other.population) {
                return 1;
            } else {
                return 0;
            }
        }
    }

