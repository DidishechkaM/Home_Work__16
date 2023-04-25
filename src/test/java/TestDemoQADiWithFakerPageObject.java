
import com.github.javafaker.Faker;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import static randomUtils.RandomUtils.*;
import static randomUtils.TestData.*;
@Disabled("Late")
public class TestDemoQADiWithFakerPageObject extends TestBase {


        @Test
        void fillTest() {

            Faker faker =  new Faker();

            String userName = faker.name().firstName();
            String lastNme = faker.name().lastName();
            String userEmail = faker.internet().emailAddress();
            String userGender = getRandomItemFromArray(genders);
            String number = "8"+ faker.number().randomNumber(9, true);
            String dayOfBirth = String.valueOf(faker. number().numberBetween(1, 28));
            String monthBirth = getRandomItemFromArray(months);
            String yearBirth = String.valueOf(faker.number().numberBetween(1950, 2005));
            String subject = getRandomItemFromArray(subjects);
            String checkboxHobbies = getRandomItemFromArray(hobbies);
            String pictureName = "src/test/resources/pictures/temp.png";
            String currentAddress = faker.address().fullAddress();
            String userState ="NCR";
            String userCity =getRandomItemFromArray(cities);

            registrationPage.openPage()
                    .executeJS()
                    .setFirsName(userName)
                    .setLastName(lastNme)
                    .setEmail(userEmail)
                    .setGender(userGender)
                    .setNumber(number)
                    .setBirthDay(dayOfBirth, monthBirth,yearBirth)
                    .setSubject(subject)
                    .setCheckbox(checkboxHobbies)
                    .uploadFile(pictureName)
                    .setAddress(currentAddress)
                    .setState(userState)
                    .setstateCity(userCity)
                    .submitclick();
            registrationPage.verifiability();
            registrationPage.verifyValueTable("Student Name", userName + " " + lastNme);
            registrationPage.verifyValueTable("Student Email", userEmail);
            registrationPage.verifyValueTable("Gender", userGender);
            registrationPage.verifyValueTable("Mobile", number);
            registrationPage.verifyValueTable("Date of Birth",dayOfBirth+ " " +monthBirth+ "," +yearBirth);
            registrationPage.verifyValueTable("Subjects", subject);
            registrationPage.verifyValueTable("Hobbies", checkboxHobbies);
            registrationPage.verifyValueTable("Picture", "temp.png");
            registrationPage.verifyValueTable("Address", currentAddress);
            registrationPage.verifyValueTable("State and City",userState + " " + userCity );
            registrationPage.closeModal();
        }
    }


