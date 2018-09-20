package seleniumapp.pages;


import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import seleniumapp.configuration.InitLogin;
import seleniumapp.configuration.TestConfig;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@Profile("test")
public class StartAppointmentTest extends TestConfig {

    @Autowired
    private WebDriver driver;
    @Autowired
    private InitLogin initLogin;

    WebElement attend;
    WebElement trashIcon;

    @Before
    public void setUp(){
        driver.navigate().to(domainName+loginUrl);
        driver.manage().window().maximize();
        initLogin.setUp(driver);
    }

    @Test
    public void shouldStartAppointmentWithNoAttends() throws InterruptedException {
            Thread.sleep(3000);
            StartAppointmentPage startAppointmentPage = new StartAppointmentPage(driver);
            startAppointmentPage.setMeetNowAppointment("Selenium test Appointment with no attends");
            startAppointmentPage.submitStartButton();
            Thread.sleep(3000);
    }

    @Test
    public void shouldAddAttendeeAndRemoveIt() throws InterruptedException {
        Thread.sleep(3000);
        StartAppointmentPage startAppointmentPage = new StartAppointmentPage(driver);
        startAppointmentPage.setMeetNowAppointment("Selenium test Appointment with attends");
        startAppointmentPage.setWho("any@email.com");
        Thread.sleep(3000);
        attend =  driver.findElement(By.cssSelector("div.attendee-email.cm-list-element-lower-row"));
        System.out.println(attend.getText());
        trashIcon = driver.findElement(By.cssSelector("i.glyphicon.glyphicon-trash"));
        trashIcon.click();
        //startAppointmentPage.submitStartButton();
        try{
            trashIcon.isEnabled();
        }catch(Exception e){
            System.out.println("Atendee has been corectly removed");
        }
        Thread.sleep(3000);
    }


    @Test
    public void shouldCheckKnoxMessengerNotificationByDefault() throws Exception{
        Thread.sleep(3000);
        final WebElement notificationCheckbox = driver.findElement(By.id("notificationCheckbox"));

        assertTrue(notificationCheckbox.isSelected());
    }

    @Test
    public void shouldDisplayChartLightBox() throws Exception{
        Thread.sleep(3000);
        //closeLightBox();
        final WebElement chart = driver.findElement(By.cssSelector("button.btn.btn-default.uc-icon-button.uc-icon-button-small.uc-org-chart-button"));
        chart.sendKeys(Keys.ENTER);
        Thread.sleep(3000);
        final WebElement orgChartAddBookModal = driver.findElement(By.id("orgChartAddBookModal"));

        assertEquals("block",orgChartAddBookModal.getCssValue("display"));
    }

    @Test
    public void shouldDisplayRecentInviteesLightBox() throws Exception{
        Thread.sleep(3000);
        final WebElement recentInvitees = driver.findElement(By.cssSelector("button.btn.btn-default.uc-icon-button.uc-icon-button-small.uc-recent-invitees-button"));
        recentInvitees.sendKeys(Keys.ENTER);
        Thread.sleep(3000);
        final WebElement orgChartAddBookModal = driver.findElement(By.id("favouriteUsersModal"));

        assertEquals("block",orgChartAddBookModal.getCssValue("display"));
    }

    @Test
    public void shouldDisplayScheduleAppointmentTabBox() throws Exception{
        Thread.sleep(3000);
        final WebElement scheduleAppointment = driver.findElement(By.cssSelector("a.cm-schedule"));
        scheduleAppointment.sendKeys(Keys.ENTER);
        final WebElement pressed = driver.findElement(By.cssSelector("a.cm-schedule.pressed"));
        assertEquals("Schedule Appointment",pressed.getText());
    }

    @Test
    public void shouldDisplayScheduleAppointmentTabBoxAndCheckConferenceCheckBox() throws Exception{


        Thread.sleep(3000);
        final WebElement scheduleAppointment = driver.findElement(By.cssSelector("a.cm-schedule"));
        scheduleAppointment.sendKeys(Keys.ENTER);
        Thread.sleep(3000);
        final WebElement liveStreamCheckBox = driver.findElement(By.id("livex"));
        liveStreamCheckBox.click();
        final WebElement recordAppointmentCheckBox = driver.findElement(By.id("isRecorder"));
        assertTrue(recordAppointmentCheckBox.isSelected());

    }
}
