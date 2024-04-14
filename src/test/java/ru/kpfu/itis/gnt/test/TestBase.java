package ru.kpfu.itis.gnt.test;

import ru.kpfu.itis.gnt.app.AppManager;
import org.junit.After;
import org.junit.Before;

public class TestBase {

    protected AppManager app;

    @Before
    public void setUp() {
        app = new AppManager();
    }

    @After
    public void tearDown() {
        app.quit();
    }
}
