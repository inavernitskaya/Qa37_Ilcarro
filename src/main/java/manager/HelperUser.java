package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HelperUser extends HelperBase{
    public HelperUser(WebDriver wd) {

        super(wd);
    }

    public void openLoginForm(){
        click(By.cssSelector("a[ng-reflect-router-link='login']"));
    }

    public void fillLoginForm(String email,String password) {

        type(By.xpath("//input[@id='email']"), email);

        type(By.xpath("(//input[@id='password'])[1]"),password);
    }

    public void submitLogin(){
        click(By.cssSelector("button[type='submit']"));
    }


    public boolean isLogged() {
        return isElementPresent(By.xpath("//button[.=' Logout ']"));

    }

    public void logout(){
       click(By.xpath("//button[.=' Logout ']"));
    }
}
