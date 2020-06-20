package qa.component.popup;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import lombok.experimental.UtilityClass;
import lombok.val;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

@UtilityClass
public class SignInPopup {

    public static void signInPopupHasLoaded() {
        signInForm();
        signInTitle();
        signInPrivacyPolicyFooterText();
        placeholderPhoneIsDisplayed();
    }

    public void phoneRandomInput() {
        val phone = "+7" + Math.random();
        phoneInput().waitUntil(Condition.visible, 3000).setValue(phone);
    }

    public static boolean placeholderPhoneIsDisplayed() {
        return $(byXpath("//input[@placeholder='Телефон']")).isDisplayed();
    }

    public SelenideElement signInForm() {
        return $(byXpath("//div[@class='vertical-content vertical-content_login']")).shouldBe(Condition.visible);
    }

    public SelenideElement signInTitle() {
        return $(byXpath("//h3[@class='heading-3-modal vertical-content__title']")).shouldBe(Condition.visible);

    }

    public static boolean signInPrivacyPolicyFooterText() {
        return $(byXpath("//p[contains(text(),'reCAPTCHA')]")).isDisplayed();
    }

    public SelenideElement phoneInput() {
        return $(byXpath("//div[@class='input-field input-field_phone']/input")).shouldBe(Condition.visible);
    }

    public SelenideElement phoneErrorMessage() {
        return $(byXpath("//label[@id='phone-error']")).shouldBe(Condition.visible);
    }

    public SelenideElement getСodeButton() {
        return $(byText("Получить код")).shouldBe(Condition.visible);
    }

    public SelenideElement codeInput() {
        return $(byXpath("//div[@class='input-field input-field_code']/input")).shouldBe(Condition.visible);
    }

    public SelenideElement confirmPhoneButton() {
        return $(byText("Подтвердить телефон")).shouldBe(Condition.visible);
    }
}
