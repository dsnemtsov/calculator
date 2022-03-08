import org.junit.jupiter.api.Test;
import ru.yandex.dimas224.Expression;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ExpressionTest {
  private Expression expression;

  @Test
  void shouldThrowException_whenInputIsNull() {
    Exception e = assertThrows(NumberFormatException.class, () -> expression = new Expression(null));
    assertEquals("Wrong input data", e.getMessage());
  }

  @Test
  void shouldCalculate_whenInputIsInteger() {
    expression = new Expression("1 + 2");
    assertEquals("3", expression.calculate());
  }

  @Test
  void shouldCalculate_whenInputIsRoman() {
    expression = new Expression("VI / III");
    assertEquals("II", expression.calculate());
  }

  @Test
  void shouldThrowException_whenRomanResultBelowZero() {
    expression = new Expression("I - II");
    Exception e = assertThrows(NumberFormatException.class, () -> expression.calculate());
    assertEquals("Result is 0 or below", e.getMessage());
  }

  @Test
  void shouldThrowException_whenInputIsNotCorrect() {
    assertThrows(NumberFormatException.class, () -> expression = new Expression("I + 1"));
    assertThrows(NumberFormatException.class, () -> expression = new Expression("1"));
    assertThrows(NumberFormatException.class, () -> expression = new Expression("1 + 2 + 3"));
  }
}
