import java.io.*;
import java.lang.*;
import java.util.*;

public class Main {
	public static final Scanner scanner = new Scanner(System.in);

	public static long getGlobalPeriod(int n, long[] sizes) {
		return MathUtil.getLCM(sizes);
	}

	public static void main(String[] args) throws Exception {
		int n = scanner.nextInt(); // 수열의 수
		long[] sizes = new long[n];  // 각 수열의 주기

		for(int i = 0; i < n; i+= 1) {
			sizes[i] = scanner.nextLong();
		}

		// 전체의 공통 주기만큼 이후에 다시 최초로 만남
		long answer = 1 + getGlobalPeriod(n, sizes);

		// 정답 출력
		System.out.println(answer);
	}

}


class MathUtil {
	public static long getGCM(long a, long b) {
		if(a % b == 0) return b;
		return getGCM(b, a % b);
	}
	
	public static long getLCM(long a, long b) {
		return a * b / getGCM(a, b);
	}

	public static long getLCM(long[] numbers) {
		if(numbers.length == 0) return 0;
		
		long lcm = numbers[0];
		for(int i = 1; i < numbers.length; i += 1) {
			lcm = getLCM(lcm, numbers[i]);
		}
		return lcm;
	}
	
}