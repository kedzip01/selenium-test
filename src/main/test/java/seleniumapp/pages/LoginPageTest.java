package seleniumapp.pages;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import seleniumapp.configuration.InitLogin;
import seleniumapp.configuration.TestConfig;

import static org.junit.Assert.assertTrue;

@Profile("test")
public class LoginPageTest extends TestConfig {

    @Autowired
    private WebDriver driver;

    @Autowired
    private InitLogin initLogin;

    @Before
    public void setUp(){
        driver.navigate().to(domainName+loginUrl);
        driver.manage().window().maximize();
        initLogin.setUp(driver);
    }

    @Test
    public void shouldLoginToPage(){
        assertTrue(driver.getCurrentUrl().matches(".*login"));
    }

    @After
    public void closePipe() throws Exception{
        driver.quit();
    }

}