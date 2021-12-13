import java.io.*;
import java.lang.*;
import java.util.*;

public class Main {
	public static final Scanner scanner = new Scanner(System.in);

	public static boolean isWinnable(int[] data, int n, int k) {		
		for(int i = 0; i < n-k+1; i += 1) {
			int sum = 0;
			for(int j = i; j < i+k; j +=1 ) { // i부터 k개의 합
				sum += data[j];
			}
			if(sum % 2 == 0) return true; // 짝수인 경우 현무 승
		}
		
		return false;
	}

	public static void main(String[] args) throws Exception {
		int n = scanner.nextInt();
		int k = scanner.nextInt();
		
		int[] data = new int[n];
		
		for(int i = 0; i < n; i += 1) {
			data[i] = scanner.nextInt();
		}
		
		if(isWinnable(data, n, k)) {
			System.out.print("YES");
		} else {
			System.out.print("NO");
		}
	}

}
