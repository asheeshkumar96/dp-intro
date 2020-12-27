
// Bottom up dynamic programming solution. 
// Iteratively compute number of coins for
// larger and larger amount of change
public class MakingChangeBottomUp {

	public int[] coins = new int[]{ 10, 6, 1};
	
	public int makeChange(int c) {
		int[] cache = new int[c + 1];
		for(int i = 1; i <= c; i++) {
			int minCoins = Integer.MAX_VALUE; 
			
			// Try removing each coin from the total 
			// and see which required the fewest extra coins
			for(int coin: coins) {
				if(i - coin >= 0) {
					int currCoins = cache[i - coin] + 1;
					if(currCoins < minCoins) {
						minCoins = currCoins;
					}
				}
			}
			cache[i] = minCoins;
		}
		
		return cache[c];
	}
	
	public static void main(String[] args) {
		MakingChangeBottomUp change = new MakingChangeBottomUp();
		System.out.println( "1 " + change.makeChange(1));
		System.out.println( "6 " + change.makeChange(6));
		System.out.println("49 " + change.makeChange(49));
	}
}
