package ru.kpfu.itis.gnt.mapper;

import com.google.gson.Gson;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import ru.kpfu.itis.gnt.model.TestDataObject;

import java.io.*;
import java.util.stream.Stream;

public class TestDataObjectMapper  implements ArgumentsProvider {

    private static final String FILE_NAME = "test_data_object.json";

    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) {
        File file = new File(FILE_NAME);
        StringBuilder json = new StringBuilder();
        try (FileReader fr = new FileReader(file)) {
            int character;
            while ((character = fr.read()) != -1) {
                json.append((char) character);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Stream.of(Arguments.of(new Gson().fromJson(json.toString(), TestDataObject.class)));
    }
}
