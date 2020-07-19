import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Simon
 * @date 2020/7/18 18:23
 */
public class MoneyTest {
    @Test
    public void test_equality() {
        assertThat(Money.dollar(6)).isNotEqualTo(Money.franc(6));
        assertThat(Money.dollar(5)).isNotEqualTo(Money.franc(6));
    }

    @Test
    public void test_currency() {
        assertThat(Money.dollar(1).currency()).isEqualTo("USD");
        assertThat(Money.franc(1).currency()).isEqualTo("CHF");
    }
}
