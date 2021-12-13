import java.io.*;
import java.lang.*;
import java.util.*;

public class Main {
	public static final Scanner scanner = new Scanner(System.in);

	public static Range getBestRange(int n, int m, int[] cards, Range[] ranges) {
		Range answer = ranges[0];
		long[] middleSum = new long[n+1];
		
		for(int i = 1; i <= n; i += 1) {
			middleSum[i] = middleSum[i-1] + cards[i];
		}
		
		for(Range r : ranges) {
		  r.totalPoint = middleSum[r.right] - middleSum[r.left-1];
			if(r.totalPoint > answer.totalPoint)
				answer = r;
		}
		return answer;
	}

	public static void main(String[] args) throws Exception {
		int n = scanner.nextInt();  // 숫자카드 수
		int m = scanner.nextInt();  // 팬의 수
		int[] cards = new int[n+1];  // 1-based index
		Range[] ranges = new Range[m];

		// 각 카드의 정보를 입력받는다.
		for(int i = 1; i <= n; i += 1) {
			cards[i] = scanner.nextInt();
		}

		// 팬들의 정보를 입력받는다.
		for(int i = 0; i < m; i += 1) {
			int l = scanner.nextInt();
			int r = scanner.nextInt();
			ranges[i] = new Range(i+1, l, r);
		}

		//범위의 합이 가장 큰 범위를 계산한다.
		Range answer = getBestRange(n, m, cards, ranges);
		System.out.printf("%d %d\n", answer.index, answer.totalPoint);
	}

}

class Range{
	int index;
	int left;
	int right;
	long totalPoint;
	
	Range(int index, int left, int right) {
		this.index = index;
		this.left = left;
		this.right = right;
		this.totalPoint = 0;
	}
}