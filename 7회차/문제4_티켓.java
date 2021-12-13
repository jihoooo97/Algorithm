import java.io.*;
import java.lang.*;
import java.util.*;

public class Main {
	public static final Scanner scanner = new Scanner(System.in);

	public static ArrayList<Integer> getTicketNumbers(int n, int m, int[] ids) {
		ArrayList<Integer> tickets = new ArrayList<>();

		TicketTable table = new TicketTable(n);

		for(int i = 0; i < m; i += 1) {
			tickets.add(table.findEmptyIndexByUserId(ids[i]));
		}
		return tickets;
	}

	public static void main(String[] args) throws Exception {
		int n = scanner.nextInt(); // 전체 티켓의 수
		int m = scanner.nextInt(); // 요청 고객의 수

		int[] ids = new int[m];

		for(int i = 0; i < m; i += 1) {
			ids[i] = scanner.nextInt();
		}

		ArrayList<Integer> tickets = getTicketNumbers(n, m, ids);

		for(int index : tickets){
			System.out.println(index);
		}
	}

}


class TicketTable {
	private final boolean[] used;
	public final int length;

	public TicketTable(int length) {
		this.length = length;
		this.used = new boolean[length];
	}

	// 사용자의 회원 번호로 지급받게 될 행운권 번호를 계산하는 메소드
	public int findEmptyIndexByUserId(int userId) {
		int index = userId % length;
		while(isEmpty(index)) {
			index = (index + 1) % length;
		}
		setUsed(index, true);
		return index;
	}

	// 해당 행운권 번호가 이미 사용 중인지 여부를 반환하는 메소드
	public boolean isEmpty(int ticketIndex) {
		return used[ticketIndex];
	}

	// 티켓 사용 여부를 갱신하기 위한 메소드
	public void setUsed(int index, boolean status) {
		used[index] = status;
	}
}