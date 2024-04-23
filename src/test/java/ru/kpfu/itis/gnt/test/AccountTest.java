package ru.kpfu.itis.gnt.test;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import ru.kpfu.itis.gnt.helper.AccountHelper;
import ru.kpfu.itis.gnt.helper.NavigationHelper;
import ru.kpfu.itis.gnt.model.AccountData;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

@TestMethodOrder(OrderAnnotation.class)
public class AccountTest extends TestBase {

    private AccountData account = new AccountData("nauruz0304", "nauruz9248327@gmail.com", "Nau");

    @Test
    @Order(1)
    public void test_login() {
        AccountHelper accountHelper = app.getAccountHelper();
        NavigationHelper navigationHelper = app.getNavigationHelper();

        navigationHelper.goMainPage();
        accountHelper.login(account);

        assertEquals(accountHelper.getCurrentName(account.getAccountCode()).getText(), account.getAccountCode());
    }

    @Test
    @Order(2)
    public void test_nick_note_text_removal() {
        String note = "";
        AccountHelper accountHelper = app.getAccountHelper();
        NavigationHelper navigationHelper = app.getNavigationHelper();
        accountHelper.deleteNicknameNote(account.getAccountCode());
        navigationHelper.goAccountEditor();
        assertEquals(note, accountHelper.getUserNote().getText());
    }

    @Test
    @Order(3)
    public void test_nick_note_text_addition() {
        String note = "Сегодня хорошая погода!";
        AccountHelper accountHelper = app.getAccountHelper();
        NavigationHelper navigationHelper = app.getNavigationHelper();
        accountHelper.changeNicknameNote(note, account.getAccountCode());
        navigationHelper.goAccountEditor();
        assertEquals(note, accountHelper.getUserNote().getText());
    }

    @Test
    @Order(4)
    public void test_logout() {
        AccountHelper accountHelper = app.getAccountHelper();
        accountHelper.logout(account.getAccountCode());
        Boolean isLoginButtonPresent = accountHelper.checkElementExistsByName("commit");
        assertEquals(true, isLoginButtonPresent);
        app.close();
    }
}
