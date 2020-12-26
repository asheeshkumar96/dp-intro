import java.util.HashMap;
import java.util.Map;

public class ZeroOneKnapsackTopdown {
	
	public static int knapsack(Item[] items, int W) {
		// Map: i -> W -> value
		Map<Integer, Map<Integer, Integer>> cache = new HashMap<Integer, Map<Integer, Integer>>();
		return knapsack(items, W, 0, cache);
	}
	
	public static int knapsack(Item[] items, int W, int i, Map<Integer, Map<Integer, Integer>> cache) {
		if (i == items.length)
			return 0;
		// Check if the value is in the cache
		if (!cache.containsKey(i))
			cache.put(i, new HashMap<Integer, Integer>());
		Integer cached = cache.get(i).get(W);
		if (cached != null)
			return cached;

		// Compute the item and add it to the cache
		int toReturn;
		if (W - items[i].weight < 0) {
			toReturn = knapsack(items, W, i + 1, cache);
		} else {
			toReturn = Math.max(knapsack(items, W - items[i].weight, i + 1, cache) + items[i].value,
					knapsack(items, W, i + 1, cache));
		}
		cache.get(i).put(W, toReturn);
		return toReturn;
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
