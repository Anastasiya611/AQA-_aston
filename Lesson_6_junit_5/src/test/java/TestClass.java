import org.example.Factorial;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestClass {
    @Test
    @Deprecated(since = " Проверка факторила числа n")
    public void test() {
        int actualResult = Factorial.factorial(5);
        Assert.assertEquals(actualResult,120, "Факториал не совпадает с ожидаемым значением");
    }
}
