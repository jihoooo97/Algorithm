import java.io.*;
import java.lang.*;
import java.util.*;

public class Main {
	public static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int n = scanner.nextInt();
		Point2D[] points = new Point2D[n];

		for(int i = 0 ; i < n; i+= 1) {
			int x=  scanner.nextInt();
			int y=  scanner.nextInt();
			points[i] = new Point2D(x, y);
		}
		
		int minDif = Integer.MAX_VALUE;
		int count = 0;
		
		for(int i = 0; i < n - 1; i += 1) {
			for(int j = i + 1; j < n; j += 1) {
				int dis = points[i].getSquaredDistanceTo(points[j]);
				if(dis < minDif) {
					minDif = dis;
					count = 0;
				}
				if(dis == minDif) {
					count += 1;
				}
			}
		}
		System.out.printf("%.1f\n", Math.sqrt(minDif));
		System.out.print(count);
	}
}

class Point2D{
	int x;
	int y;

	public Point2D(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getSquaredDistanceTo(Point2D target) {
		int dx = this.x - target.x;
		int dy = this.y - target.y;
		
		return dx * dx + dy * dy;
	}

	public double getDistanceTo(Point2D target) {
		return Math.sqrt(getSquaredDistanceTo(target));
	}

}
