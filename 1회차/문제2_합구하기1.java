import java.io.*;
import java.lang.*;
import java.util.*;


public class Main {
	public static final Scanner scanner = new Scanner(System.in);

	public static int getSum(int[] data, int n) {
		int sum = 0;
		for(int i = 0; i < n; i += 1) {
			sum += data[i];
		}
		return sum;
	}

	public static void main(String[] args) throws Exception {
		int n = scanner.nextInt();
		int[] data = new int [n];
		
		for(int i = 0; i < n; i += 1) {
			data[i] = scanner.nextInt();
		}
		
		int result = getSum(data, n);
		System.out.println(result);
		
	}
}
