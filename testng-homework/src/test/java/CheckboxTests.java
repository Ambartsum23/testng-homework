import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.testng.ScreenShooter;
import com.codeborne.selenide.testng.SoftAsserts;
import org.jetbrains.annotations.NotNull;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import static com.codeborne.selenide.Selenide.*;

@Listeners({ SoftAsserts.class, ScreenShooter.class})
public class CheckboxTests {
    @BeforeClass
    public void befclass(){
        ConfigTests config = new ConfigTests();
        config.configMethod();
        config.checkboxurl();
        config.screenshotcheckbox();
    }
    @BeforeTest
    public void beforeTest(){
        System.out.println("before Test1");
    }
    @Test
    public void assertcheckbox(){
        SoftAssert softAssert = new SoftAssert();
        open("/checkboxes");
        ElementsCollection checkbox = $$("input[type=checkbox]");
        uncheck(checkbox);
        softAssert.assertEquals($("input[type=checkbox]").getAttribute("checked"),"True", "failed assertion, is boxes checked?");
        checkunchecked(checkbox);
        softAssert.assertEquals($("input[type=checkbox]").getAttribute("checked"),null, "failed assertion, is boxes unchecked?");
        softAssert.assertAll();
    }
    public void uncheck(@NotNull ElementsCollection checkboxes){
        for (SelenideElement chckbox:checkboxes){
            chckbox.setSelected(false);
        }
    }
    public void checkunchecked(@NotNull ElementsCollection checkboxes){
        for (SelenideElement chckbox:checkboxes){
            chckbox.setSelected(true);
        }
    }
    @AfterMethod
    public void close(){
        closeWindow();
    }
}
