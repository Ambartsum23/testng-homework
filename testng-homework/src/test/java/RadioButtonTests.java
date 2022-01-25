import com.codeborne.selenide.testng.ScreenShooter;
import com.codeborne.selenide.testng.SoftAsserts;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import static com.codeborne.selenide.Configuration.reportsFolder;
import static com.codeborne.selenide.Selenide.*;
import org.testng.annotations.Test;
import org.testng.annotations.Listeners;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.WebDriverRunner.closeWebDriver;
import com.codeborne.selenide.SelenideElement;


@Listeners({ SoftAsserts.class, ScreenShooter.class})
public class RadioButtonTests extends ConfigTests{
    SoftAssert soft = new SoftAssert();
    public RadioButtonTests(){
        reportsFolder="src/main/resources/RadioButtonFailedTests";
    }
    @BeforeTest
    public void beforeTest(){
        System.out.println("checkbox test");
    }
    @Test(description = "check if no option is available", groups = {"FrontEnd"})
    public void checkIfDisabled() {
        SoftAssert soft = new SoftAssert();
        open("https://demoqa.com/radio-button");
        SelenideElement noRadio = $(withText("No"));
        soft.assertFalse(noRadio.isEnabled());
        soft.assertAll();
    }
   @Test(description = "select yes option", groups = {"BackEnd"})
    public void selectYes() {
        open("https://demoqa.com/radio-button");
        SelenideElement yesRadio = $(withText("Yes"));;
        yesRadio.click();
        soft.assertFalse(yesRadio.isSelected());
        soft.assertAll();
    }


    @AfterTest
    public void afterRadioButtonTests() {
        closeWebDriver();
    }
}