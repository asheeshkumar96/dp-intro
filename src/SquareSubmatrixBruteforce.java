import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class SquareSubmatrixBruteforce {
	
	// Brute force solution. From each cell
	// find the biggest square submatrix for which
	// it is the upper left-hand corner
	public static int squareSubmatrix(boolean[][] arr) {
		int max = 0;
		// Compute for each cell the biggest subarray
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[0].length; j++) {
				if(arr[i][j]) {
					max = Math.max(max, squareSubmatrix(arr, i, j));
				}
			}
		}
		return max;
	}
	
	private static int squareSubmatrix(boolean[][] arr, int i, int j) {
		// Base case at bottom or right of the matrix
		if(i == arr.length || j == arr[0].length) {
			return 0;
		}
		
		// If the cell is false then it's not part of a valid submatrix
		if(!arr[i][j]) return 0;
		
		// Find the size of right, bottom and bottom right submatrices and add 1 
		// to minimum of those 3 to get the result
		return 1 + Math.min(Math.min(squareSubmatrix(arr, i + 1, j), squareSubmatrix(arr, i, j + 1)), squareSubmatrix(arr, i + 1, j + 1));
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
