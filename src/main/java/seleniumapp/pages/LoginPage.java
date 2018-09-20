package seleniumapp.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;


public class LoginPage {

    private WebDriver driver;

    @FindBy(how = How.ID, id = "email")
    private WebElement email;

    @FindBy(how = How.ID, id = "password")
    private WebElement password;

    @FindBy(how = How.ID, id = "signin")
    WebElement button;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void setEmail(String userEmail) {
        email.clear();
        email.sendKeys(userEmail);
    }

    public void setPassword(String userPassword) {
        password.clear();
        password.sendKeys(userPassword);
    }

    public void click_button() {
        button.submit();
    }

}
