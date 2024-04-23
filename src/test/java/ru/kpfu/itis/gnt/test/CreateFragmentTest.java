package ru.kpfu.itis.gnt.test;

import ru.kpfu.itis.gnt.model.AccountData;

public class CreateFragmentTest extends TestBase {

    private AccountData account = new AccountData("nauruz0304", "nauruz9248327@gmail.com", "Nau");

    /*@Test
    public void testFragmentCreation() {
        String message = "Погода сегодня восхитительна!";

        AccountHelper accountHelper = app.getAccountHelper();
        NavigationHelper navigationHelper = app.getNavigationHelper();
        FragmentCreationHelper fragmentCreationHelper = app.getFragmentCreationHelper();

        navigationHelper.goMainPage();
        accountHelper.login(account);

        navigationHelper.goFragmentCreationPage();
        fragmentCreationHelper.createFragment(message);
    }*/
}
