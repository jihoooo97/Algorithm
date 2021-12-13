import java.io.*;
import java.lang.*;
import java.util.*;

public class Main {
	public static final Scanner scanner = new Scanner(System.in);

	public static void bubbleSort(int[] data, int n) {
		int count =0;
		for(int i = 0 ; i < n ; i+=1) {
			for(int j = 0; j < n-i-1; j += 1) {
				if(data[j] > data[j+1]) {
				  int temp = data[j+1];
				  data[j+1] = data[j];
				  data[j] = temp;
				  count += 1;
				}
			}
			if(count == 0)
				break;
		}
	}

	public static void main(String[] args) throws Exception {
		int n = scanner.nextInt();
		int[] data = new int[n];
		for(int i = 0; i < n; i += 1) {
			data[i] = scanner.nextInt();
		}
		
		bubbleSort(data, n);
		
		for(int i = 0; i < n; i += 1) {
			System.out.printf("%d", data[i]);
			if(i < n-1)
				System.out.printf(" ");
		}

	}

}
