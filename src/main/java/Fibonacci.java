/**
 * @author Simon
 * @date 2020/7/22 12:45
 */
public class Fibonacci {
    public static int fib(int n) {
        if (n == 0) {
            return 0;
        }
        if (n <= 2) {
            return 1;
        }
        return fib(n - 1) + fib(n - 2);
    }
}
