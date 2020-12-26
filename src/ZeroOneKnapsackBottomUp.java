
public class ZeroOneKnapsackBottomUp {

	// Iterative bottom up solution 
	public static int knapsack(Item[] items, int W) {
		// Initialize cache
		int[][] cache = new int[items.length + 1][W + 1];
		
		// For each item and weight, compute max value  of the 
		// items up to that item that doesn't go over W weight
		for(int i = 1; i <= items.length; i++) {
			// ????????????????????????????????
			for(int j = 0; j <= W; j++) {
				if(items[i - 1].weight > j) {
					cache[i][j] = cache[i - 1][j];
				} else {
					cache[i][j] = Math.max(cache[i - 1][j], cache[i - 1][j - items[i - 1].weight] + items[i - 1].value);
				}
			}
		}
		return cache[items.length][W];
	}
	
	public static void main(String[] args) {
		int W = 5; 
		Item[] items = new Item[] {
				new Item(2, 6),
				new Item(2, 10),
				new Item(3, 12)
				};
		
		System.out.println(knapsack(items, W));
	}
}
