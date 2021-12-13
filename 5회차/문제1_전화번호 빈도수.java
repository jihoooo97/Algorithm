import java.io.*;
import java.lang.*;
import java.util.*;

public class Main {
	public static final Scanner scanner = new Scanner(System.in);
	public static final int MAX_TABLE_LENGTH = 10000;

	public static void fillFrequencyTable(int[] data, int n, int[] table) {
		for(int i = 0; i < n; i += 1) {
			table[data[i]] += 1;
		}
	}

	public static int getFrequentNumber(int[] data, int n) {
		int frequent_number = 0;  //0000~9999중  가장 많이 등장한 번호
		int[] table = new int[MAX_TABLE_LENGTH];
		
		fillFrequencyTable(data, n, table);
		
		for(int i = 0; i < MAX_TABLE_LENGTH; i += 1) {
			if(table[i] > table[frequent_number])
				frequent_number = i;
		}
		
		return frequent_number;
	}

	public static void main(String[] args) throws Exception {
		int n = scanner.nextInt();
		int[] data = new int[n];
		for (int i = 0; i < n; i++) {
			data[i] = scanner.nextInt();
		}

		int answer = getFrequentNumber(data, n);

		// 네자리 미만의 수에 대해 0이 출력되도록 처리
		if(answer >= 1000)
		  System.out.println(answer);
		else if(answer >= 100)
			System.out.printf("0%d", answer);
		else if(answer >= 10)
			System.out.printf("00%d", answer);
		else
			System.out.printf("000%d", answer);

	}
}
