package pages.components;
import com.codeborne.selenide.SelenideElement;
import pages.components.Calendar;
import pages.components.CheckFormResult;

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

    public RegistrationPage firstName(String value) {
        firstName.setValue(value);

        return this;
    }

    public RegistrationPage lastName(String value) {
        lastName.setValue(value);

        return this;
    }

    public RegistrationPage email(String value) {
        userEmail.setValue(value);

        return this;
    }

    public RegistrationPage userGender(String value) {
        gender.$(byText(value)).click();

        return this;
    }

    public RegistrationPage userNumber(String value) {
        number.setValue(value);
        return this;
    }
    public RegistrationPage dateOfBirth(String day, String month, String year) {
        dateBirthInput.click();
        calendar.setDate(day, month, year);
        return this;
    }

    public RegistrationPage userSubjects(String value) {
        subjects.setValue(value).pressEnter();
        return this;
    }
    public RegistrationPage userHobbies(String value) {
        hobbies.$(byText(value)).click();
        return this;
    }
    public RegistrationPage upLoadUserPicture(String value) {
        picture.uploadFromClasspath(value);
        return this;
    }
    public RegistrationPage userAdress(String value) {
        address.setValue(value).pressEnter();
        return this;
    }
    public RegistrationPage userState(String value) {
        state.click();
        state.$(byText(value)).click();
        return this;
    }
    public RegistrationPage userCity(String value) {
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

    public RegistrationPage checkOneResult(String key, String value) {
        checkOneResult.$(byText(key)).parent().shouldHave(text(value));
        return this;
    }

}
