import java.io.*;
import java.lang.*;
import java.util.*;

public class Main {
	public static final Scanner scanner = new Scanner(System.in);

	public static boolean isPrime(int N) {
		// 1은 소수가 아님
		if(N == 1) return false;

		// 짝수도 소수가 아님
		if(N != 2 && N%2 == 0) return false; 
		
		// 홀수에 대해서 소수여부 판별
		for(int i = 3; i < Math.sqrt(N); i += 2) {
			if(N % i == 0) return false;
		}
		
		return true;
	}

	public static void testCase(int caseIndex) {
		int n = scanner.nextInt();

		System.out.printf("Case #%d\n", caseIndex);
		if(isPrime(n)) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}
	}

	public static void main(String[] args) throws Exception {
		int caseSize = scanner.nextInt();

		for (int caseIndex = 1; caseIndex <= caseSize; caseIndex += 1) {
			testCase(caseIndex);
		}
	}

}
