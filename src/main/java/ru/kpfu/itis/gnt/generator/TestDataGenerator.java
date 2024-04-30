package ru.kpfu.itis.gnt.generator;

import com.google.gson.Gson;
import ru.kpfu.itis.gnt.model.TestDataObject;
import java.io.*;
import java.util.Random;
import java.util.Scanner;

public class TestDataGenerator {

    private String email = "";
    private String password = "";
    private String nickname = "";
    private String generatedString = "";
    private int textLength;
    private static final String FILE_NAME = "test_data_object.json";
    private Scanner scanner;

    public static void main(String[] args) {
        new TestDataGenerator();
    }

    public TestDataGenerator() {
        scanner = new Scanner(System.in);
        runProgram();
    }

    public void runProgram() {
        readConsoleInput();
        writeObjectToFile(createTestDataObject());
        readFromFile();
    }

    public void readConsoleInput() {
        email = readUserInput("Введите email: ");
        password = readUserInput("Введите пароль: ");
        nickname = readUserInput("Введите текущий никнейм: ");
        try {
            textLength = Integer.parseInt(readUserInput("Введите длину строки: "));
        } catch (NumberFormatException exception) {
            System.out.println("\u001B"+ "Введите корректное число" + "\u001B[0m");
        }
        generatedString = generateRandomString(textLength);
    }

    public String readUserInput(String message) {
        String userInput = null;
        boolean isRunning = true;
        while (isRunning) {
            System.out.println(message);
            userInput = scanner.nextLine();
            if(userInput.isBlank() || userInput.matches("^\\s*$")) {
                System.out.println("\u001B"+ "Поле не может быть пустым или содержать только пробелы" + "\u001B[0m");
            } else {
                isRunning = false;
            }
        }
        return userInput;
    }

    public String generateRandomString(int length) {
        int leftLimit = 48;
        int rightLimit = 122;
        Random random = new Random();

        return random.ints(leftLimit, rightLimit + 1)
                .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                .limit(length)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }

    public TestDataObject createTestDataObject() {
        return TestDataObject.builder()
                .accountCode(nickname)
                .text(generatedString)
                .email(email)
                .password(password)
                .build();
    }

    public void writeObjectToFile(TestDataObject object) {
        Gson gson = new Gson();
        String json = gson.toJson(object);

        try {
            File file = new File(FILE_NAME);
            if (!file.exists()) {
                file.createNewFile();
            }

            FileWriter writer = new FileWriter(file);
            writer.write(json);
            writer.close();
        } catch (Exception e) {
            System.out.println("Произошла ошибка при записи в файл.");
            e.printStackTrace();
        }
    }

    public void readFromFile() {
        File file = new File(FILE_NAME);
        try (FileReader fr = new FileReader(file)) {
            int character;
            while ((character = fr.read()) != -1) {
                System.out.print((char) character);
            }
        } catch (IOException e) {
            System.out.println("Произошла ошибка при чтении файла.");
            e.printStackTrace();
        }
    }
}
