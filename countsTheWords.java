import java.io.*;
import java.util.Scanner;

public class countsTheWords {
    // function to count words
    public static int countWords(String text) {

        String[] words = text.split("\\s+");

        return words.length;
    }

    // This is the main method.

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to Word Counter :-");
        System.out.println(" Enter 'T' to enter text.");
        System.out.println(" Enter 'F' to provide a file.");

        System.out.print("Enter your choice: ");
        String T_or_False_Inputed = sc.nextLine();// here, we are taking input from the user as a String.

        if (T_or_False_Inputed.equalsIgnoreCase("T")) {
            // Read text input from the user
            System.out.print("Enter the text: ");
            String text = sc.nextLine();

            int Total_word = countWords(text);// here i am calling method countwords and passing Arguments as text.
            System.out.println("Total words: " + Total_word);
        } else if (T_or_False_Inputed.equalsIgnoreCase("F")) {
            // Read file input from the user
            System.out.print("Enter the path of your file: ");
            String filePath = sc.nextLine();

            try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
                StringBuilder sb = new StringBuilder();
                String line;

                // Read the file line by line
                while ((line = reader.readLine()) != null) {
                    sb.append(line);
                    sb.append(" ");
                }

                // Count the words in the file
                int wordCount = countWords(sb.toString());
                System.out.println("Total words: " + wordCount);
            }

            catch (IOException e) {
                System.out.println("Error reading the file: " + e.getMessage());
            }
        } else {
            System.out.println("Invalid choice. Please try again.");
        }
        sc.close();

    }
}
