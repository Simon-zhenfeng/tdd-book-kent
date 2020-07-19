/**
 * @author Simon
 * @date 2020/7/18 18:13
 */
public abstract class Money {
    protected int amount;
    protected String currency;

    public Money(int amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }

    public static Dollar dollar(int amount) {
        return new Dollar(amount, "USD");
    }

    public static Money franc(int amount) {
        return new Franc(amount, "CHF");
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        Money other = (Money) obj;
        return this.amount == other.amount && getClass().equals(other.getClass());
    }

    public abstract Money times(int multiplier);

    public String currency() {
        return currency;
    }
}
