package ru.kpfu.itis.gnt.helper;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import ru.kpfu.itis.gnt.app.AppManager;
import ru.kpfu.itis.gnt.model.AccountData;
import org.openqa.selenium.WebElement;

public class AccountHelper extends HelperBase {

    public AccountHelper(AppManager app) {
        super(app);
    }

    public void login(AccountData accountData) {
        WebElement emailField = getElementById("user_email");
        WebElement passwordField = getElementById("user_password");

        emailField.click();
        emailField.sendKeys(accountData.getEmail());

        passwordField.click();
        passwordField.sendKeys(accountData.getPassword());

        getElementByName("commit").click();
    }

    public void changeNicknameNote(String newText, String currentNickname) {
        app.getNavigationHelper().goMyPage(currentNickname);
        getElementByCssSelector(".fa-pencil").click();
        getElementById("custom_user_name").click();
        WebElement userNote = getElementById("custom_user_notes");
        userNote.click();
        userNote.sendKeys(newText);
        getElementByName("commit").click();
    }

    public void deleteNicknameNote(String currentNickname) {
        app.getNavigationHelper().goMyPage(currentNickname);
        getElementByCssSelector(".fa-pencil").click();
        getElementById("custom_user_name").click();
        WebElement userNote = getElementById("custom_user_notes");
        userNote.click();
        userNote.clear();
        getElementByName("commit").click();
    }

    public void logout(String accountCode) {
        getElementByLinkText(accountCode).click();
        getElementByLinkText("Выйти").click();
    }

    public WebElement getCurrentName(String name) {
        return getElementByLinkText(name);
    }

    public WebElement getUserNote(){
        return getElementById("custom_user_notes");
    }
}
