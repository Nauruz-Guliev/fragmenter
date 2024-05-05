package ru.kpfu.itis.gnt.test;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import ru.kpfu.itis.gnt.helper.AccountHelper;
import ru.kpfu.itis.gnt.helper.NavigationHelper;
import ru.kpfu.itis.gnt.mapper.ValidTestDataObjectMapper;
import ru.kpfu.itis.gnt.model.TestDataObject;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

@TestMethodOrder(OrderAnnotation.class)
public class AccountTests extends AuthBase {


    @ParameterizedTest
    @Order(1)
    @ArgumentsSource(ValidTestDataObjectMapper.class)
    public void test_nick_note_text_removal(TestDataObject testDataObject) {
        String emptyNote = "";
        AccountHelper accountHelper = app.getAccountHelper();
        NavigationHelper navigationHelper = app.getNavigationHelper();
        accountHelper.deleteNicknameNote(testDataObject.getAccountCode());
        navigationHelper.goAccountEditor();
        assertEquals(emptyNote, accountHelper.getUserNote().getText());
    }

    @ParameterizedTest
    @Order(2)
    @ArgumentsSource(ValidTestDataObjectMapper.class)
    public void test_nick_note_text_addition(TestDataObject testDataObject) {
        AccountHelper accountHelper = app.getAccountHelper();
        NavigationHelper navigationHelper = app.getNavigationHelper();
        accountHelper.changeNicknameNote(testDataObject.getText(), testDataObject.getAccountCode());
        navigationHelper.goAccountEditor();
        assertEquals(testDataObject.getText(), accountHelper.getUserNote().getText());
    }

    @ParameterizedTest
    @Order(3)
    @ArgumentsSource(ValidTestDataObjectMapper.class)
    public void test_logout(TestDataObject testDataObject) {
        AccountHelper accountHelper = app.getAccountHelper();
        accountHelper.logout(testDataObject.getAccountCode());
        boolean isLoginButtonPresent = accountHelper.checkElementExistsByName("commit");
        assertTrue(isLoginButtonPresent);
    }
}
