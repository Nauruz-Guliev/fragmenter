package ru.kpfu.itis.gnt.test;

import org.junit.Assert;
import ru.kpfu.itis.gnt.helper.AccountHelper;
import ru.kpfu.itis.gnt.helper.NavigationHelper;
import ru.kpfu.itis.gnt.model.AccountData;
import org.junit.Test;

public class AccountTest extends TestBase {

    private AccountData account = new AccountData("nauruz0304", "nauruz9248327@gmail.com", "Nau");

    @Test
    public void testA() {
        AccountHelper accountHelper = app.getAccountHelper();
        NavigationHelper navigationHelper = app.getNavigationHelper();

        navigationHelper.goMainPage();
        accountHelper.login(account);

        Assert.assertEquals(accountHelper.getCurrentName(account.getAccountCode()).getText(), account.getAccountCode());
    }

    @Test
    public void testB() {
        String note = "Сегодня хорошая погода! ";
        AccountHelper accountHelper = app.getAccountHelper();
        NavigationHelper navigationHelper = app.getNavigationHelper();
        accountHelper.changeNicknameNote(note, account.getAccountCode());
        navigationHelper.goAccountEditor();
        Assert.assertEquals(accountHelper.getUserNote().getText(), note);
    }

   /* @Test
    public void testC() {
        app.getAccountHelper().logout(account.getAccountCode());
    }*/
}
