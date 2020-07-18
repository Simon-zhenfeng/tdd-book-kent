/**
 * @author Simon
 * @date 2020/7/18 16:45
 */
public class Dollar extends Money {

    public Dollar(int amount) {
        this.amount = amount;
        currency = "USD";
    }
    
    @Override
    public Money times(int multiplier) {
        return new Dollar(amount * multiplier);
    }

}
