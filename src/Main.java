import java.io.*;
import java.util.*;
import Task1.*;
import Task2.UniqueWordsFinder;

public class Main {

    public static void main(String[] args) {
        System.out.println(" Java lab 5 ");
        //ThreadStarter.main(args);
        Scanner scanner = new Scanner(System.in);
        int task = 3;
        while (task > 2 || task < 1) {
            System.out.println("Select what task to execute:");
            task = scanner.nextInt();
        }
        System.out.println("TASK:" + task);
        switch (task) {
            case 1: {
                /*
                Розробити програму керування записами, створеними на основі похідних класів з попередньої лабораторної роботи №3.
                Програма повинна прочитати вхідні дані (список записів) з файлів (для кожного класу свій файл) і
                занести їх у колекції відповідного типу (ArrayList). Вивести прочитані дані.
                Відсортувати їх за допомогою Collections.sort(), для цього додати у класи реалізацію інтерфейсу Comparable
                (порівняння записів придумати самостійно). Вивести дані на екран.
                Додати по одному запису у кожну колекцію введеному з клавіатури.
                Знову відсортувати і вивести на екран.
                Описати ArrayList на основі абстрактного класу і занести у нього усі записи з файлів (або з попередньо створених колекцій).
                Відсортувати отриманий ArrayList за допомогою Collections.sort(), у який передати об’єкт класу,
                похідний від Comparator (розробити самостійно), який буде вміти порівнювати об’єкти абстрактного класу.
                Відсортований ArrayList записати у файл.
                 */
                List<State> states = new ArrayList<>();
                /*
                republic
                  */
                List<Republic> republics = new ArrayList<>();
                String republicsPath = "C:\\java\\jlab5-fedoryshynandriy\\src\\Task1\\republics.txt";

                while (true) {
                    System.out.print("Enter the path to the republics list file : ");
                    //republicsPath = scanner.nextLine();
                    File republcsFile = new File(republicsPath);
                    if (!republcsFile.exists()) {
                        System.out.println("File not found.");
                    } else {
                        republics = State.readFromFile(republicsPath, Republic.class);
                        if (!republics.isEmpty()) {
                            break;
                        }
                    }
                }

                System.out.println("\nInformation from file: " + republicsPath);
                System.out.println();
                for (Republic republic : republics) {
                    republic.show();
                    System.out.println();
                }

                System.out.println("\nSorted by population:\n");
                Collections.sort(republics);
                for (Republic republic : republics) {
                    republic.show();
                    System.out.println();
                }

                System.out.print("Do you want to add a new republic? (y/n) ");
                String append = scanner.nextLine();

                if (append.equalsIgnoreCase("y")) {
                    Republic newRepublic = Republic.getRepublicFromInput();
                    republics.add(newRepublic);
                    State.writeToFile(republicsPath, newRepublic);
                }

                System.out.println("\nSorted by population after adding:\n");
                Collections.sort(republics);
                for (Republic republic : republics) {
                    republic.show();
                    System.out.println();
                    states.add(republic);
                }
                /*
                kingdom
                */
                List<Kingdom> kingdoms = new ArrayList<>();
                String kingdomsPath = "C:\\java\\jlab5-fedoryshynandriy\\src\\Task1\\kingdoms.txt";

                while (true) {
                    System.out.print("Enter the path to the kingdoms list file: ");
                    //kingdomsPath = scanner.nextLine();
                    File kingdomsFile = new File(kingdomsPath);
                    if (!kingdomsFile.exists()) {
                        System.out.println("File not found.");
                    } else {
                        kingdoms = State.readFromFile(kingdomsPath, Kingdom.class);
                        if (!kingdoms.isEmpty()) {
                            break;
                        }
                    }
                }

                System.out.println("\nInformation from file: " + kingdomsPath);
                Collections.sort(kingdoms);
                for (Kingdom kingdom : kingdoms) {
                    kingdom.Show();
                    System.out.println();
                }

                System.out.println("\nSorted by population:\n");
                Collections.sort(kingdoms);
                for (Kingdom kingdom : kingdoms) {
                    kingdom.Show();
                    System.out.println();
                }

                System.out.print("Do you want to add a new republic? (y/n) ");
                append = scanner.nextLine();

                if (append.equalsIgnoreCase("y")) {
                    Kingdom newKingdom = Kingdom.getKingdomFromInput();
                    kingdoms.add(newKingdom);
                    State.writeToFile(kingdomsPath, newKingdom);
                }

                System.out.println("\nSorted by population after adding:\n");
                Collections.sort(kingdoms);
                for (Kingdom kingdom : kingdoms) {
                    kingdom.Show();
                    System.out.println();
                    states.add(kingdom);
                }
                /*
                monarchy
                */
                List<Monarchy> monarchies = new ArrayList<>();
                String monarchiesPath = "C:\\java\\jlab5-fedoryshynandriy\\src\\Task1\\monarchies.txt";

                while (true) {
                    System.out.print("Enter the path to the monarchies list file: ");
                    //monarchiesPath = scanner.nextLine();
                    File monarchiesFile = new File(monarchiesPath);
                    if (!monarchiesFile.exists()) {
                        System.out.println("File not found.");
                    } else {
                        monarchies = State.readFromFile(monarchiesPath, Monarchy.class);
                        if (!monarchies.isEmpty()) {
                            break;
                        }
                    }
                }

                System.out.println("\nInformation from file: " + monarchiesPath);
                for (Monarchy monarchy : monarchies) {
                    monarchy.Show();
                    System.out.println();
                }

                System.out.println("\nSorted by population:\n");
                Collections.sort(monarchies);
                for (Monarchy monarchy : monarchies) {
                    monarchy.Show();
                    System.out.println();
                }

                System.out.print("Do you want to add a new republic? (y/n) ");
                append = scanner.nextLine();

                if (append.equalsIgnoreCase("y")) {
                    Monarchy newMonarchy = Monarchy.getMonarchyFromInput();
                    monarchies.add(newMonarchy);
                    State.writeToFile(monarchiesPath, newMonarchy);
                }

                System.out.println("\nSorted by population after adding:\n");
                for (Monarchy monarchy : monarchies) {
                    monarchy.Show();
                    System.out.println();
                    states.add(monarchy);
                }
                /*
                show all
                */
                System.out.println("\nSorted all:");
                Collections.sort(states);
                for (State state : states) {
                    state.Show();
                    State.writeToFile("C:\\java\\jlab5-fedoryshynandriy\\src\\Task1\\all.txt", state);
                    System.out.println();
                }
                break;
            }
            case 2: {
                /*
                Заданий файл з текстом англійською мовою.
                Виділити всі різні слова.
                Слова, які відрізняються тільки регістром літер, вважати однаковими.
                Використовувати клас HashSet.
                 */
                scanner.nextLine();
                String uniqueWordsText = "";
                File uniqueWordsFile = null;
                while (uniqueWordsFile == null || !uniqueWordsFile.exists()) {
                    System.out.print("Enter the path to file with unique words: ");
                    uniqueWordsText = scanner.nextLine();
                    uniqueWordsFile = new File(uniqueWordsText);
                    if (!uniqueWordsFile.exists()) {
                        System.out.println("Error: File does not exist. Please try again.");
                    }
                }

                HashSet<String> uniqueWords = UniqueWordsFinder.findUniqueWords(uniqueWordsText);
                System.out.println("UNIQUE:");
                System.out.println(uniqueWords);

            }
        }
    }
}

//  class ThreadStarter {
//    public static void main(String[] args) {
//        NamedRunnable nr = new NamedRunnable();
//        Thread one = new Thread(nr);
//        Thread two = new Thread(nr);
//        Thread three = new Thread(nr);
//
//        one.setName("Перший");
//        two.setName("Другий");
//        three.setName("Третій");
//
//        one.start();
//        two.start();
//        three.start();
//    }
//}
//
//class NamedRunnable implements Runnable {
//    public void run() {
//        System.out.println("Завантажений " + Thread.currentThread().getName());
//        System.out.println("Закінченний  "+ Thread.currentThread().getName());
//    }
//}




