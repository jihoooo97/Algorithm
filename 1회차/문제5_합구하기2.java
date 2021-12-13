import java.io.*;
import java.lang.*;
import java.util.*;


public class Main {
	public static final Scanner scanner = new Scanner(System.in);

	public static void solve(int[] data, int n, int p, int q) {
	    // 몸무게 제한에 걸리지 않은 회원수
		int count = 0;
		// 몸무게 제한에 걸리지 않은 회원들의 몸무게합
		int sum = 0;
		
		for(int i = 0; i < n; i += 1) {
			if(data[i] <= p) {
				count += 1;
				sum += data[i];
			}
		}
		
		System.out.printf("%d %d\n", count, sum);
		if(sum > q) {
			System.out.print("NO");
		} else {
			System.out.print("YES");
		}
	}


	public static void main(String[] args) {
		// 동아리 회원수 n
		int n = scanner.nextInt();
		// 몸무게 제한
		int p = scanner.nextInt();
		// 놀이기구 최대 하중
		int q = scanner.nextInt();
		
		int[] data = new int[n];
		
		for(int i = 0; i < n; i += 1) {
			data[i] = scanner.nextInt();
		}
		
		solve(data, n, p, q);
	}
	
}
