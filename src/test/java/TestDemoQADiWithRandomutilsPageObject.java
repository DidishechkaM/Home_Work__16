
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static randomUtils.RandomUtils.getRandomEmail;
import static randomUtils.RandomUtils.getRandomString;
@Tag("random")
public class TestDemoQADiWithRandomutilsPageObject extends TestBase {
    String userName = getRandomString(10),
            lastNme = getRandomString(10),
            userEmail = getRandomEmail();
    @Test
    void fillTest() {

        registrationPage.openPage()
                .executeJS()
                .setFirsName(userName)
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
        registrationPage.verifiability();
        registrationPage.verifyValueTable("Student Name", userName + " " + lastNme);
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

    }

}
