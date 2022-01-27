package Parametrization;
import org.testng.annotations.Test;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;
public class FillStudentRegFormDataProvider {
    @Test(dataProvider = "data", dataProviderClass = DataProviderRegisterForm.class)
    public void fillStudentRegistrationFormWithDP(String fN, String lN, String gender, String uN) {
        open("https://demoqa.com/automation-practice-form");
        $("#firstName").sendKeys(fN);
        $("#lastName").sendKeys(lN);
        $x("//label[text()='"+gender+"']").click();
        $("#userNumber").sendKeys(uN);
    }
}
