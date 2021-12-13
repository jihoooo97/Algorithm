import java.io.*;
import java.lang.*;
import java.util.*;

public class Main {
	public static final Scanner scanner = new Scanner(System.in);

	// 중복을 포함해 세 카드의 합으로 만들 수 있는 당첨번호들의 리스트를 반환하는 함수
	public static ArrayList<Integer> getPossibleTargets(int n, int m, int[] cards, int[] target) {
		ArrayList<Integer> possibleTargets = new ArrayList<>(); //만들 수 있는 당첨번호들

		Arrays.sort(cards);  // 이진 탐색을 위해 cards 오름차순 정렬
		for(int t : target) {
			Boolean possible = false;  // 당첨번호 가능 여부
			for(int x : cards) {
				for(int y : cards) {
					int z = t - (x + y);
					if(Arrays.binarySearch(cards, z) >= 0) {
						possible = true;
						possibleTargets.add(t);
						break;
					}
				}
				if(possible)
					break;
			}
		}
        // List 정렬
		Collections.sort(possibleTargets);
		return possibleTargets;
	}

	public static void main(String[] args) throws Exception {
		int n = scanner.nextInt();  // 카드의 수
		int m = scanner.nextInt();  // 검사 할 후보 당첨번호의 수

		int[] cards = new int[n];
		int[] targets = new int[m];

		// 각 카드 정보를 입력받는다
		for(int i = 0; i < n; i += 1) {
			cards[i] = scanner.nextInt();
		}

		// 각 당첨번호를 입력받는다
		for(int i = 0; i < m; i += 1) {
			targets[i] = scanner.nextInt();
		}

		ArrayList<Integer> answers = getPossibleTargets(n, m, cards, targets);

		if(answers.size() == 0) {
			System.out.print("NO");
		} else {
			for(int i = 0 ; i < answers.size() ; i++) {
				if( i > 0 ) {
					System.out.print(" ");
				}
				System.out.print(answers.get(i));
			}
		}
		
	}

}