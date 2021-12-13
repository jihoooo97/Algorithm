import java.io.*;
import java.lang.*;
import java.util.*;

public class Main {
	public static final Scanner scanner = new Scanner(System.in);

	public static int getMax(int a, int b) {
		if(a >= b) {
			return a;
		} else {
			return b;
		}
	}

	public static void main(String[] args) throws Exception {
		int a = scanner.nextInt();
		int b = scanner.nextInt();
			
		int max = getMax(a, b);
		
		System.out.printf("%d", max);
		// println 마지막에 줄바꿈을 포함. 자료형 표현 불가
		// printf 복잡한 자료형을 추가할 수 %f, %d 
		// print 자료형 표현 부가 간단히 자료형을 사용하지 않을거면 print를 사용하는게 빠르다.
		
	}
}
