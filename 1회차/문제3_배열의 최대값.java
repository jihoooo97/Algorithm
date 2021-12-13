import java.io.*;
import java.lang.*;
import java.util.*;


public class Main {
	public static final Scanner scanner = new Scanner(System.in);

	public static int getMax(int[] data, int n) {
		// data[0] - data[n-1] 모두 순환해서 가장 큰값을 찹아야됨.
		int max = Integer.MIN_VALUE;
		for(int i = 0; i < n; i += 1) {
			if( max < data[i]) max = data[i];
		}
		
		return max;
	}

	public static void main(String[] args) throws Exception {
		int n = scanner.nextInt();
			int[] data = new int[n];
		
		for(int i = 0 ; i < n; i += 1) {
			data[i] = scanner.nextInt();
		}
		
		int max = getMax(data, n);
		
		System.out.print(max);
	}

}
