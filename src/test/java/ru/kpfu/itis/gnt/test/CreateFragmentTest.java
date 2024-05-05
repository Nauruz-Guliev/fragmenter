package ru.kpfu.itis.gnt.test;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import ru.kpfu.itis.gnt.helper.FragmentCreationHelper;
import ru.kpfu.itis.gnt.helper.NavigationHelper;
import ru.kpfu.itis.gnt.mapper.ValidTestDataObjectMapper;
import ru.kpfu.itis.gnt.model.TestDataObject;

public class CreateFragmentTest extends AuthBase {

    @ParameterizedTest
    @Order(4)
    @ArgumentsSource(ValidTestDataObjectMapper.class)
    public void testFragmentCreation(TestDataObject testDataObject) {
        String message = "Погода сегодня восхитительна!";
        NavigationHelper navigationHelper = app.getNavigationHelper();
        FragmentCreationHelper fragmentCreationHelper = app.getFragmentCreationHelper();
        navigationHelper.goFragmentCreationPage();
        fragmentCreationHelper.createFragment(message);
    }
}
