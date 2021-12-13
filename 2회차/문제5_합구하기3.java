import java.io.*;
import java.lang.*;
import java.util.*;

public class Main {
	public static final Scanner scanner = new Scanner(System.in);

	public static int getRangeSumFromOne(int M) {
		return (M + 1) * M / 2;
	}

	public static int getAnswer(int N) {
		int sum = 0;
		for(int i = 1 ; i <= N; i += 1) {
			sum += getRangeSumFromOne(i);
		}
		return sum;
	}

	public static void main(String[] args) throws Exception {
		int n = scanner.nextInt();
		// 1 + (1 + 2) + ... + (1 + ... + n);
		System.out.print(getAnswer(n));
	}

}
