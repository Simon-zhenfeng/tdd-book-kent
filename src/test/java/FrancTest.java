import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

/**
 * @author Simon
 * @date 2020/7/18 18:03
 */
public class FrancTest {

    @Test
    public void test_multiplication() {
        Money five = Money.franc(5);
        assertEquals(Money.franc(10), five.times(2));
        assertThat(five.times(3)).isEqualTo(Money.franc(15));
    }

    @Test
    public void test_equally() {
        assertThat(Money.franc(5)).isEqualTo(Money.franc(5));
        assertThat(Money.franc(5)).isNotEqualTo(Money.franc(6));
    }
}
