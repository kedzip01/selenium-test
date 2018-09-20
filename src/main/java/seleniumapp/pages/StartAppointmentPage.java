package seleniumapp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;


public class StartAppointmentPage {

    private WebDriver driver;
    private WebElement meetNowAppointment;
    private WebElement who;
    private WebElement startButton;

    public StartAppointmentPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void setMeetNowAppointment(String AppointmentTitle){
        meetNowAppointment = driver.findElement(By.cssSelector("input[class='topic form-control input-sm uc-input-field']"));
        meetNowAppointment.clear();
        meetNowAppointment.sendKeys(AppointmentTitle);
    }

    public void setWho(String whoList){
        who = driver.findElement(By.cssSelector("input[class='who-searcher form-control input-sm uc-input-field ui-autocomplete-input']"));
        who.clear();
        who.sendKeys(whoList);
        who.sendKeys(Keys.ENTER);
    }

    public void submitStartButton(){
        startButton = driver.findElement(By.cssSelector("button[class='createAppointmentButton btn btn-success']"));
        startButton.sendKeys(Keys.ENTER);
    }



}
