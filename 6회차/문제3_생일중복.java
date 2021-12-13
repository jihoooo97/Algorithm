import java.io.*;
import java.lang.*;
import java.util.*;

public class Main {
	public static final Scanner scanner = new Scanner(System.in);

	public static int getUniqueRangeNumber(int[] birthDate, int n, int k) {
		int answer = 0; // 모든 원소가 서로 다른 범위의 수 (원소가 중복이 없는 범위)
		FrequencyTable table = new FrequencyTable();
		
        // 먼저 0부터 k-1개의 생년월일 추가
		for(int i = 0; i < k - 1; i += 1) {
			table.addBirthDate(birthDate[i]);
		}
		
        // k개의 범위를 인덱스에 따라 옮겨가면서 중복여부 확인
		for(int i = 0; i <= n - k; i += 1) {
			int left = i;
			int right = i + k - 1;
			table.addBirthDate(birthDate[right]);
			if(left > 0) { // 첫 인덱스가 0이면 제거할 것이 없으므로 1부터 제거
			  table.removeBirthDate(birthDate[i-1]);
			}
			if(table.uniqueElements == k) {  // 유니크한 수가 k랑 같으면
				answer += 1;                 // 연속된 k개의 생년월일은 중복이 없는것
			}
		}
		return answer;
	}


	public static void main(String[] args) throws Exception {
		int n = scanner.nextInt();  // 회원 수
		int k = scanner.nextInt();  // 선택 수
		int[] birthDate = new int[n];
		for(int i = 0; i < n; i += 1) {
			birthDate[i] = scanner.nextInt();
		}

		int answer = getUniqueRangeNumber(birthDate, n, k);
		System.out.println(answer);
	}

}

class FrequencyTable {
	public static final int MAX_SIZE = 1000000;

	int uniqueElements; // 현재 중복이 존재하지 않는 unique한 생일의 수
	int[] frequency;    // frequency[b] = 생일이 b인 정보의 수

	FrequencyTable() {
		this.uniqueElements = 0;
		this.frequency = new int[MAX_SIZE];
	}

	// 새로운 생일을 등록하고 빈도수를 갱신
	void addBirthDate(int birthDate) {
		if(frequency[birthDate] == 0) {        // 빈도수가 0이면 유니크하므로 카운트 증가
			this.uniqueElements += 1;
		} else if(frequency[birthDate] == 1) { // 빈도수가 1이면 추가될 때 중복되므로 유니크카운트 감소
			this.uniqueElements -= 1;
		}
		this.frequency[birthDate] += 1;        // 해당 생년월일을 추가하므로 빈도수 증가
	}

	// 기존의 생일을 제거하고 빈도수를 갱신
	void removeBirthDate(int birthDate) {
		if(frequency[birthDate] == 1) {        // 빈도수가 1이면 아예 사라지므로 유니크카운트 감소
			this.uniqueElements -= 1;
		} else if(frequency[birthDate] == 2) { // 빈도수가 2면 제거될 때 유니크해지므로 카운트 증가
			this.uniqueElements += 1;
		}
		this.frequency[birthDate] -= 1;        // 해당 생년월일을 제거하므로 빈도수 감소
	}

}