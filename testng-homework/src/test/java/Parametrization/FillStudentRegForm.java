package Parametrization;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.asserts.SoftAssert;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;


public class FillStudentRegForm {
    private final String firstName;
    private final String lastName;
    private final String gender;
    private final String phoneNumber;
    SoftAssert Assert = new SoftAssert();

    public FillStudentRegForm(String firstName, String lastName, String gender, String phoneNumber) {
        this.firstName=firstName;
        this.lastName=lastName;
        this.gender=gender;
        this.phoneNumber=phoneNumber;

    }
    @Test
    public void fillStudentRegistrationForm() {
        open("https://demoqa.com/automation-practice-form");
        $("#firstName").sendKeys(firstName);
        $("#lastName").sendKeys(lastName);
        $x("//label[text()='"+gender+"']").click();
        $("#userNumber").sendKeys(phoneNumber);
        String UserName = firstName+" "+lastName;
       $("#submit").scrollIntoView(true);
        $("#submit").click();
        sleep(3000);
        // - Validate the Student Name value dynamically
        $x("//table//tr/td[text()='Student Name']/following-sibling::td").shouldHave(text(UserName));
     // String username = $x("//table//tr/td[text()='Student Name']/following-sibling::td");
       // username.getText().toString();
      //  Assert.assertEquals(UserName, username);


        //qveot werili kodistvis axar unda submitis dajera
      /* if (( $("#firstName").getValue()).equals(firstName)){
            System.out.println("Student name is right");
        }
        else {   System.out.println("Student name is right");

        }*/

    }
}