package ru.kpfu.itis.gnt.generator;

import com.google.gson.Gson;
import ru.kpfu.itis.gnt.model.TestDataObject;
import java.io.*;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class TestDataGenerator {

    private String email = "";
    private String password = "";
    private String nickname = "";
    private String generatedString = "";
    private int textLength;
    private static final String VALID_FILE_NAME = "valid_test_data_object.json";
    private static final String INVALID_FILE_NAME = "invalid_test_data_object.json";
    private static boolean isValidFileGenerationMode = true;
    private final String BASE_URL = "https://fragmenter.net/ru";
    private final Scanner scanner;

    public static void main(String[] args) {
        new TestDataGenerator();
    }

    public TestDataGenerator() {
        scanner = new Scanner(System.in);
        runGenerator();
    }

    private void runGenerator() {
        readConsoleInput();
        if (isValidFileGenerationMode) {
            writeObjectToFile(createValidTestDataObject(), VALID_FILE_NAME);
            readFromFile(VALID_FILE_NAME);
        } else {
            writeObjectToFile(createInvalidTestDataObject(), INVALID_FILE_NAME);
            readFromFile(INVALID_FILE_NAME);
        }
    }

    private void readConsoleInput() {
        String userInput = readUserInput("Выберите режим генерации файла. Введите \"1\" для невалидного режима и любой другой символ для валидного режима: ");
        if(userInput.equals("1")) {
            isValidFileGenerationMode = false;
        } else {
            email = readUserInput("Введите email: ");
            password = readUserInput("Введите пароль: ");
            nickname = readUserInput("Введите текущий никнейм: ");
            try {
                textLength = Integer.parseInt(readUserInput("Введите длину строки: "));
            } catch (NumberFormatException exception) {
                System.out.println("\u001B" + "Введите корректное число" + "\u001B[0m");
            }
            generatedString = generateRandomString(textLength);
        }
    }

    private String readUserInput(String message) {
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

    private String generateRandomString(int length) {
        int leftLimit = 48;
        int rightLimit = 122;
        Random random = new Random();

        return random.ints(leftLimit, rightLimit + 1)
                .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                .limit(length)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }

    private TestDataObject createInvalidTestDataObject() {
        return TestDataObject.builder()
                .accountCode(generateRandomString(getRandomInt()))
                .text(generateRandomString(getRandomInt()))
                .email(generateRandomString(getRandomInt()))
                .password(generateRandomString(getRandomInt()))
                .baseUrl(BASE_URL)
                .build();
    }

    private int getRandomInt() {
        return ThreadLocalRandom.current().nextInt(0, 20);
    }

    private TestDataObject createValidTestDataObject() {
        return TestDataObject.builder()
                .accountCode(nickname)
                .text(generatedString)
                .email(email)
                .password(password)
                .baseUrl(BASE_URL)
                .build();
    }

    private void writeObjectToFile(TestDataObject object, String fileName) {
        Gson gson = new Gson();
        String json = gson.toJson(object);

        try {
            File file = new File(fileName);
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

    private void readFromFile(String fileName) {
        File file = new File(fileName);
        try (FileReader fr = new FileReader(file)) {
            int character;
            System.out.println("Сгенерирован json: \n");
            while ((character = fr.read()) != -1) {
                System.out.print((char) character);
            }
            System.out.print("\n\n\n");
        } catch (IOException e) {
            System.out.println("Произошла ошибка при чтении файла.");
            e.printStackTrace();
        }
    }
}
