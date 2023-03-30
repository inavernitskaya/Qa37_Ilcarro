package tests;

import models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Random;

public class Registration extends TestBase {

    @BeforeMethod
    public void preCondition(){
        if(app.getHelperUser().isLogged()){
            app.getHelperUser().logout();
        }
    }

    @Test
    public void registrationSuccess() {
        Random random = new Random();
        int i = random.nextInt(1000);
        System.out.println(i);

        System.out.println(System.currentTimeMillis());
        int z = (int)System.currentTimeMillis()/1000%3600;
        User user = new User()
                .setFirstName("Liza")
                .setLastName("Snow")
                .setEmail("snow"+i+"@gmail.com")
                .setPassword("Snow12345$");

        app.getHelperUser().openRegistrationForm();
        app.getHelperUser().fillRegistrationForm(user);
        app.getHelperUser().checkPolicyXY();
        app.getHelperUser().submit();
        // You are logged in success
        Assert.assertEquals(app.getHelperUser().getMessage(),"You are logged in success");
    }

    //@Test
   // public void registrationWrongEmail(){
     //   User user = new User()
             //   .setFirstName("Gomer")
              //  .setLastName("Simpson")
            //    .setEmail("simpsongmail.com")
              //  .setPassword("Sim12345$");

    //}

  //  @Test
    //public void registrationWrongPassword(){
     //   User user = new User()
             //   .setFirstName("Gomer")
              //  .setLastName("Simpson")
          //      .setEmail("simpson@gmail.com")
              //  .setPassword("Sim123");

   // }

   // @Test
   // public void registrationWrongPassword(){
       // User user = new User()
             //   .setFirstName("Gomer")
             //   .setLastName("Simpson")
             //   .setEmail("simpson@gmail.com")
              //
   // }

    @AfterMethod
    public void postCondition(){
        app.getHelperUser().closeWindow();
    }
}














