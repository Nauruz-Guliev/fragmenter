package ru.kpfu.itis.gnt.test;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import ru.kpfu.itis.gnt.helper.AccountHelper;
import ru.kpfu.itis.gnt.mapper.InvalidTestDataObjectMapper;
import ru.kpfu.itis.gnt.mapper.ValidTestDataObjectMapper;
import ru.kpfu.itis.gnt.model.TestDataObject;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class LoginTests extends TestBase {

    @ParameterizedTest
    @Order(1)
    @ArgumentsSource(InvalidTestDataObjectMapper.class)
    public void test_login_invalid(TestDataObject testDataObject) {
        AccountHelper accountHelper = app.getAccountHelper();
        accountHelper.login(testDataObject);
        boolean isLoginButtonPresent = accountHelper.checkElementExistsByName("commit");
        assertTrue(isLoginButtonPresent);
    }

    @ParameterizedTest
    @Order(2)
    @ArgumentsSource(ValidTestDataObjectMapper.class)
    public void test_login_valid(TestDataObject testDataObject) {
        AccountHelper accountHelper = app.getAccountHelper();
        accountHelper.login(testDataObject);
        assertEquals(accountHelper.getCurrentName(testDataObject.getAccountCode()).getText(), testDataObject.getAccountCode());
    }
}
