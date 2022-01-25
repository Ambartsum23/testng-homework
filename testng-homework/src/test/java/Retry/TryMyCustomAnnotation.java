package Retry;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

@Test
public class TryMyCustomAnnotation {

    SoftAssert softAssert = new SoftAssert();
    int failTestCounter = 0;
    private static final int maxRetryCount = 6;

    //Create one test method that should fail 5 times and Use your annotation with parameter 10
    @MyRetryAnnotation(10)
    @Test(groups = {"FrontEnd"})
    public void TryMyCustomAnnotation() {
        if(failTestCounter < maxRetryCount) {
            softAssert.fail();
            failTestCounter++;
            softAssert.assertAll();
        }
    }
}