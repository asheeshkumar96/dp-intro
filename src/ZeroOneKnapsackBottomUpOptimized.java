
public class ZeroOneKnapsackBottomUpOptimized {
	
	// Iterative bottom up solution
	public static int knapsack(Item[] items, int W) {
		// Initialize cache
		int[] cache = new int[W + 1];

		for(Item i : items) {
			int[] newCache = new int[W + 1];
			for(int j = 0; j <= W; j++) {
				if(i.weight > j) newCache[j] = cache[j];
				else newCache[j] = Math.max(cache[j], cache[j - i.weight] + i.value);
			}
			cache = newCache;
		}
		return cache[W];
	}

	public static void main(String[] args) {
		int W = 5;
		Item[] items = new Item[] { new Item(2, 6), new Item(2, 10), new Item(3, 12) };

		System.out.println(knapsack(items, W));
	}
}
