import java.io.*;
import java.lang.*;
import java.util.*;

public class Main {
	public static final Scanner scanner = new Scanner(System.in);

	public static void testCase(int caseIndex) {
		int num1 = scanner.nextInt();
		int num2 = scanner.nextInt();

		long gcd =  MathUtil.getGCD(num1, num2);
		long lcm =  MathUtil.getLCM(num1, num2);

		System.out.printf("Case #%d:\n", caseIndex);
		System.out.printf("%d %d\n", gcd, lcm);
	}

	public static void main(String[] args) throws Exception {
		int caseSize = scanner.nextInt();

		for (int caseIndex = 1; caseIndex <= caseSize; caseIndex += 1) {
			testCase(caseIndex);
		}
	}

}

class MathUtil{

	static long getGCD(long a, long b) {
		while(a % b != 0) {
			long c = a % b;
			a = b;
			b = c;
		}
		return b;
	}

	static long getLCM(long a, long b) {
		return a * b / getGCD(a, b);
	}
}