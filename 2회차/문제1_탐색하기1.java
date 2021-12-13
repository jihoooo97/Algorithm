import java.io.*;
import java.lang.*;
import java.util.*;

public class Main {
	public static final Scanner scanner = new Scanner(System.in);

	public static int findIndex(int[] data, int n, int m) {
		
		for(int i = 0; i < n; i += 1) {
			if(data[i] == m ) {
				return i;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		int n = scanner.nextInt();
		int m = scanner.nextInt();
		
		int[] data = new int[n];
		
		// n개의 자연수가 공백으로 들어옴
		for(int i = 0; i < n; i += 1) {
			data[i] = scanner.nextInt();
		}
		
		System.out.print(findIndex(data, n, m));
	}
}
