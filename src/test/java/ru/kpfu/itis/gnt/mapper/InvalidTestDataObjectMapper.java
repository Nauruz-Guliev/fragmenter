package ru.kpfu.itis.gnt.mapper;

import ru.kpfu.itis.gnt.provider.TestDataProvider;

public class InvalidTestDataObjectMapper extends BaseTestDataObjectMapper {

    public InvalidTestDataObjectMapper() {
        super("invalid_test_data_object.json", new TestDataProvider());
    }
}
