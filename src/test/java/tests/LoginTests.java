package tests;

import models.User;
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
        app.getHelperUser().submit();
        //Assert if element with text "Logged in success" is present
        Assert.assertEquals(app.getHelperUser().getMessage(), "Logged in success");

    }

    @Test
    public void loginSuccess1() {
          User user = new User().setEmail("inna_83@gmail.com").setPassword("Aa13579$");
//        user.setEmail("inna_83@gmail.com");
//        user.setPassword("Aa13579$");

            app.getHelperUser().openLoginForm();
            app.getHelperUser().fillLoginForm(user);
            app.getHelperUser().submit();
            //Assert if element with text "Logged in success" is present
            Assert.assertEquals(app.getHelperUser().getMessage(),"Logged in success");
    }

    @Test
    public void loginSuccessModel() {
            app.getHelperUser().openLoginForm();
            app.getHelperUser().fillLoginForm("inna_83@gmail.com", "Aa13579$");
            app.getHelperUser().submit();
            //Assert if element with text "Logged in success" is present
            Assert.assertEquals(app.getHelperUser().getMessage(), "Logged in success");
        }
        @Test
         public void loginWrongEmail() {
            app.getHelperUser().openLoginForm();
            app.getHelperUser().fillLoginForm("inna_83gmail.com", "Aa13579$");
            app.getHelperUser().submit();
            Assert.assertEquals(app.getHelperUser().getErrorText(),"It'snot look like email");
            Assert.assertTrue(app.getHelperUser().isYallaButtonNotActive());
        }

        @Test
        public void loginWrongPassword() {
            app.getHelperUser().openLoginForm();
            app.getHelperUser().fillLoginForm("inna_83@gmail.com", "Aa13");
            app.getHelperUser().submit();
            Assert.assertEquals(app.getHelperUser().getMessage(), "\"Login or Password incorrect\"");
        }

        @Test
        public void loginUnregisteredUser () {
            app.getHelperUser().openLoginForm();
            app.getHelperUser().fillLoginForm("pinokio@gmail.com", "Pn6474849$");
            app.getHelperUser().submit();
            Assert.assertEquals(app.getHelperUser().getMessage(), "\"Login or Password incorrect\"");
        }

        @AfterMethod
        public void postCondition () {
            app.getHelperUser().closeWindow();
       }

    }

