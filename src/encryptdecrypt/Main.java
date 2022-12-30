package encryptdecrypt;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String operation = "enc";
        String word = "";
        int key = 0;
        String fileForWrite = "";
        String algorithm = "shift";
        for (int i = 0; i < args.length; i++) {
            switch (args[i]) {
                case "-alg" -> algorithm = args[i + 1];
                case "-mode" -> operation = args[i + 1];
                case "-key" -> key = Integer.parseInt(args[i + 1]);
                case "-data" -> word = args[i + 1];
                case "-in" -> {
                    File file = new File(args[i + 1]);
                    try (Scanner scanner = new Scanner(file)) {
                        word = scanner.nextLine();
                    } catch (FileNotFoundException e) {
                        System.out.printf("Error %s\n", e.getMessage());
                    }
                }
                case "-out" -> fileForWrite = args[i + 1];
            }
        }
        new ShiftAlgorithm(word, key);
        AbstractClass abstractClass = switch (algorithm) {
            case "shift" -> new ShiftAlgorithm(word, key);
            case "unicode" -> new UnicodeAlgorithm(word, key);
            default -> new ShiftAlgorithm(word, key);
        };
        if (fileForWrite.isEmpty()) {
            if (Objects.equals(operation, "enc")) {
                System.out.println(abstractClass.encryption());
            } else if (Objects.equals(operation, "dec")) {
                System.out.println(abstractClass.decryption());
            }
        } else {
            try (FileWriter writer = new FileWriter(fileForWrite)) {
                if (Objects.equals(operation, "enc")) {
                    writer.write(abstractClass.encryption());
                } else if (Objects.equals(operation, "dec")) {
                    writer.write(abstractClass.decryption());
                }
            } catch (IOException e) {
                System.out.printf("Error %s", e.getMessage());
            }
        }
    }

}
