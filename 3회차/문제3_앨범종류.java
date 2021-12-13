import java.io.*;
import java.lang.*;
import java.util.*;

public class Main {
	public static final Scanner scanner = new Scanner(System.in);

	public static int getElementTypeCount(int[] data, int n) {
		int count = 0;
		// 전 수와 다른 수가 존재한다면 카운트를 늘린다
		for(int i = 0; i < n - 1; i += 1) {
			if(data[i] != data[i+1]) {
				count += 1;
			}
		}
		return count + 1;
	}

	public static void main(String[] args) throws Exception {
		int n = scanner.nextInt();
		int[] data = new int[n];
		
		for(int i = 0 ; i < n ; i += 1) {
			data[i] = scanner.nextInt();
		}
		
		System.out.print(getElementTypeCount(data, n));
	}

}
