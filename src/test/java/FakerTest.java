

import org.junit.jupiter.api.Test;
import pages.components.CheckFormResult;
import pages.components.RegistrationPage;
import tests.TestBase;
import utils.FakerUtils;

public class FakerTest extends TestBase {


    RegistrationPage registrationForm = new RegistrationPage();
    CheckFormResult checkFormResult = new CheckFormResult();
    FakerUtils fakerUtils = new FakerUtils();

    @Test
    void positiveAllRegistrationFormTest() {
        registrationForm.openPage()
                .setFirstName(fakerUtils.firstName)
                .setLastName(fakerUtils.lastName)
                .setUserEmail(fakerUtils.userEmail)
                .setGender(fakerUtils.genderUser)
                .setUserNumber(fakerUtils.userNumber)
                .setDateOFBirth(fakerUtils.Year, fakerUtils.Month, fakerUtils.Day)
                .setHobbies(fakerUtils.userHobbies)
                .setSubjects(fakerUtils.userSubjects)
                .setPicture(fakerUtils.userPicture)
                .setAddress(fakerUtils.streetAddress)
                .setState(fakerUtils.state)
                .setCity(fakerUtils.city)
                .clickSubmit();

        checkFormResult
                .checkTableValue("Student Name", fakerUtils.firstName + " " + fakerUtils.lastName)
                .checkTableValue("Student Email", fakerUtils.userEmail)
                .checkTableValue("Gender", fakerUtils.genderUser)
                .checkTableValue("Mobile", fakerUtils.userNumber)
                .checkTableValue("Date of Birth", fakerUtils.Day + " " + fakerUtils.Month + "," + fakerUtils.Year)
                .checkTableValue("Subjects", fakerUtils.userSubjects)
                .checkTableValue("Hobbies", fakerUtils.userHobbies)
                .checkTableValue("Picture", fakerUtils.userPicture)
                .checkTableValue("Address", fakerUtils.streetAddress)
                .checkTableValue("State and City", fakerUtils.state + " " + fakerUtils.city);

    }

    @Test
    void testWithRequiredFieldsPositive() {
        registrationForm.openPage()
                .setFirstName(fakerUtils.firstName)
                .setLastName(fakerUtils.lastName)
                .setUserEmail(fakerUtils.userEmail)
                .setGender(fakerUtils.genderUser)
                .setUserNumber(fakerUtils.userNumber)
                .clickSubmit();

        checkFormResult
                .checkTableValue("Student Name", fakerUtils.firstName + " " + fakerUtils.lastName)
                .checkTableValue("Student Email", fakerUtils.userEmail)
                .checkTableValue("Gender", fakerUtils.genderUser)
                .checkTableValue("Mobile", fakerUtils.userNumber);


    }

    @Test
    void testNegativeRegistration() {
        registrationForm.openPage()
                .setFirstName(fakerUtils.firstName)
                .setUserNumber(fakerUtils.userEmail)
                .setGender(fakerUtils.genderUser)
                .clickSubmit();

        registrationForm.checkResultNegative();
    }


}


