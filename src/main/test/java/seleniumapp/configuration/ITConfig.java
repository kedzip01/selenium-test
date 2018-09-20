package seleniumapp.configuration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ITConfig {

    @Value("${webDriverArg}")
    private String webDriverArg;

    private WebDriver optionalDriver;

    @Bean
    public WebDriver driver(){
        switch(webDriverArg){
            case "ie":
                System.setProperty("webdriver.chrome.driver","C:\\selenium\\2.35\\chromedriver.exe");
                optionalDriver = new InternetExplorerDriver();
                break;
            case "ff":
                System.setProperty("webdriver.chrome.driver","C:\\selenium\\2.35\\chromedriver.exe");
                optionalDriver = new FirefoxDriver();
                break;
            default:
                System.setProperty("webdriver.chrome.driver","F:\\selenium\\2.35\\chromedriver.exe");
                optionalDriver =  new ChromeDriver();
        }
        return optionalDriver;
    }
}
