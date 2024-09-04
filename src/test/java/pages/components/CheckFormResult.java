
package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class CheckFormResult {
    public void getResultTable(String studentName, String studentEmail, String gender, String mobile, String dateOfBirth,
                               String subjects, String hobbies, String picture,
                               String address, String stateAndCity) {
        $(".table-responsive").$(byText("Student Name")).parent().shouldHave(text(studentName));
        $(".table-responsive").$(byText("Student Email")).parent().shouldHave(text(studentEmail));
        $(".table-responsive").$(byText("Gender")).parent().shouldHave(text(gender));
        $(".table-responsive").$(byText("Mobile")).parent().shouldHave(text(mobile));
        $(".table-responsive").$(byText("Date of Birth")).parent().shouldHave(text(dateOfBirth));
        $(".table-responsive").$(byText("Subjects")).parent().shouldHave(text(subjects));
        $(".table-responsive").$(byText("Hobbies")).parent().shouldHave(text(hobbies));
        $(".table-responsive").$(byText("Picture")).parent().shouldHave(text(picture));
        $(".table-responsive").$(byText("Address")).parent().shouldHave(text(address));
        $(".table-responsive").$(byText("State and City")).parent().shouldHave(text(stateAndCity));
    }

    public CheckFormResult checkHeader() {
        resultWindowHeader
                .shouldBe(visible)
                .shouldHave(text("Thanks for submitting the form"));
        return this;
    }

    private final SelenideElement resultWindow = $(".modal-dialog"),
            resultWindowHeader = resultWindow.$("#example-modal-sizes-title-lg"),
            resultTable = resultWindow.$(".table-responsive");

    public CheckFormResult checkTableValue(String key, String value) {
        resultTable
                .$(byText(key))
                .parent()
                .shouldHave(text(value));
        return this;
    }

    public CheckFormResult notAppear() {
        resultWindow.shouldNot(appear);
        return this;
    }

    public CheckFormResult appear() {
        resultWindow.should(appear);
        return this;
    }


}
