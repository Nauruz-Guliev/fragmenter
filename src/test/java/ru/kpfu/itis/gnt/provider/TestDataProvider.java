package ru.kpfu.itis.gnt.provider;

import com.google.gson.Gson;
import ru.kpfu.itis.gnt.model.TestDataObject;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class TestDataProvider {

    public TestDataObject provideTestDataObject(String fileName) throws IOException {
        File file = new File(fileName);
        StringBuilder json = new StringBuilder();
        try (FileReader fr = new FileReader(file)) {
            int character;
            while ((character = fr.read()) != -1) {
                json.append((char) character);
            }
        } catch (IOException e) {
            throw e;
        }
        return new Gson().fromJson(json.toString(), TestDataObject.class);
    }
}
