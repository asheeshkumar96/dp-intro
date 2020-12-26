
public class TargetSumBruteforce {
	
	// Naive brute force solution. Find every combo
	public static int targetSum(int[] nums, int T) {
		return targetSum(nums, T, 0, 0);
	}
	
	// Overloaded recursive function
	public static int targetSum(int[] nums, int T, int i, int sum) {
		// When we've gone through every item, see 
		// if we've reached our target sum
		if(i == nums.length) {
			return sum == T ? 1 : 0;
		}
		
		return targetSum(nums, T, i + 1, sum + nums[i]) + targetSum(nums, T, i + 1, sum - nums[i]);
	}

	public static void main(String[] args) {
		System.out.println(targetSum(new int[] {1, 1, 1, 1, 1}, 3));
	}

}
