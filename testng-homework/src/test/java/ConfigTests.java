import static com.codeborne.selenide.Configuration.*;
import org.openqa.selenium.chrome.ChromeOptions;

public class ConfigTests {
    public static void configMethod(){
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("start-maximized");
        browserCapabilities = chromeOptions;
        browserSize = "1200x900";
        screenshots = true;
        savePageSource = false;
        timeout = 30000;
    }
    public static void checkboxurl(){
        baseUrl = "http://the-internet.herokuapp.com";
    }
    public static void screenshotcheckbox(){
        reportsFolder="src/main/resources/CheckboxFailedTests";
    }
    public static void radiobuttonurl(){
        baseUrl = "https://demoqa.com";
    }
    public static void screenshotRadiobutton(){
        reportsFolder="src/main/resources/RadioButtonFailedTests";
    }
}