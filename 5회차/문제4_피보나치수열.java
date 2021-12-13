import java.io.*;
import java.lang.*;
import java.util.*;

public class Main {
	public static final Scanner scanner = new Scanner(System.in);
	public static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

	public static final int MAX_N = 1000000;
	public static int[] FIBONACCI_TABLE;

	public static int[] makeFibonacciTable(int n) {
		int[] data = new int[n];
		data[0] = 0;
		data[1] = 1;
		
		for(int i = 2 ; i < n; i += 1) {
			data[i] = (data[i - 1] + data[i - 2]) % 100000000;
		}
		
		return data;
	}

	public static int getFibo(int n) {
		return FIBONACCI_TABLE[n - 1];
	}

	public static void main(String[] args) throws Exception {
		//가능한 모든 범위에 대한 피보나치 수열의 값을 계산
		FIBONACCI_TABLE = makeFibonacciTable(MAX_N);

		//테스트케이스를 반복 수행
		int caseSize = scanner.nextInt();
		for (int caseIndex = 1; caseIndex <= caseSize; caseIndex += 1) {
			int n = scanner.nextInt();

			//피보나치 수열의 n번째 항을 계산하여 출력
			int answer = getFibo(n);
			writer.write(String.valueOf(answer) + "\n");
		}

		//불필요한 배열은 가능하면 할당 해제해주는 버릇을 들이자
		FIBONACCI_TABLE = null;

		writer.flush();
		writer.close();
	}

}
