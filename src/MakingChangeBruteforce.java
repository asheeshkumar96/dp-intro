
public class MakingChangeBruteforce {

	public int[] coins = new int[] {10, 6, 1};
	
	
	public int makeChange(int c) {
		if(c == 0) return 0;
		int minCoins = Integer.MAX_VALUE;
		// Try removing each coin from the total and see
		// how many more coins are required
		for(int coin: coins) {
			// Skip a coin if it's value is greater than the amount remaining
			if(c - coin >= 0) {
				int currMinCoins = makeChange(c - coin);
				if(currMinCoins < minCoins) {
					minCoins = currMinCoins;
				}
			}
		}
		// Add back the coin removed recursively 
		return minCoins + 1;
	}
	
	public static void main(String[] args) {
		MakingChangeBruteforce change = new MakingChangeBruteforce();
		System.out.println( "1 " + change.makeChange(1) );
		System.out.println( "6 " +  change.makeChange(6) );
		System.out.println( "49 " + change.makeChange(49) );

	}
}
