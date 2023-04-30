package manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.Browser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ApplicationManager {


    WebDriver wd;
    HelperUser helperUser;
    HelperCar helperCar;
    Logger logger = LoggerFactory.getLogger(ApplicationManager.class);
    String browser;

    public ApplicationManager(String browser) {
        this.browser = browser;
    }


        public HelperCar init() {

        if (browser.equals(Browser.CHROME.browserName())) {
            // "firefox" "chrome"

            Browser.EDGE.browserName();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");
            wd = new ChromeDriver(options);
            logger.info("All tests run in Chrome Browser");
        } else if (browser.equals(Browser.FIREFOX.browserName())) { // "firefox" == "firefox"
            wd = new FirefoxDriver();
            logger.info("All tests run in FIREFOX Browser");
        } else if (browser.equals(Browser.EDGE.browserName())) {
            wd = new EdgeDriver();
            logger.info("All tests run in EDGE Browser");
        }

//        public void stop() {
           // wd.quit();
        //}

        public HelperCar getHelperCar() {
            return helperCar;
        }

    }

    public HelperUser getHelperUser() {
        return helperUser;
    }
}



