import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

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


    @Test
    public void test_multiplication_franc() {
        Money five = Money.franc(5);
        assertEquals(Money.franc(10), five.times(2));
        assertThat(five.times(3)).isEqualTo(Money.franc(15));
    }

    @Test
    public void test_equally_franc() {
        assertThat(Money.franc(5)).isEqualTo(Money.franc(5));
        assertThat(Money.franc(5)).isNotEqualTo(Money.franc(6));
    }
    @Test
    public void test_multiplication_dollar() {
        Money five = Money.dollar(5);
        assertEquals(Money.dollar(10), five.times(2));
        assertThat(five.times(3)).isEqualTo(Money.dollar(15));
    }

    @Test
    public void test_equally_dollar() {
        assertThat(Money.dollar(5)).isEqualTo(Money.dollar(5));
        assertThat(Money.dollar(5)).isNotEqualTo(Money.dollar(6));
    }

    @Test
    public void test_simple_addition() {
        Expression sum = Money.dollar(5).plus(Money.dollar(5));
        Bank bank = new Bank();
        Money reduced = bank.reduce(sum, "USD");
        assertThat(reduced).isEqualTo(Money.dollar(10));
    }

    @Test
    public void test_plus_returns_sum() {
        Money five = Money.dollar(5);
        Expression result = five.plus(five);
        Sum sum = (Sum) result;
        assertThat(sum.augend).isEqualTo(five);
        assertThat(sum.addend).isEqualTo(five);
    }

    @Test
    public void test_reduce_sum() {
        Sum sum = new Sum(Money.dollar(3), Money.dollar(5));
        Bank bank = new Bank();
        Money result = bank.reduce(sum, "USD");
        assertThat(result).isEqualTo(Money.dollar(8));
    }

    @Test
    public void test_reduce_money() {
        Bank bank = new Bank();
        Money result = bank.reduce(Money.dollar(1), "USD");
        assertThat(result).isEqualTo(Money.dollar(1));
    }

    @Test
    public void test_reduce_money_different_currency() {
        Bank bank = new Bank();
        bank.addRete("CHF", "USD", 2);
        Money result = bank.reduce(Money.franc(2), "USD");
        assertThat(result).isEqualTo(Money.dollar(1));
    }

    @Test
    public void test_mixed_addition() {
        Expression fiveDollar = Money.dollar(5);
        Expression tenFranc = Money.franc(10);
        Bank bank = new Bank();
        bank.addRete("CHF", "USD", 2);
        Money result = bank.reduce(fiveDollar.plus(tenFranc), "USD");
        assertThat(result).isEqualTo(Money.dollar(10));
    }

    @Test
    public void test_sum_plus_money() {
        Expression fiveDollar = Money.dollar(5);
        Expression tenFranc = Money.franc(10);
        Bank bank = new Bank();
        bank.addRete("CHF", "USD", 2);
        Expression sum = new Sum(fiveDollar, tenFranc).plus(fiveDollar);
        Money result = bank.reduce(sum, "USD");
        assertThat(result).isEqualTo(Money.dollar(15));
    }

    @Test
    public void test_sum_times() {
        Expression fiveDollar = Money.dollar(5);
        Expression tenFranc = Money.franc(10);
        Bank bank = new Bank();
        bank.addRete("CHF", "USD", 2);
        Expression sum = new Sum(fiveDollar, tenFranc).times(2);
        Money result = bank.reduce(sum, "USD");
        assertThat(result).isEqualTo(Money.dollar(20));
    }
}
