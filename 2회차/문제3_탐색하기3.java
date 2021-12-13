import java.io.*;
import java.lang.*;
import java.util.*;

public class Main {
	public static final Scanner scanner = new Scanner(System.in);

	public static int findIndex(int[] data, int n) {
		int sum = 0;
		int index = 0;  // 최소 거리의 인덱스.
		
		for(int i = 0 ; i < n ; i += 1) {
			sum += data[i];
		}
		
		int minDiff = Math.abs(sum - n * data[0]);

		// 평균은 data[0]+..+data[n-1] / n;
		// sum / n - data[i]; = 거리
		for( int i = 0; i < n; i += 1) {
			// minDiff = sum - n*data[index];
			if(Math.abs(sum - n*data[i]) < minDiff){
				index = i;
				minDiff = Math.abs(sum - n*data[i]);
			}
		}
		
		return index;
	}

	public static void main(String[] args) {
		int n = scanner.nextInt();
		int[] data = new int[n];
		
		for(int i = 0; i < n; i += 1) {
			data[i] = scanner.nextInt();
		}

		int answer = findIndex(data, n);
	
	System.out.printf("%d %d", answer + 1, data[answer]);
	}
	
	

}
