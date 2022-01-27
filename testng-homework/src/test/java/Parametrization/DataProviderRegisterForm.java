package Parametrization;
import org.testng.annotations.DataProvider;

public class DataProviderRegisterForm {

    @DataProvider(name = "data")
    public static Object[][] createData() {
        return new Object[][] {
                {"firstName1","lastName1","Male","1234567"},
                {"firstName2","lastName2","Female","2345678"},
                {"firstName3","lastName3","Other","3456789"},
        };
    }
}