package listeners; // Ensure this package matches your structure

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

public class AnnotationTransformer implements IAnnotationTransformer {

    @Override
    public void transform(ITestAnnotation annotation, Class testClass,
                          Constructor testConstructor, Method testMethod) {
        // Set the RetryAnalyzer class for every @Test annotation found
        annotation.setRetryAnalyzer(RetryAnalyzer.class);
    }
}