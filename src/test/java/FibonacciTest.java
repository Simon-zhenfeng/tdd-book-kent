import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Simon
 * @date 2020/7/22 12:42
 */
public class FibonacciTest {
    @Test
    public void testFibonacci() {
        int[][] cases = {
                {0, 0},
                {1, 1},
                {2, 1},
                {3, 2},
                {4, 3}
        };
        for (int[] aCase : cases) {
            assertThat(Fibonacci.fib(aCase[0])).isEqualTo(aCase[1]);
        }
    }
}
