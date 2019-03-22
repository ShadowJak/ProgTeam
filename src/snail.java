import java.util.*;

public class snail {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		
		ArrayList<SnailMatrix> list = new ArrayList<SnailMatrix>();
		
		while (true) {
			// m = y; n = x;
			int m = in.nextInt();
			int n = in.nextInt();
			if (m == 0 || n == 0) {
				break;
			}
			
			char[][] matrix = new char[m][n];
			for (int y = 0; y < m; y++) {
				for (int x = 0; x < n; x++) {
					matrix[y][x] = in.next().charAt(0);
				}
			}
			
			SnailMatrix temp = new SnailMatrix(m, n, matrix, m * n);
			list.add(temp);
		}
		for (int x = 0; x < list.size(); x++) {
			System.out.println("Matrix #" + (x + 1) + ":");
			System.out.println("Original:");
			list.get(x).printMatrix();
			System.out.println("Snail:");
			list.get(x).printSnail();		
		}
	}
}

class SnailMatrix {
	// m = y; n = x;
	int m, n;
	char[][] matrix;
	int charCounter;
	
	int leftEnd = 0;
	int topEnd = 0;
	
	public SnailMatrix (int m, int n, char[][] matrix, int charCounter) {
		this.m = m;
		this.n = n;
		this.matrix = matrix;
		this.charCounter = charCounter;
	}
	
	public void printMatrix() {
		for (int y = 0; y < m; y++) {
			for (int x = 0; x < n; x++) {
				System.out.print(matrix[y][x] + " ");
			}
			System.out.print("\n");
		}
	}
	
	public void printSnail() {
		printTop(0, 0, --n);
		System.out.print("\n");
	}
	
	private void printTop(int row, int colStart, int colEnd) {
		for (int x = colStart; x <= colEnd; x++) {
			System.out.print(matrix[row][x] + " ");
			charCounter--;
		}
		System.out.print("\n");
		
		if (charCounter > 0) {
			printRight(colEnd, row + 1, --m);
		}
	}
	
	private void printRight(int col, int rowStart, int rowEnd) {
		for (int y = rowStart; y <= rowEnd; y++) {
			System.out.print(matrix[y][col] + " ");
			charCounter--;
		}
		System.out.print("\n");
		
		if (charCounter > 0) {
			printBottom(rowEnd, --n, leftEnd);
		}
	}
	
	private void printBottom(int row, int colStart, int colEnd) {
		for (int x = colStart; x >= colEnd; x--) {
			System.out.print(matrix[row][x] + " ");
			charCounter--;
		}
		System.out.print("\n");
		
		if (charCounter > 0) {
			printLeft(leftEnd, row - 1, ++topEnd);
		}
		
	}
	
	private void printLeft(int col, int rowStart, int rowEnd) {
		for (int y = rowStart; y >= rowEnd; y--) {
			System.out.print(matrix[y][col] + " ");
			charCounter--;
		}
		System.out.print("\n");
		
		if (charCounter > 0) {
			printTop(topEnd, ++leftEnd, n);
		}
	}
}


