package pages.components;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class RegistrationPage {
    Calendar calendar = new Calendar();

    public final SelenideElement
            firstName = $("#firstName"),
            lastName = $("#lastName"),
            userEmail = $("#userEmail"),
            gender = $("#genterWrapper"),
            number = $("#userNumber"),
            dateBirthInput = $("#dateOfBirthInput"),
            subjects = $("#subjectsInput"),
            hobbies = $("#hobbiesWrapper"),
            picture = $("#uploadPicture"),
            address = $("#currentAddress"),
            state = $("#state"),
            city = $("#city"),
            submit = $("#submit"),
            checkError = $("#app"),
            checkOneResult = $(".table-responsive");

    public RegistrationPage openPage() {
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        return this;
    }

    public RegistrationPage setFirstName(String value) {
        firstName.setValue(value);

        return this;
    }

    public RegistrationPage setLastName(String value) {
        lastName.setValue(value);

        return this;
    }

    public RegistrationPage setUserEmail(String value) {
        userEmail.setValue(value);

        return this;
    }

    public RegistrationPage setGender(String value) {
        gender.$(byText(value)).click();

        return this;
    }

    public RegistrationPage setUserNumber(String value) {
        number.setValue(value);
        return this;
    }
    public RegistrationPage setDateOFBirth(String day, String month, String year) {
        dateBirthInput.click();
        calendar.setDate(day, month, year);
        return this;
    }

    public RegistrationPage setSubjects(String value) {
        subjects.setValue(value).pressEnter();
        return this;
    }
    public RegistrationPage setHobbies(String value) {
        hobbies.$(byText(value)).click();
        return this;
    }
    public RegistrationPage setPicture(String value) {
        picture.uploadFromClasspath(value);
        return this;
    }
    public RegistrationPage setAddress(String value) {
        address.setValue(value).pressEnter();
        return this;
    }
    public RegistrationPage setState(String value) {
        state.click();
        state.$(byText(value)).click();
        return this;
    }
    public RegistrationPage setCity(String value) {
        city.click();
        city.$(byText(value)).click();
        return this;
    }
    public RegistrationPage clickSubmit() {
        submit.click();
        return this;
    }

    CheckFormResult checkFormResult = new CheckFormResult();

    public void checkFormResult(String studentName, String studentEmail, String gender, String mobile,
                                String dateOfBirth, String subjects, String hobbies, String picture,
                                String address, String stateAndCity) {
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        checkFormResult.getResultTable(studentName, studentEmail, gender, mobile, dateOfBirth, subjects,
                hobbies, picture, address, stateAndCity);
    }

    public RegistrationPage checkResultNegative() {
        checkError.shouldNotHave((text("Thanks for submitting the form")));
        return this;
    }


}
