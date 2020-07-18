/**
 * @author Simon
 * @date 2020/7/18 18:04
 */
public class Franc extends Money {

    public Franc(int amount) {
        this.amount = amount;
        currency = "CHF";
    }

    @Override
    public Money times(int multiplier) {
        return new Franc(amount * multiplier);
    }

}
