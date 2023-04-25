package pages;
import com.codeborne.selenide.SelenideElement;
import components.CalendarComponents;
import components.RegistrationressultModal;

import java.io.File;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;
public class RegistrationPage {
    RegistrationressultModal registrationressultModal = new RegistrationressultModal();
    CalendarComponents calendarComponents = new CalendarComponents();

    private final SelenideElement firstNameInput = $("#firstName");
    private final SelenideElement lastNameInput = $("#lastName");
    private final SelenideElement emailInput = $("#userEmail");
    private final SelenideElement genderRadio = $("#genterWrapper");

    private final SelenideElement number = $("#userNumber");
    private final SelenideElement setSubject = $("#subjectsInput");
    private final SelenideElement setCheckbox = $("#hobbiesWrapper");
    private final SelenideElement uploadFile = $("#uploadPicture");
    private final SelenideElement setAddress = $("#currentAddress");
    private final SelenideElement setState = $("#state");
    private final SelenideElement setCity = $("#stateCity-wrapper");

    private final SelenideElement clickSubmit = $("#submit");
    private final SelenideElement closemodal = $("#closeLargeModal");


    public RegistrationPage openPage() {
        open("https://demoqa.com/automation-practice-form");
        return this;
    }

    public RegistrationPage executeJS() {
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    public RegistrationPage setFirsName(String value) {
        firstNameInput.setValue(value);
        return this;
    }

    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }

    public RegistrationPage setEmail(String value) {
        emailInput.setValue(value);
        return this;
    }


    public RegistrationPage setGender(String value) {
        genderRadio.$(byText(value)).click();
        return this;
    }


    public RegistrationPage setNumber(String value) {
        number.setValue(value);
        return this;
    }


    public RegistrationPage setSubject(String value) {
        setSubject.setValue(value).pressEnter();
        return this;
    }


    public RegistrationPage setCheckbox(String value) {
        setCheckbox.$(byText(value)).click();
        return this;
    }


    public RegistrationPage uploadFile(String path) {
        uploadFile.uploadFile(new File(path));
        return this;
    }


    public RegistrationPage setAddress(String value) {
        setAddress.setValue(value);
        return this;
    }


    public RegistrationPage setState(String value) {
        setState.click();
        $("#stateCity-wrapper").$(byText(value)).click();
        return this;
    }

    public RegistrationPage setstateCity(String value) {
        $("#city").click();
        setCity.$(byText(value)).click();
        return this;

    }


    public RegistrationPage submitclick() {
        clickSubmit.click();
        return this;
    }

    public RegistrationPage setBirthDay(String day, String month, String year) {
        $("#dateOfBirthInput").click();
        calendarComponents.setDate(day, month, year);
        return this;

    }


    public RegistrationPage closeModal() {
        closemodal.click();
        return this;
    }

    public RegistrationPage verifiability() {
        registrationressultModal.verifyModalText();
        return this;
    }

    public RegistrationPage verifyValueTable(String key, String value) {
        registrationressultModal.verifyValueTable(key, value);
        return this;
    }
}
