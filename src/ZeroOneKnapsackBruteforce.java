
public class ZeroOneKnapsackBruteforce {
	
	
	// Naive bruteforce solution. Recursively include or exclude each item
	// to try every possible combination
	public static int knapsack(Item[] items, int W) {
		return knapsack(items, W, 0);
	}
	
	// Overloaded recursive function
	private static int knapsack(Item[] items, int W, int i) {
		// If we've gone through all the items, return 
		System.out.println("===================W = " + W + ", i = " + i);
		if(i == items.length)
			return 0;
		
		// If the item is too big to fill the
		// remaining space, skip it
		if(W - items[i].weight < 0)
			return knapsack(items, W, i + 1);
		
		// Find the maximum of including and not including the current item
		System.out.println("including, W = " + (W - items[i].weight) + ", i = " + (i + 1));
		System.out.println("excluding, W = " + W + ", i = " + (i + 1));
		return Math.max(knapsack(items, W - items[i].weight, i + 1) + items[i].value, knapsack(items, W, i + 1));
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
