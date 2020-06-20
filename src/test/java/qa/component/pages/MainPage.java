package qa.component.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import lombok.experimental.UtilityClass;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

@UtilityClass
public class MainPage {

    public static void mainPageHasLoaded() {
        homePageSlidesIsDisplayed();
        storiesBlockIsDisplayed();
        mainContentIsDisplayed();
        checkoutContainerIsDisplayed();
    }

    public static boolean homePageSlidesIsDisplayed() {
        return $(byXpath("//div[@class='homepage-slide__inner']")).isDisplayed();
    }

    public static boolean storiesBlockIsDisplayed() {
        return $(byXpath("//div[@class='stories-circles__inner']")).isDisplayed();
    }

    public static boolean mainContentIsDisplayed() {
        return $(byXpath("//main[@id='maincontent']")).isDisplayed();
    }

    public static boolean checkoutContainerIsDisplayed() {
        return $(byXpath("//div[@class='checkout-container']")).isDisplayed();
    }

    public SelenideElement customerButton() {
        return $(byXpath("//button[@class='header-tab-button header-tab-button_customer']")).shouldBe(Condition.visible);
    }
}
