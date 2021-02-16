package smoke;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Test1 {
    //@Test анотация для метода
    //пусть первый тест будет относится к группе тестов (двум группам)
    //это удабно, т.к. можем запускать отдельные группы
    @Parameters({"db"})
    @Test (groups = {"smokeTest", "regress"})
    public void test1 (String db) {
        System.out.println("Test 1" + db);
    }

    @Test (groups = {"regress"})
    public void test11 () {
        System.out.println("Test 11");
    }

    @Test (groups = {"regress"})
    public void test111 () {
        System.out.println("Test 111");
    }
}
