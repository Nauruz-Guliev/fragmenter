package ru.kpfu.itis.gnt.app;

import lombok.Data;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.kpfu.itis.gnt.helper.AccountHelper;
import ru.kpfu.itis.gnt.helper.FragmentCreationHelper;
import ru.kpfu.itis.gnt.helper.NavigationHelper;

@Data
public class AppManager {

    private final ChromeDriver driver;
    private final AccountHelper accountHelper;
    private final FragmentCreationHelper fragmentCreationHelper;
    private final NavigationHelper navigationHelper;

    private static final ThreadLocal<AppManager> app = new ThreadLocal<>();


    public AppManager() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        accountHelper = new AccountHelper(this);
        fragmentCreationHelper = new FragmentCreationHelper(this);
        navigationHelper = new NavigationHelper(this);
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
