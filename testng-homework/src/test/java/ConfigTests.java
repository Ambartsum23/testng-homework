import static com.codeborne.selenide.Configuration.*;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeSuite;

public class ConfigTests {
    @BeforeSuite
    public static void configMethod(){
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("start-maximized");
        browserCapabilities = chromeOptions;
        browserSize = "1200x900";
        screenshots = true;
        savePageSource = false;
        timeout = 25000;
    }

}