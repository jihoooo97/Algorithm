import java.io.*;
import java.lang.*;
import java.util.*;

public class Main {
	public static final Scanner scanner = new Scanner(System.in);

	public static int getMinIndexInRange(int[] data, int begin, int end) {
		// 범위 내 최솟값 인덱스 구함
		int minIndex = begin;
		for(int i = begin; i < end; i += 1) {
			if(data[i] < data[minIndex]) {
				minIndex = i;
			}
		}
		return minIndex;
	}

	public static void selectionSort(int[] data, int n) {	
		int temp;
		for(int i = 0; i < n; i += 1) {
			int min = getMinIndexInRange(data, i, n);
			temp = data[min];
			data[min] = data[i];
			data[i] = temp;
		}
	}

	public static void main(String[] args) throws Exception {
		int n = scanner.nextInt();
		int[] data = new int[n];
		
		for(int i = 0; i < n; i += 1) {
			data[i] = scanner.nextInt();
		}
		
		selectionSort(data, n);
		
		for(int i = 0; i < n; i += 1) {
			if(i > 0) {
				System.out.printf(" ");
			}
			System.out.printf("%d", data[i]);
		}
	}

}
