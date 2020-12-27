
public class FibonacciNaive {
	
	/**
	 * Compute the nth fibonacci number 
	 * We assume that n >= 0 and int is sufficient to hold the result
	 * @param n the nth fibonacci number
	 * @return the nth fibonacci number
	 */
	public int fib(int n) {
		if(n == 0) return 0;
		if(n == 1) return 1;
		return fib(n - 1)  + fib(n -2);
	}

	public static void main(String[] args) {
		FibonacciNaive fibNaive = new FibonacciNaive();
		System.out.println("fib(5)=" + fibNaive.fib(5));
		System.out.println("fib(10)=" + fibNaive.fib(10));
	}
}
