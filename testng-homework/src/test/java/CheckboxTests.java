import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.testng.ScreenShooter;
import com.codeborne.selenide.testng.SoftAsserts;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Configuration.reportsFolder;
import org.testng.annotations.Test;
import org.testng.annotations.Listeners;
import static com.codeborne.selenide.Selenide.open;


@Listeners({ SoftAsserts.class, ScreenShooter.class})
public class CheckboxTests extends ConfigTests{
    SoftAssert soft = new SoftAssert();

    public CheckboxTests() {
        reportsFolder = "src/main/resources/CheckboxFailedTests";
    }

   @BeforeTest
    public void beforeTest(){
        System.out.println("checkbox test");
    }

    @Test(description = "uncheck checked checkbox", groups = {"FrontEnd"})
    public void uncheck() {
        open("http://the-internet.herokuapp.com/checkboxes");
        SelenideElement secondCheck = $("#checkboxes").$("input", 0);
        secondCheck.click();
        soft.assertTrue(secondCheck.isSelected());
        soft.assertAll();
    }

    @Test(description = "check unchecked checkbox", dependsOnMethods = "uncheck", alwaysRun = true, groups = {"BackEnd"})
    public void check() {
        open("http://the-internet.herokuapp.com/checkboxes");

        SelenideElement firstCheck = $("#checkboxes").$("input", 1);
        firstCheck.click();
        soft.assertFalse(firstCheck.isSelected());
        soft.assertAll();
    }

}

