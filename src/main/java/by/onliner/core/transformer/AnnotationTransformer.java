package by.onliner.core.transformer;

import by.onliner.core.anotation.TestType;
import org.apache.commons.lang3.ArrayUtils;
import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/***
 * IAnnotationTransformer is a TestNG listener which allows you to modify TestNG annotations
 * and configure them further during runtime.
 */
public class AnnotationTransformer implements IAnnotationTransformer {

    /***
     * Transform method is called for every test during the test run.
     */
    @Override
    public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
        String[] groups = {};
        annotation.setRetryAnalyzer(RetryAnalyzer.class);
        if (testMethod.isAnnotationPresent(TestType.class)){
            groups = testMethod.getAnnotation(TestType.class).value();
        }
        annotation.setGroups(ArrayUtils.addAll(groups));
    }
}
