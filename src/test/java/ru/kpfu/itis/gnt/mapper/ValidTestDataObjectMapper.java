package ru.kpfu.itis.gnt.mapper;

import ru.kpfu.itis.gnt.provider.TestDataProvider;

public class ValidTestDataObjectMapper extends BaseTestDataObjectMapper {

    public ValidTestDataObjectMapper() {
        super("valid_test_data_object.json", new TestDataProvider());
    }
}
