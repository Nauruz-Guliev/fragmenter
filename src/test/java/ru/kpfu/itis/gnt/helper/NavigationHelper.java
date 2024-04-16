package ru.kpfu.itis.gnt.helper;

import ru.kpfu.itis.gnt.app.AppManager;

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

    public void goAccountEditor() {
        getElementByCssSelector(".fa-pencil").click();
    }
}
