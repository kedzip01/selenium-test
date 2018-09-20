package seleniumapp.configuration;


import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import seleniumapp.Application;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {Application.class, ITConfig.class})
@ActiveProfiles("test")
public class TestConfig {

    @Value("${login.email}")
    protected String email;
    @Value("${login.password}")
    protected String password;
    @Value("${domainName}")
    protected String domainName;
    @Value("${loginPageUrl}")
    protected String loginUrl;

}
