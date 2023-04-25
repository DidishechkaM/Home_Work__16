import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

public class TestDemoQADiWithPageObject extends TestBase {


    String userName = "Dian",
            lastNme = " Maksimowa",
            userEmail = "maksimowa@yandex.ru";

    @Test
    @Tag("remote")
    void fillTest() {
        step("Open form", () -> {
            registrationPage.openPage()
                    .executeJS();
        });
        step("Input date", () -> {
            registrationPage.setFirsName(userName)
                    .setLastName(lastNme)
                    .setEmail(userEmail)
                    .setGender("Female")
                    .setNumber("8996266848")
                    .setBirthDay("13", "March", "1993")
                    .setSubject("Maths")
                    .setCheckbox("Sports")
                    .uploadFile("src/test/resources/pictures/temp.png")
                    .setAddress("Address")
                    .setState("Uttar Pradesh")
                    .setstateCity("Agra")
                    .submitclick();
        });
        step("Verify result", () -> {
            registrationPage.verifiability();
            registrationPage.verifyValueTable("Student Name", userName + lastNme);
            registrationPage.verifyValueTable("Student Email", userEmail);
            registrationPage.verifyValueTable("Gender", "Female");
            registrationPage.verifyValueTable("Mobile", "8996266848");
            registrationPage.verifyValueTable("Date of Birth", "13 March,1993");
            registrationPage.verifyValueTable("Subjects", "Maths");
            registrationPage.verifyValueTable("Hobbies", "Sports");
            registrationPage.verifyValueTable("Picture", "temp.png");
            registrationPage.verifyValueTable("Address", "Address");
            registrationPage.verifyValueTable("State and City", "Uttar Pradesh Agra");
            registrationPage.closeModal();
        });
    }

}
