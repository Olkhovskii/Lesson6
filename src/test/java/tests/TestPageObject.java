package tests;

import org.junit.jupiter.api.Test;
import pages.components.RegistrationPage;


public class TestPageObject extends TestBase{
    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void PositiveForAllRegistrationTest() {
        registrationPage.openPage()
                .setFirstName("Andrew")
                .setLastName("Olkhovskii")
                .setUserEmail("test@test.test")
                .setUserNumber("8999777654")
                .setGender("Male")
                .setDateOFBirth("17", "August", "1990")
                .setAddress("Russia")
                .setHobbies("Sports")
                .setSubjects("Commerce")
                .setState("NCR" )
                .setCity("Noida")
                .setPicture("1.png");
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

        registrationPage.setFirstName("Andrew")
                .setLastName("Olkhovskii")
                .setGender("Male")
                .setUserNumber("8999777654")
                .setDateOFBirth("17", "August", "1990");
        registrationPage.clickSubmit();


    }

    @Test
    void NegativeTest(){
        registrationPage.openPage();

        registrationPage.setFirstName("Andrew")
                .setUserEmail("test@test.test")
                .setAddress("tst")
                .setState("NCR")
                .setCity("Noida");

        registrationPage.clickSubmit();

        registrationPage.checkResultNegative();
    }



}



