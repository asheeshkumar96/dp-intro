
public class TargetSumBottomUp {

	// Top down dynamic programming solution. Like 0-1 Knapsack, we use a HashMap to save space
		public static int targetSum(int[] nums, int T) {
			int sum = 0;
			// Our cache has to range from -sum(nums) to sum(nums), so we offset everything by sum
			for(int num: nums) sum += num;
			int[][] cache = new int[nums.length + 1] [ 2 * sum + 1];
			if(sum == 0) return 0;
			
			// Initialize i = 0, T = 0
			cache[0][sum] = 1;
			
			// Iterate over previous row and update the current row
			for(int i = 1; i <= nums.length; i++) {
				for(int j = 0; j < 2 * sum + 1; j++) {
					int prev = cache[i - 1][j];
					if(prev != 0) {
						cache[i][j - nums[i - 1]] += prev;
						cache[i][j + nums[i - 1]] += prev;
					}
				}
			}
			return cache[nums.length][sum + T];
		}

		public static void main(String[] args) {
			System.out.println(targetSum(new int[] { 1, 1, 1, 1, 1}, 3));
		}
}
