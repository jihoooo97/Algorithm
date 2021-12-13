import java.io.*;
import java.lang.*;
import java.util.*;


public class Main {
	public static final Scanner scanner = new Scanner(System.in);

	// 중복을 포함해 네 카드의 합으로 만들 수 있는 당첨번호들의 리스트를 반환하는 함수
	public static ArrayList<Integer> getPossibleTargets(int n, int m, int[] cards, int[] target) {
		ArrayList<Integer> possibleTargets = new ArrayList<>(); //만들 수 있는 당첨번호들
		ArrayList<CardPair> pairs = new ArrayList<>(); // 카드 페어 경우들
		
		// t = (a + b) + (c + d)
        // 카드 페어의 합 경우의 수를 구함
		for(int x : cards) {
			for(int y : cards) {
				CardPair p = new CardPair(x, y);
				pairs.add(p);
			}
		}
		
		// 카드 페어 경우의 수 리스트 정렬
		Collections.sort(pairs);
		
		for(int t : target) {
			for(CardPair pair : pairs) {
				int a = pair.sumOfCards; // 저장한 리스트에 있는 카드 합
				int b = t - a;           // 나머지 카드 페어(b)의 합 = 당첨번호 - 처음 카드 페어(a)의 합
				
				CardPair targetPair = new CardPair(b); // 합만 아는 카드 페어 생성
				if(Collections.binarySearch(pairs, targetPair) >= 0) {
					possibleTargets.add(t); // 해당 합이 존재하면 반환할 리스트에 추가
					break;
				}
			}
		}
        // 리스트 오름차순 정렬
		Collections.sort(possibleTargets);
		return possibleTargets;
	}

	public static void main(String[] args) throws Exception {
		int n = scanner.nextInt();  // 카드의 수
		int m = scanner.nextInt();  // 검사 할 후보 당첨번호의 수

		int[] cards = new int[n];
		int[] targets = new int[m];

		// 각 카드 정보를 입력받는다
		for(int i = 0; i < n; i += 1){
			cards[i] = scanner.nextInt();
		}

		// 각 당첨번호를 입력받는다
		for(int i = 0; i < m; i += 1) {
			targets[i] = scanner.nextInt();
		}

		ArrayList<Integer> answers = getPossibleTargets(n, m, cards, targets);

		if(answers.size() == 0) { // 가능한 당첨번호가 없다면 NO 출력
			System.out.print("NO");
		} else {                  // 가능한 당첨번호가 존재하면 그 목록 출력
			for(int i = 0; i < answers.size(); i+= 1) {
				if(i > 0) {
					System.out.print(" ");
				}
				System.out.print(answers.get(i));
			}
		}
		
	}
	
}

class CardPair implements Comparable<CardPair> {   // 두 개의 카드 조합을 나타내는 클래스
	int card1;
	int card2;
	int sumOfCards; //두 카드의 합

	//두 카드의 정보를 알 때 생성자
	CardPair(int card1, int card2) {
		this.card1 = card1;
		this.card2 = card2;
		this.sumOfCards = this.card1 + this.card2;
	}

	// 두 카드의 정보를 모르고 합만 알 때 생성자
	CardPair(int sumOfCards) {
		this.sumOfCards = sumOfCards;
		this.card1 = -1;
		this.card2 = -1;
	}

	// 두 카드의 합으로 짝들의 대소 관계를 정의한다.
	@Override
	public int compareTo(CardPair o) {
		return this.sumOfCards - o.sumOfCards;
	}
}