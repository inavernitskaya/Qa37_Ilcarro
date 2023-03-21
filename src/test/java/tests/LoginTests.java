package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {

    @BeforeMethod
    public void preCondition() {

        if (app.getHelperUser().isLogged()) {
            app.getHelperUser().logout();
        }
    }

    @Test
    public void loginSuccess() {
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm("inna_83@gmail.com", "Aa13579$");
        app.getHelperUser().submitLogin();
        //Assert if element with text "Logged in success" is present
        Assert.assertEquals(app.getHelperUser().getMessage(), "Logged in success");


    }

    @Test
    public void loginSuccessModel() {
            app.getHelperUser().openLoginForm();
            app.getHelperUser().fillLoginForm("inna_83@gmail.com", "Aa13579$");
            app.getHelperUser().submitLogin();
            //Assert if element with text "Logged in success" is present
            Assert.assertEquals(app.getHelperUser().getMessage(), "Logged in success");

        }

        @Test
         public void loginWrongEmail() {
            app.getHelperUser().openLoginForm();
            app.getHelperUser().fillLoginForm("inna_83@mail.com", "Aa13579$");
            app.getHelperUser().submitLogin();
            Assert.assertEquals(app.getHelperUser().getMessage(), "\"Login or Password incorrect\"");
        }

        @Test
        public void loginWrongPassword() {
            app.getHelperUser().openLoginForm();
            app.getHelperUser().fillLoginForm("inna_83@gmail.com", "Aa13");
            app.getHelperUser().submitLogin();
            Assert.assertEquals(app.getHelperUser().getMessage(), "\"Login or Password incorrect\"");
        }

        @Test
        public void loginUnregisteredUser () {
            app.getHelperUser().openLoginForm();
            app.getHelperUser().fillLoginForm("pinokio@gmail.com", "Pn6474849$");
            app.getHelperUser().submitLogin();
            Assert.assertEquals(app.getHelperUser().getMessage(), "\"Login or Password incorrect\"");
        }

        @AfterMethod
        public void postCondition () {
          app.getHelperUser().closeWindow();
       }

    }

