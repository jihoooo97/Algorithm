import java.io.*;
import java.lang.*;
import java.util.*;

public class Main {
	public static final Scanner scanner = new Scanner(System.in);

	// 중복을 포함해 두 카드의 합으로 만들 수 있는 당첨번호의 수를 계산하는 함수
	public static int getPossibleTargetNumber(int n, int m, int[] cards, int[] target) {
		int answer = 0; //만들 수 있는 당첨번호의 수
		
		Arrays.sort(cards); // 이진탐색을 이용하므로 오름차순 정렬
		// 당첨번호 t에 대해서 카드숫자y = target - 카드숫자x
		for(int t : target) {
            Boolean possible = false;
			for(int x : cards) {
				int y = t - x;
				// 카드숫자 y가 존재하는지 체크
				if(Arrays.binarySearch(cards, y) >= 0) {
				   possible = true;
				   answer += 1;
				   break;
				}
			}
		}

		return answer;
	}

	public static void main(String[] args) throws Exception {
		int n = scanner.nextInt();  // 카드의 수
		int m = scanner.nextInt();  // 검사 할 후보 당첨번호의 수

		int[] cards = new int[n];
		int[] targets = new int[m];

		// 각 카드 정보를 입력받는다
		for(int i = 0 ; i < n ; i += 1) {
			cards[i] = scanner.nextInt();
		}

		// 각 당첨번호를 입력받는다
		for(int i = 0 ; i < m ; i += 1) {
			targets[i] = scanner.nextInt();
		}

		int answer = getPossibleTargetNumber(n, m, cards, targets);

		System.out.println(answer);
	}

}
