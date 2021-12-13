import java.io.*;
import java.lang.*;
import java.util.*;

public class Main {
	public static final Scanner scanner = new Scanner(System.in);

	public static boolean isOrdered(int[] data, int n) {
		for(int i = 0; i < n - 1; i += 1) {
			// 뒷값이 앞의 값보다 작으면 오름차순이 아니다
			if(data[i] > data[i+1]) {
				return false;
			}
		}
		return true;
	}


	public static void main(String[] args) throws Exception {
		int n = scanner.nextInt();
		
		int[] data = new int[n];
		for(int i = 0; i < n; i += 1) {
			data[i] = scanner.nextInt();
		}
		
		if(isOrdered(data, n)) {
			System.out.printf("YES\n");
		}
		else {
			System.out.printf("NO\n");
		}

	}

}
