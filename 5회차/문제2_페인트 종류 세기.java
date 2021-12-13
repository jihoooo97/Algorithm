import java.io.*;
import java.lang.*;
import java.util.*;

public class Main {
	public static final Scanner scanner = new Scanner(System.in);
	public static final int MAX_SEAT_NUMBER = 1000;
	public static final int MAX_COLOR_NUMBER = 100;

	public static void solve(int n, int m, Painting[] paintings) {
		int[] seats = new int[n]; //seats[i] := i번 좌석의 최종 색상
		int minColor = seats[0]; //가장 적게 등장한 색상
		int maxColor = seats[0]; //가장 많이 등장한 색상

		// 좌석에 페인트칠
		for(Painting p : paintings) {
			for(int i = p.left; i <= p.right; i += 1) {
				seats[i] = p.color;
			}
		}
		
		int[] colors = new int[MAX_COLOR_NUMBER];
		
		// 컬러 번호 인덱스 값 누적 (좌석색이 0이면 color[0]의 카운트 증가)
		for(int i = 0 ; i < n; i += 1) {
			colors[seats[i]] += 1;
		}
		
		//최대 최소 페인트 카운트
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		
		for(int i = 0 ; i < MAX_COLOR_NUMBER; i += 1) {
			if(max < colors[i]) {
				max = colors[i];
				maxColor = i;
			}
			
			if(min > colors[i] && colors[i] != 0) {
				min = colors[i];
				minColor = i;
			}
		}
		
		
		System.out.println(maxColor);
		System.out.println(minColor);
	}

	public static void main(String[] args) throws Exception {
		// 좌석의수
		int n = scanner.nextInt();
		// 방법
		int m = scanner.nextInt();

		//paintings[i] := i번째에 일어난 색칠 이벤트의 정보
		Painting[] paintings = new Painting[m];

		for(int i = 0; i < m; i += 1) {
			// 좌석의 번호는 1번부터 시작하므로, 0 ~ (n-1)범위로 맞추기 위하여 1씩 빼준다
			int left = scanner.nextInt() - 1;
			int right = scanner.nextInt() - 1;
			int color = scanner.nextInt();
			paintings[i] = new Painting(left, right, color);
		}

		solve(n, m, paintings);
	}

}

//좌석들을 한 번 색칠하는 이벤트에 대한 정보
class Painting {
	public int left;
	public int right;
	public int color;

	// 생성자
	Painting(int left, int right, int color) {
		this.left = left;
		this.right = right;
		this.color = color;
	}
}