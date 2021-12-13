import java.io.*;
import java.lang.*;
import java.util.*;


public class Main {
	public static final Scanner scanner = new Scanner(System.in);

	public static int getCount(int[] data, int n, int m, int s) {
		int count = 0;
		for(int i = 0; i < n; i += 1) {
			if(data[i] == m || data[i] == s) {
				count += 1;
			}
		}
		return count;
	}

	public static void main(String[] args) throws Exception {
		int n = scanner.nextInt();
		int m = scanner.nextInt();
		int s = scanner.nextInt();
		
		int[] data = new int[n];
		for(int i = 0; i < n; i += 1) {
			data[i] = scanner.nextInt();
		}
		
		int result = getCount(data, n, m, s);
		System.out.println(result);
		
	}

}
