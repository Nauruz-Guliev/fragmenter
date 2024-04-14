package ru.kpfu.itis.gnt.helper;

import ru.kpfu.itis.gnt.app.AppManager;

public class FragmentCreationHelper extends HelperBase {

    public FragmentCreationHelper(AppManager app) {
        super(app);
    }

    public void createFragment(String message) {
        getElementById("fragment_body").click();
        getElementById("fragment_body").sendKeys(message);
        getElementById("edit_submit_button").click();
    }
}
