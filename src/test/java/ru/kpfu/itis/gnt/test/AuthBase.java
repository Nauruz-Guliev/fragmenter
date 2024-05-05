package ru.kpfu.itis.gnt.test;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import ru.kpfu.itis.gnt.app.AppManager;
import ru.kpfu.itis.gnt.model.TestDataObject;
import ru.kpfu.itis.gnt.provider.TestDataProvider;


public class AuthBase extends TestBase {

    @BeforeAll
    public static void doBeforeAll() {
        app = AppManager.getInstance();
        TestDataProvider testDataProvider = new TestDataProvider();
        try {
            TestDataObject testDataObject = testDataProvider.provideTestDataObject("valid_test_data_object.json");
            app.getNavigationHelper().goMainPage(testDataObject.getBaseUrl());
            app.getAccountHelper().login(testDataObject);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    @AfterAll
    public static void closeApp() {
        app.close();
    }
}
