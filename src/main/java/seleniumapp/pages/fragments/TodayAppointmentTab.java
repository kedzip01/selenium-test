package seleniumapp.pages.fragments;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class TodayAppointmentTab {

    private WebDriver driver;

    @FindBy(how = How.ID, id = "todayMeetingsTable")
    private WebElement todayMeetingsTable;

    private WebElement tbody;

    public TodayAppointmentTab(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public List<WebElement> getMeetingTableRows(){
        tbody = todayMeetingsTable.findElement(By.cssSelector("tbody"));
        return tbody.findElements(By.tagName("tr"));
    }

    public boolean isMeetingCreated(String meetingTitle) throws InterruptedException{
        final List<WebElement> meetingTableRows = getMeetingTableRows();
        for(int i = 0; i< meetingTableRows.size(); i++){
            if(meetingTableRows.get(i).findElements(By.tagName("td")).get(2).getText().equals(meetingTitle)){
                return true;
            }
        }
        return false;
    }

    public void expendMeetingInformation(String meetingTitle) throws InterruptedException {
        final List<WebElement> meetingTableRows = getMeetingTableRows();
        for (int i = 0; i < meetingTableRows.size(); i++) {
            if (meetingTableRows.get(i).findElements(By.tagName("td")).get(2).getText().equals(meetingTitle)) {
                Thread.sleep(3000);

                clickButton(meetingTableRows.get(i).findElements(By.tagName("td")).get(0));
                Thread.sleep(3000);

                final WebElement todayMeetingsTableDetails = driver.findElement(By.id("todayMeetingsTable"));
                final WebElement tbodyDetails = todayMeetingsTableDetails.findElement(By.className("detail-view"));

                chooseButton(tbodyDetails.findElements(By.tagName("button")),"Edit");
                Thread.sleep(3000);

                chooseButton(tbodyDetails.findElements(By.tagName("button")),"Delete");
                Thread.sleep(3000);

                final WebElement confirmDeleteOnDeleteLightBox = driver.findElement(By.xpath("/html/body/div[5]/div/div/div[2]/button[2]"));
                Thread.sleep(1000);
                System.out.println(confirmDeleteOnDeleteLightBox.isEnabled());
                confirmDeleteOnDeleteLightBox.sendKeys(Keys.ENTER);


                Thread.sleep(3000);


            }
        }
    }

    public void chooseButton(List<WebElement> buttons, String buttonName){
        for (int i = 0; i < buttons.size(); i++) {
            System.out.println(buttons.get(i).getText().toString());
            if (buttons.get(i).getText().toString().equalsIgnoreCase(buttonName)) {
                buttons.get(i).sendKeys(Keys.ENTER);
                break;
            }
        }
    }

    public void clickButton(WebElement element){
            element.click();
    }





}
