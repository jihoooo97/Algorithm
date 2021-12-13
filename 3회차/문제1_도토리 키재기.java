import java.io.*;
import java.lang.*;
import java.util.*;

public class Main {
	public static final Scanner scanner = new Scanner(System.in);

	public static int getMaximumHeight(int[] height, int[] month, int n, int m) {
		// 도토리가 오름차순이기 때문에 가장 뒤에서부터 해당 월이 나오면 가장 크다
		for(int i = n - 1; i >= 0 ; i -= 1) {
			if(month[i] == m) {
				return height[i];
			}
		}
		return -1; // 없으면 -1 반환
	}

	public static void main(String[] args) throws Exception {
		int n = scanner.nextInt();
		int[] height = new int[n];
		
		// n개의 도톨이의 키 입력
		for(int i = 0 ; i < n ; i += 1) {
			height[i] = scanner.nextInt();
		}
		
		// 생일
		int[] month = new int[n];
		for(int i = 0 ; i < n; i += 1) {
			month[i] = scanner.nextInt();
		}
		
		int m = scanner.nextInt();
		System.out.print(getMaximumHeight(height, month, n, m));
		
	}

}
