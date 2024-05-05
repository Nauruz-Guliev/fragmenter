package ru.kpfu.itis.gnt.test;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import ru.kpfu.itis.gnt.app.AppManager;

public class TestBase {

    static protected AppManager app;

    @BeforeAll
    public static void setUp() {
        app = AppManager.getInstance();
    }

    @AfterAll
    public static void closeApp() {
        app.close();
    }
}
