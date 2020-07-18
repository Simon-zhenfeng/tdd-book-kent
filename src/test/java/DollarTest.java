import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

/**
 * @author Simon
 * @date 2020/7/18 16:43
 */
public class DollarTest {
    @Test
    public void test_multiplication() {
        Money five = Money.dollar(5);
        assertEquals(Money.dollar(10), five.times(2));
        assertThat(five.times(3)).isEqualTo(Money.dollar(15));
    }

    @Test
    public void test_equally() {
        assertThat(Money.dollar(5)).isEqualTo(Money.dollar(5));
        assertThat(Money.dollar(5)).isNotEqualTo(Money.dollar(6));
    }
}
