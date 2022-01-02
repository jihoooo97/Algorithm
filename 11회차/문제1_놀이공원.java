import java.io.*;
import java.lang.*;
import java.util.*;


public class Main {
	public static final Scanner scanner = new Scanner(System.in);
	
	public static void testCase(int caseIndex) {
		int N = scanner.nextInt();  // 지도의 크기 
		int K = scanner.nextInt();  // 놀이공원의 크기
		
		int[][] wastes = new int[N][N]; // 각 칸의 쓰레기 존재 여부 
		for (int r = 0; r < N; r += 1) {
			for (int c = 0; c < N; c += 1) {
				wastes[r][c] = scanner.nextInt();
			}
		}
		
		int answer = Integer.MAX_VALUE;
		for(int x = 0; x + K - 1 < N; x += 1) {
			for(int y = 0; y + K - 1 < N; y += 1) {
				
				int dx = x + K - 1;
				int dy = y + K - 1;
				int count = 0;
				
				for(int r = x; r <= dx; r += 1) {
					for(int c = y; c <= dy; c += 1) {
						if(wastes[r][c] == 1) {
							count += 1;
						}
					}
				}
				
				answer = Math.min(answer, count);
			}
		}
		
		System.out.println(answer);
	}
	
	public static void main(String[] args) throws Exception {
		int caseSize = scanner.nextInt();
		
		for (int caseIndex = 1; caseIndex <= caseSize; caseIndex += 1) {
			testCase(caseIndex);
		}
		
	}
	
}