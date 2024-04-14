package ru.kpfu.itis.gnt.test;

import org.junit.Assert;
import ru.kpfu.itis.gnt.helper.AccountHelper;
import ru.kpfu.itis.gnt.helper.NavigationHelper;
import ru.kpfu.itis.gnt.model.AccountData;
import org.junit.Test;

public class AccountTest extends TestBase {

    private AccountData account = new AccountData("nauruz0304", "nauruz9248327@gmail.com", "Nau");

    @Test
    public void testLogin() {
        AccountHelper accountHelper = app.getAccountHelper();
        NavigationHelper navigationHelper = app.getNavigationHelper();

        navigationHelper.goMainPage();
        accountHelper.login(account);

        Assert.assertEquals(10, 20);
    }

    @Test
    public void testNicknameNoteChange() {
        String note = "Сегодня хорошая погода! ";
        testLogin();
        AccountHelper accountHelper = app.getAccountHelper();
        accountHelper.changeNicknameNote(note, account.getAccountCode());
    }

    @Test
    public void testLogout() {
        testLogin();
        app.getAccountHelper().logout(account.getAccountCode());
    }
}
