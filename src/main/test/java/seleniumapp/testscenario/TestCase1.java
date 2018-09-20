package seleniumapp.testscenario;


import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import seleniumapp.configuration.InitLogin;
import seleniumapp.configuration.TestConfig;
import seleniumapp.pages.StartAppointmentPage;
import seleniumapp.pages.fragments.TodayAppointmentTab;

@Profile("test")
public class TestCase1 extends TestConfig {

    @Autowired
    WebDriver driver;
    @Autowired
    InitLogin initLogin;

    @Before
    public void setUp(){
        driver.navigate().to(domainName+loginUrl);
        driver.manage().window().maximize();
        initLogin.setUp(driver);
    }

    @Test
    public void test() throws Exception{
        Thread.sleep(3000);

        StartAppointmentPage startAppointmentPage = new StartAppointmentPage(driver);
        startAppointmentPage.setMeetNowAppointment("Selenium test Appointment");
        startAppointmentPage.setWho("something@something.com");
        startAppointmentPage.submitStartButton();

        Thread.sleep(3000);

        TodayAppointmentTab todayAppointmentTab = new TodayAppointmentTab(driver);

    }

}
