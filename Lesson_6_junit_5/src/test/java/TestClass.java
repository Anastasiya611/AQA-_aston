import org.example.Factorial;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestClass {
    @Test
    @DisplayName(" Проверка факторила числа n")
    public void test () {
    int actualResult = Factorial.factorial(5);
        assertEquals(120,actualResult);
    }


}
