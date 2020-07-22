import java.util.HashMap;
import java.util.Map;

/**
 * @author Simon
 * @date 2020/7/19 17:40
 */
public class Bank {
    private final Map<Pair, Integer> rates = new HashMap<>();
    public Money reduce(Expression expression, String to) {
        return expression.reduce(this, to);
    }

    public void addRete(String from, String to, int rate) {
        rates.put(new Pair(from, to), rate);
    }

    public int rate(String from, String to) {
        if (from.equals(to)) {
            return 1;
        }
        return rates.get(new Pair(from, to));
    }
}
