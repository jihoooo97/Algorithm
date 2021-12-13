import java.io.*;
import java.lang.*;
import java.util.*;


public class Main {
	public static final Scanner scanner = new Scanner(System.in);

	public static int[] getIndexes(String[] school, int n) {
		int firstIndex = -1;
		int lastIndex = -1;
		
		for(int i = 0; i < n; i += 1) {
			if(school[i].equals("AJOU")) {
				if(firstIndex == -1) {
					firstIndex = i;
				}
				lastIndex = i;
			}
		}
		
		return new int[]{firstIndex, lastIndex};
	}

	public static void main(String[] args) {
		int n = scanner.nextInt();
		String[] school = new String[n];
		
		for(int i = 0; i < n; i += 1) {
			school[i] = scanner.next();
		}
		
		int[] indexes = getIndexes(school, n);
		System.out.printf("%d %d", indexes[0]+1, indexes[1]+1);
	}

}
