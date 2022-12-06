package org.selenium.pom.test;

import org.junit.jupiter.api.Test;
import org.selenium.pom.api.actions.LoginApi;
import org.selenium.pom.base.BaseTest;
import org.selenium.pom.objects.User;
import org.selenium.pom.pages.HomePage;

public class TestCase extends BaseTest {

    @Test
    public void Test() {
        String username = "John Doe";
        String password ="ThisIsNotAPassword";
        String facility ="Seoul CURA Healthcare Center";
        String comment ="Hello";
        User user = new User().
                setUsername(username).
                setPassword(password);
        LoginApi loginApi = new LoginApi();
        HomePage homePage = new HomePage(driver).load().clickMakeAppoinment();
        loginApi.getLogin();
        loginApi.login(user);
        homePage.login(user).selectFacility(facility).selectButton().selectRadioButton().clickDate().clickDate2().enterComment(comment).clickBookButton().setComment(comment);

    }
}
