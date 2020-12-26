import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SquareSubmatrixBottomUp {
	
	public static int squareSubmatrix(boolean[][] arr) {
		int max = 0; 
		// Initialize cache
		int[][] cache = new int[arr.length][arr[0].length];
		// Iterate over the matrix to compute each value
		for(int i = 0; i < cache.length; i++) {
			for(int j = 0; j < cache[0].length; j++) {
				// If we're in the first row/ column then the 
				// value is just 1 if that cell is true and 0 
				// otherwise. In other rows and columns need to 
				// look up and to the left
				if(i == 0 || j == 0) {
					cache[i][j] = arr[i][j] ? 1 : 0;
				} else if(arr[i][j]) {
					cache[i][j] = Math.min(Math.min(cache[i][j - 1], cache[i - 1] [j]), cache[i - 1][j - 1]) + 1;
				}
				
				if(cache[i][j] > max) {
					max = cache[i][j];
				}
			}
		}
		return max;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		boolean[][] matrix = new boolean[n][n] ;
		
		for(int i = 0; i < n; i++) {
			String[] line = br.readLine().trim().split(" ");
			for(int j = 0; j < n; j++) {
				matrix[i][j] = Boolean.parseBoolean(line[j]);
			}
		}
		// for printing to verify
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix[i].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println(squareSubmatrix(matrix));
	}
}
