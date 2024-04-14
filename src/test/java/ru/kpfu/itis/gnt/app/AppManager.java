package ru.kpfu.itis.gnt.app;

import ru.kpfu.itis.gnt.helper.AccountHelper;
import ru.kpfu.itis.gnt.helper.FragmentCreationHelper;
import ru.kpfu.itis.gnt.helper.NavigationHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AppManager {

    private final String BASE_URL = "https://fragmenter.net/ru";
    private final FirefoxDriver driver;
    private final AccountHelper accountHelper;
    private final FragmentCreationHelper fragmentCreationHelper;
    private final NavigationHelper navigationHelper;

    public AppManager() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        accountHelper = new AccountHelper(this);
        fragmentCreationHelper = new FragmentCreationHelper(this);
        navigationHelper = new NavigationHelper(this, BASE_URL);
    }

    public AccountHelper getAccountHelper() {
        return accountHelper;
    }

    public FragmentCreationHelper getFragmentCreationHelper() {
        return fragmentCreationHelper;
    }

    public NavigationHelper getNavigationHelper() {
        return navigationHelper;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void quit() {
        driver.quit();
    }

    public void close() {
        driver.close();
    }
}
