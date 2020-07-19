/**
 * @author Simon
 * @date 2020/7/18 18:04
 */
public class Franc extends Money {

    public Franc(int amount, String currency) {
        super(amount, currency);
    }

    @Override
    public Money times(int multiplier) {
        return Money.franc(amount * multiplier);
    }

}
