import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class PageClicTest extends BaseSettingsTest{
    @Test
     void testClick() {
        Configuration.browser = "chrome";
        Configuration.browserSize = "1680x1050";
        open("http://localhost:3000/");
        $x("//a/img").click();
        $x("//ul/li/a[@class='nav-link'][1]").click();
       /**
        * tikrinam forma
        */
       $(By.cssSelector(".btn.btn-success")).click();
        $(By.className("form-control")).setValue("Laisvalaikis");
        $(By.cssSelector("form > .btn.btn-primary")).click();

        $x("//div[@id='navbarSupportedContent']/ul//a[@href='/books']").click();
        $x("//div[@id='navbarSupportedContent']/ul//a[@href='/favorite']").click();
        $x("//div[@id='navbarSupportedContent']/ul//a[@href='/reserved']").click();
        $x("//div[@id='navbarSupportedContent']/ul//a[@href='/about']").click();
        $x("//div[@id='navbarSupportedContent']//input[@class='form-control me-2']").
                setValue("^(?!.*(.)\\1)[A-Z][a-z]{4,49}$").pressEnter();
    }
}