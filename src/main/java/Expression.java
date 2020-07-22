public interface Expression {
    Money reduce(Bank bank, String to);

    Expression plus(Expression tenFranc);

    Expression times(int multiplier);
}
