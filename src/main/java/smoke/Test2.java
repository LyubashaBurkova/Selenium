package smoke;

import org.testng.Assert;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import org.testng.annotations.Test;

public class Test2 {
    //@Test (groups = {"smokeTest", "regress"})
    @Test (retryAnalyzer = Retry.class)
    public void test2 () {
        System.out.println("Test 2");
        Assert.fail();
    }
}

