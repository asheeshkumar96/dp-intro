
// Compute the nth fibonacci number iteratively 
public class FibonacciBottomUp {

	public int fib(int n) {
		if(n == 0) return 0;
		
		// initialize the cache
		int[] cache = new int[n + 1];
		cache[1] = 1;
		
		// fill cache iteratively
		for(int i = 2; i <= n; i++) {
			cache[i] = cache[i - 1] + cache[i - 2];
		}
		
		return cache[n];
	}
	
	public static void main(String[] args) {
		FibonacciBottomUp fibBottom = new FibonacciBottomUp();
		System.out.println("fib(5) = " + fibBottom.fib(5));
		System.out.println("fib(10) = " + fibBottom.fib(10));
	}
}
