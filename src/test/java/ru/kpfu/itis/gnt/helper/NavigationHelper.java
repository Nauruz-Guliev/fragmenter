package ru.kpfu.itis.gnt.helper;

import ru.kpfu.itis.gnt.app.AppManager;

public class NavigationHelper extends HelperBase {


    public NavigationHelper(AppManager app) {
        super(app);
    }

    public void goMainPage(String baseUrl) {
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
