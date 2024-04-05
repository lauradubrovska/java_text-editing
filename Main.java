import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Enter command and file name (print filename, format filename, exit):");
            String userInput = scanner.nextLine();

            if (userInput.equals("exit")) {
                System.out.println("Exiting");
                break;
            } else if (userInput.startsWith("print ") || userInput.startsWith("format ")) {
                String[] parts = userInput.split(" ");
                String command = parts[0];
                String fileName = parts[1];

                try {
                    if (command.equals("print")) {
                        printContent(fileName);
                    } else if (command.equals("format")) {
                        formatContent(fileName);
                    } else {
                        System.out.println("Invalid command.");
                    }
                } catch (Exception ex) {
                    System.out.println("Error: " + ex.getMessage());
                }
            } else {
                System.out.println("Invalid command.");
            }
        }

        scanner.close();
    }

    private static void printContent(String fileName) throws Exception {
        Scanner fileScanner = new Scanner(new FileReader(fileName));
        while (fileScanner.hasNextLine()) {
            System.out.println(fileScanner.nextLine());
        }
        fileScanner.close();
    }

    private static void formatContent(String fileName) throws Exception {
        Scanner fileScanner = new Scanner(new FileReader(fileName));
        PrintWriter out = new PrintWriter(new FileWriter("temp.txt"));
    
        int lineCount = 0;
        int maxLineLength = 0;
        int nonEmptyLineCount = 0;
    
        while (fileScanner.hasNextLine()) {
            String line = fileScanner.nextLine().trim();
            if (!line.isEmpty()) {
                String formattedLine = centerText(capitalizeFirstLetter(line));
                out.println(formattedLine);
                lineCount++;
                nonEmptyLineCount++;
    
                if (nonEmptyLineCount == 2) {
                    out.println();
                    nonEmptyLineCount = 0;
                }
    
                maxLineLength = Math.max(maxLineLength, formattedLine.length());
            }
        }
    
        fileScanner.close();
        out.close();
    
        File sourceFile = new File(fileName);
        File tempFile = new File("temp.txt");
    
        sourceFile.delete();
        tempFile.renameTo(sourceFile);
    
        System.out.println("File formatted successfully.");
    }    

    private static String centerText(String input) {
        int totalWidth = 80; 
        int padding = (totalWidth - input.length()) / 2;
        return " ".repeat(padding) + input + " ".repeat(padding + input.length() % 2);
    }

    private static String capitalizeFirstLetter(String input) {
        if (input.isEmpty()) {
            return input;
        }
        return Character.toUpperCase(input.charAt(0)) + input.substring(1).toLowerCase();
    }
}
