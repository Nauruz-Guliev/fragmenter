package ru.kpfu.itis.gnt.mapper;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import ru.kpfu.itis.gnt.provider.TestDataProvider;
import java.util.stream.Stream;

public class BaseTestDataObjectMapper implements ArgumentsProvider {

    private final String fileName;
    private final TestDataProvider testDataProvider;

    public BaseTestDataObjectMapper(String fileName, TestDataProvider testDataProvider) {
        this.fileName = fileName;
        this.testDataProvider = testDataProvider;
    }

    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) throws Exception {
        return Stream.of(Arguments.of(testDataProvider.provideTestDataObject(fileName)));
    }
}
