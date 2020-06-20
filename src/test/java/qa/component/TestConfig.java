package qa.component;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.open;

@FieldDefaults(makeFinal = true, level = AccessLevel.PROTECTED)
public class TestConfig {

    @BeforeEach
    public void setUp() {
        Configuration.browser = "chrome";
        Configuration.baseUrl = "https://demo.goldapple.ru/";
        Configuration.browserSize = "1440x900";
        Configuration.timeout = 10000;
        open("");
    }

    @AfterEach
    public void tearDown() {
        WebDriverRunner.clearBrowserCache();
        WebDriverRunner.getWebDriver().manage().deleteAllCookies();
        WebDriverRunner.getWebDriver().close();
    }
}
