/**
 * @author Simon
 * @date 2020/7/18 16:45
 */
public class Dollar extends Money {

    public Dollar(int amount, String currency) {
        super(amount, currency);
    }

    @Override
    public Money times(int multiplier) {
        return Money.dollar(amount * multiplier);
    }

}
