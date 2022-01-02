import java.io.*;
import java.lang.*;
import java.util.*;

class Main {
	public static final Scanner scanner = new Scanner(System.in);
	
	public static void testCase(int caseIndex) {
		int n = scanner.nextInt();
		int[][] array = new int[n][n];
		
		int k = 0;
		int value = 1;
		
		for(int degree = n; degree >= 0; degree -= 2) {
			// top
			for(int c = k; c <= degree + k - 1; c += 1) {
				array[k][c] = value;
				value += 1;
			}
			// right
			for(int r = k + 1; r <= degree + k - 1; r += 1) {
				array[r][degree + k - 1] = value;
				value += 1;
			}
			// bottom
			for(int c = degree - 1; c > 0; c -= 1) {
				array[degree + k - 1][c + k - 1] = value;
				value += 1;
			}
			// left
			for(int r = degree + k - 2; r > k; r -= 1) {
				array[r][k] = value;
				value += 1;
			}
			k += 1;
		}
		
		for(int i = 0; i < n; i += 1) {
			for(int j = 0; j < n; j += 1) {
				System.out.printf("%d ", array[i][j]);
			}
			System.out.printf("\n");
		}
		
	}
	
  public static void main(String[] args) {
		int caseSize = scanner.nextInt();
		
		for (int caseIndex = 1; caseIndex <= caseSize; caseIndex += 1) {
			testCase(caseIndex);
		}
	}
	
}
