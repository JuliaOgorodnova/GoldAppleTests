package qa.component.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import lombok.experimental.UtilityClass;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

@UtilityClass
public class PersonalInformationPage {

    public SelenideElement thankYouForRegisteringTitle() {
        return $(byXpath("//aside[contains(@class,'_initialized _show')]//h3[1]")).shouldBe(Condition.visible);
    }

    public SelenideElement personalInformationTitle() {
        return $(byText("Личная информация")).shouldBe(Condition.visible);
    }

    public SelenideElement profileInfoName() {
        return $(byXpath("//div[@class='page-wrapper']//p[1]")).shouldBe(Condition.visible);
    }
}
