package seleniumapp.configuration;


import org.openqa.selenium.WebDriver;
import org.springframework.stereotype.Component;
import seleniumapp.pages.LoginPage;

@Component
public class InitLogin extends TestConfig {

   public void setUp(WebDriver driver){
       LoginPage loginPage = new LoginPage(driver);
       loginPage.setEmail(email);
       loginPage.setPassword(password);
       loginPage.click_button();
   }
}
