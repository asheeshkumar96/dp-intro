
/**
 *  Compute the nth fibonacci number iteratively  with  constant
 *  space. We only need to save the most two recently computed values
 * @author anurag
 *
 */
public class FibonacciBottomUpOptimized {
	
	/**
	 * Optimized bottom up dynamic solution fibonacci
	 * @param n
	 * @return
	 */
	public int fib(int n) {
		if(n < 2) return n;
		int n1 = 1, n2 = 0;
		for(int i = 2; i < n; i++) {
			int n0 = n1  + n2;
			n2 = n1; 
			n1 = n0;
		}
		
		return n1 + n2;
	}

	public static void main(String[] args) {
		FibonacciBottomUpOptimized fibBotOpt = new FibonacciBottomUpOptimized();
		System.out.println("fib(5)=" + fibBotOpt.fib(5));
		System.out.println("fib(10)=" + fibBotOpt.fib(10));

	}
}
