package smoke;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Test1 {
    //можем забирать данные в тесте от провайдера
    @DataProvider(name = "db")
        //при работе с провайдером данные передаем через метед
        //метод должен быть статичный
        //массив из объектов
        public static Object[][] dbDate () {
        return new Object[][] {
                {"SQL", new Integer(1)},
                {"NOSQL", new Integer(2)}
        };
    }


    //@Test анотация для метода
    //пусть первый тест будет относится к группе тестов (двум группам)
    //это удабно, т.к. можем запускать отдельные группы
    @Parameters({"db"})
    @Test (dataProvider = "db")
    //@Test (groups = {"smokeTest", "regress"})
    public void test1 (String db, int e2) {
        System.out.println("Test 1" + db + " " + e2);
    }

    //передаем метод, от которого будет зависеть данный метод
    //теперь перед выполнением 11 выполнится 1
    //по умолчанию жесткая зависимость (если 1 не выполнится, то 11 не запустится)
    //если передаем alwaysRun = true, то 11 запустится не зависимо от того выполнится 1 или нет
    //@Test (dependsOnMethods = {"test1"}, alwaysRun = true)
    //если хотим быть зависимы от группы, то dependsOnGroups
    //* все тесты этой группы
    @Test (dependsOnGroups = {"smokeTest.*"}, alwaysRun = true)
    //@Test (groups = {"regress"})
    public void test11 () {
        System.out.println("Test 11");
    }

    @Test (groups = {"regress"})
    public void test111 () {
        System.out.println("Test 111");
    }
}
