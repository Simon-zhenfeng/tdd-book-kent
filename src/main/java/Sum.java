/**
 * @author Simon
 * @date 2020/7/19 18:15
 */
public class Sum implements Expression {
    public Expression augend;
    public Expression addend;

    public Sum(Expression augend, Expression added) {
        this.augend = augend;
        this.addend = added;
    }

    @Override
    public Money reduce(Bank bank, String to) {
        int amount = addend.reduce(bank, to).amount +
                augend.reduce(bank, to).amount;
        return new Money(amount, to);
    }

    @Override
    public Expression plus(Expression addend) {
        return new Sum(this, addend);
    }

    @Override
    public Expression times(int multiplier) {
        return new Sum(augend.times(multiplier), addend.times(multiplier));
    }
}
