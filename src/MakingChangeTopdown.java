
// Top down solution
public class MakingChangeTopdown {

	private int[] coins = new int[] {10, 6, 1};
	
	public int makeChange(int c) {
		// Initialize cache with values as -1
		int[] cache = new int[c + 1];
		for(int i = 0; i < c + 1;  i++)
			cache[i] = -1;
		return makeChange(c, cache);
	}
	
	// Overloaded recursive function
	private int makeChange(int c, int[] cache) {
		if(c == 0) return 0;
		
		// Return the value if it's in the cache
		if(cache[c] >= 0) return cache[c];
		
		int minCoins = Integer.MAX_VALUE;
		// find the best coin
		for(int coin : coins) {
			if(c - coin >= 0) {
				int currMinCoins = makeChange(c - coin, cache);
				if(currMinCoins < minCoins) {
					minCoins = currMinCoins;
				}
			}
		}
		// save the value into  the cache
		cache[c] = minCoins + 1;
		return cache[c];
	}
	
	
	public static void main(String[] args) {
		MakingChangeTopdown change = new MakingChangeTopdown();
		System.out.println("1 " + change.makeChange(1));
		System.out.println("6 " + change.makeChange(6));
		System.out.println("49 " + change.makeChange(49));
	}
}
