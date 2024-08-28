package tests;

import org.junit.jupiter.api.Test;
import pages.components.RegistrationPage;


public class TestPageObject extends TestBase{
    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void PositiveForAllRegistrationTest() {
        registrationPage.openPage()
                .firstName("Andrew")
                .lastName("Olkhovskii")
                .email("test@test.test")
                .userNumber("8999777654")
                .userGender("Male")
                .dateOfBirth("17", "August", "1990")
                .userAdress("Russia")
                .userHobbies("Sports")
                .userSubjects("Commerce")
                .userState("NCR" )
                .userCity("Noida")
                .upLoadUserPicture("1.png");
        registrationPage.clickSubmit();

        registrationPage.checkFormResult(
                "Andrew Olkhovskii",
                "test@test.test",
                "Male",
                "8999777654",
                "17 August,1990",
                "Commerce",
                "Sports",
                "1.png",
                "Russia",
                "NCR Noida");

    }

    @Test
    void WithRequiredFieldsTest(){
        registrationPage.openPage();

        registrationPage.firstName("Andrew")
                .lastName("Olkhovskii")
                .userGender("Male")
                .userNumber("8999777654")
                .dateOfBirth("17", "August", "1990");
        registrationPage.clickSubmit();

        registrationPage.checkOneResult("Student Name", "Andrew Olkhovskii")
                .checkOneResult("Gender", "Male")
                .checkOneResult("Mobile", "8999777654")
                .checkOneResult("Date of Birth", "17 August,1990");
    }

    @Test
    void NegativeTest(){
        registrationPage.openPage();

        registrationPage.firstName("Andrew")
                .email("test@test.test")
                .userAdress("tst")
                .userState("NCR")
                .userCity("Noida");

        registrationPage.clickSubmit();

        registrationPage.checkResultNegative();
    }



}



