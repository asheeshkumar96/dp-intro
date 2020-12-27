
public class FibonacciTopdown {

	public int fib(int n) {
		if(n < 2) return n;
		// create cache and initialize to -1
		int[] cache = new int[n + 1];
		for(int i = 0; i < cache.length; i++) {
			cache[i] = -1;
		}
		// fill initial values in cache;
		cache[0] = 0;
		cache[1] = 1;
		return fib(n, cache);
	}
	
	// Overloaded private method
	private int fib(int n, int[] cache) {
		// if value is set in cache return
		if(cache[n] >= 0) return cache[n];
		
		// compute and add to cache before returning
		cache[n] = fib(n - 1, cache) + fib(n - 2, cache);
		return cache[n];
	}
	
	public static void main(String[] args) {
		FibonacciTopdown fibtop = new FibonacciTopdown();
		System.out.println("fib(5) = " + fibtop.fib(5));
		System.out.println("fib(10) = " + fibtop.fib(10));
	}
}
