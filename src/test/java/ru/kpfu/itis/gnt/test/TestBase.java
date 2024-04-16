package ru.kpfu.itis.gnt.test;

import ru.kpfu.itis.gnt.app.AppManager;
import org.junit.Before;

public class TestBase {

    static protected AppManager app;

    @Before
    public void setUp() {
        app = AppManager.getInstance();
    }
}
