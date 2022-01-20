import com.codeborne.selenide.Condition;
import com.codeborne.selenide.testng.ScreenShooter;
import com.codeborne.selenide.testng.SoftAsserts;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import static com.codeborne.selenide.Selenide.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.Listeners;
import static com.codeborne.selenide.Selenide.open;

@Listeners({ SoftAsserts.class, ScreenShooter.class})
public class RadioButtonTests {
    @BeforeClass
    public void befclass(){
        ConfigTests config = new ConfigTests();
        config.configMethod();
        config.radiobuttonurl();
        config.screenshotRadiobutton();
    }
    @BeforeTest
    public void beforeTest(){
        System.out.println("beforetest");
    }
    @Test
    public void assertradiobutton(){
        SoftAssert softAssert = new SoftAssert();
        open("/radio-button");
        doubleclick();
        softAssert.assertFalse( $("#yesRadio").isSelected());
        check();
        softAssert.assertAll();
    }
    public void check(){
        $("#noRadio").shouldBe(Condition.disabled);
    }
    public void doubleclick(){
        $("#yesRadio").doubleClick();
    }
    @AfterMethod
    public void close(){
        closeWindow();

    }
}