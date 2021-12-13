import java.io.*;
import java.lang.*;
import java.util.*;

public class Main {
	public static final Scanner scanner = new Scanner(System.in);

	public static boolean isInside(long x, long y, long R) {
		// 원점부터 점까지의 거리 sqrt(x * x + y * y)
		return x * x + y * y < R * R;
	}

	public static void testCase(int caseIndex) {
		int R = scanner.nextInt();
		
		long sum = 0;
		int y = R;
				
		for(int x = 0 ; x < R; x += 1) {
			// y값을 계속 사용하기에 초기화하지 않고 따로 빼놓음
			for(; y >= 0; y -= 1) {
				if(isInside(x, y, R)) {
					sum += (y + 1);
					break;
				}
			}	
		}
		System.out.printf("#%d\n", caseIndex + 1);
		System.out.println(sum * 4);
	}

	public static void main(String[] args) throws Exception {
		// test case 의 개수
		int t = scanner.nextInt();
		
		for(int i = 0; i < t; i += 1) {
			testCase(i);
		}
		
	}

}
