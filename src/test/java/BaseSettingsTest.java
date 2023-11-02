import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;

abstract public class BaseSettingsTest {
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        Configuration.browser = "chrome";
        Configuration.webdriverLogsEnabled = true;
        Configuration.browserSize = "1680x1050";
        Configuration.headless = true;
        Configuration.holdBrowserOpen = true;
        Configuration.timeout = 6000;
    }
    @Before
    public void  init() {
        setUp();
    }
    @After
    public void tearDown() {
        Selenide.closeWebDriver();
    }
}
