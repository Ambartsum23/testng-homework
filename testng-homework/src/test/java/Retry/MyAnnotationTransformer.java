package Retry;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.jetbrains.annotations.NotNull;
import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;


public class MyAnnotationTransformer implements IAnnotationTransformer {

    @Override
    public void transform(@NotNull ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod)
    {
        annotation.setRetryAnalyzer(RetryAnalyzer.class);
    }
}

