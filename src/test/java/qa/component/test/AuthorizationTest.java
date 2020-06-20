package qa.component.test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import qa.component.TestConfig;
import qa.component.pages.MainPage;
import qa.component.pages.PersonalInformationPage;
import qa.component.popup.SignInPopup;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static qa.component.utils.PropertyUtils.PROPERTIES;

public class AuthorizationTest extends TestConfig {

    @Test
    @DisplayName("Регистрация нового пользователя")
    void testNewUserRegistration() {
        logInOrRegisters(() -> {
            SignInPopup.phoneRandomInput();
            SignInPopup.getСodeButton().click();
            SignInPopup.codeInput().setValue(PROPERTIES.getString("authorization.code"));
            SignInPopup.confirmPhoneButton().click();
            PersonalInformationPage.personalInformationTitle();
            assertEquals(PersonalInformationPage.thankYouForRegisteringTitle().getText(), "Спасибо\n" + "за регистрацию!");
        });
    }

    @Test
    @DisplayName("Авторизация пользователя")
    void testLogInUser() {
        logInOrRegisters(() -> {
            SignInPopup.phoneInput().setValue(PROPERTIES.getString("authorization.number"));
            SignInPopup.getСodeButton().click();
            SignInPopup.codeInput().setValue(PROPERTIES.getString("authorization.code"));
            SignInPopup.confirmPhoneButton().click();
            PersonalInformationPage.personalInformationTitle();
            assertEquals(PersonalInformationPage.profileInfoName().getText(), "Юлия");
        });
    }

    @Test
    @DisplayName("Тест для проверки ввода невалидного номера телефона")
    void testInvalidPhoneNumberForRegistration() {
        logInOrRegisters(() -> {
            SignInPopup.phoneInput().setValue(PROPERTIES.getString("registration.InvalidNumber"));
            SignInPopup.getСodeButton().click();
            assertEquals(SignInPopup.phoneErrorMessage().getText(), "введите номер телефона полностью");
        });
    }

    public void logInOrRegisters(final Runnable logInOrRegistersAction) {
        MainPage.mainPageHasLoaded();
        MainPage.customerButton().click();
        SignInPopup.signInPopupHasLoaded();
        logInOrRegistersAction.run();
    }
}
