package ru.kpfu.itis.gnt.app;

import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxOptions;
import ru.kpfu.itis.gnt.helper.AccountHelper;
import ru.kpfu.itis.gnt.helper.FragmentCreationHelper;
import ru.kpfu.itis.gnt.helper.NavigationHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class AppManager {

    private final String BASE_URL = "https://fragmenter.net/ru";
    private final FirefoxDriver driver;
    private final AccountHelper accountHelper;
    private final FragmentCreationHelper fragmentCreationHelper;
    private final NavigationHelper navigationHelper;

    private static final ThreadLocal<AppManager> app = new ThreadLocal<>();


    public AppManager() {
        FirefoxBinary firefoxBinary = new FirefoxBinary();
        WebDriverManager.firefoxdriver().clearDriverCache().setup();
        firefoxBinary.addCommandLineOptions("--headless");
        FirefoxOptions options = new FirefoxOptions();
        options.setBinary(firefoxBinary);
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

    public static AppManager getInstance() {
        if(app.get() == null) {
            app.set(new AppManager());
        }
        return app.get();
    }
}
