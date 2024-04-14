package ru.kpfu.itis.gnt.helper;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.kpfu.itis.gnt.app.AppManager;

import java.time.Duration;

public class NavigationHelper extends HelperBase {

    private final String baseUrl;

    public NavigationHelper(AppManager app, String baseUrl) {
        super(app);
        this.baseUrl = baseUrl;
    }

    public void goMainPage() {
        app.getDriver().get(baseUrl);
    }

    public void goMyPage(String currentNickname) {
        getElementByLinkText(currentNickname).click();
        getElementByLinkText("Моя страница").click();
    }

    public void goFragmentCreationPage() {
        getElementById("countdown_allowed").click();
    }
}
