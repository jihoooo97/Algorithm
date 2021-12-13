import java.io.*;
import java.lang.*;
import java.util.*;

public class Main {
	public static final Scanner scanner = new Scanner(System.in);

	public static boolean isConsecutive(int[] data, int n) {
        int sum = 0;
		int min = data[0];
		
		for(int i = 0; i < n; i += 1) {
			sum += data[i];   // 배열의 합
			if(data[i] < min)
				min = data[i];  // 배열의 최소값
		}
		if(sum * 2 != n * (n+1) + 2 * n * (min-1))  // n(n+2)/2 + n(min-1) 값이 아니면 연속적인 수열이 아님
			return false;
		return true;
	}

	public static void main(String[] args) throws Exception {
		int n = scanner.nextInt();
		int[] data = new int[n];
		
		for(int i = 0; i < n; i += 1) {
			data[i] = scanner.nextInt();
		}

		if(isConsecutive(data, n)) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}
	}
}
