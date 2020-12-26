import java.util.HashMap;
import java.util.Map;

public class TargetSumTopdown {

	// Top down dynamic programming solution. Like 0-1 Knapsack, we use a HashMap to save space
	public static int targetSum(int[] nums, int T) {
		Map<Integer, Map<Integer, Integer>> cache = new HashMap<Integer, Map<Integer, Integer>>();
		return targetSum(nums, T, 0, 0, cache);
	}

	// Overloaded recursive function
	public static int targetSum(int[] nums, int T, int i, int sum, Map<Integer, Map<Integer, Integer>> cache) {
		// When we've gone through every item, see
		// if we've reached our target sum
		if (i == nums.length) {
			return sum == T ? 1 : 0;
		}
		
		// Check the cache and return if we get a hit
		if(!cache.containsKey(i)) cache.put(i, new HashMap<Integer, Integer>());
		Integer cached = cache.get(i).get(sum);
		if(cached != null) return cached;
		
		// if we didn't hit in the cache, compute the value and store to cache
		int toReturn = targetSum(nums, T, i + 1, sum + nums[i], cache) + targetSum(nums, T, i + 1, sum - nums[i], cache);
		cache.get(i).put(sum, toReturn);
		return toReturn;
	}

	public static void main(String[] args) {
		System.out.println(targetSum(new int[] { 1, 1, 1, 1, 1}, 3));
	}
}
