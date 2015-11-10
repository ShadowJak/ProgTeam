import java.util.*;

public class symm {
	
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		
		ArrayList<Matrix> list = new ArrayList<Matrix>();
		
		while (true) {
			int n = in.nextInt();
			if (n == 0) {
				break;
			}
			
			char[][] matrix = new char[n][n];
			for (int y = 0; y < n; y++) {
				for (int x = 0; x < n; x++){
					matrix[y][x] = in.next().charAt(0);
				}
			}
			
			int k = in.nextInt();
			int[] diagonals = new int[k];
			for (int x = 0; x < k; x++) {
				diagonals[x] = in.nextInt();
			}
			
			Matrix temp = new Matrix(n, matrix, k, diagonals);
			list.add(temp);
		}
		
		for (int x = 0; x < list.size(); x++) {
			System.out.println("Input matrix #" + (x + 1) + ":");
			list.get(x).printMatrix();
			list.get(x).printDiagonals();
			System.out.print("\n");
		}
	}
}

class Matrix {
	private int n;
	private char[][] matrix;
	private int k;
	private int[] diagonals;
	
	public Matrix (int n, char[][] matrix, int k, int[] diagonals) {
		this.n = n;
		this.matrix = matrix;
		this.k = k;
		this.diagonals = diagonals;
	}
	
	public void printInfo() {
		System.out.println(n);
		System.out.println(Arrays.toString(matrix[0]));
		System.out.println(k);
		System.out.println(Arrays.toString(diagonals));
	}
	
	public void printMatrix() {
		for (int y = 0; y < n; y++) {
			for (int x = 0; x < n; x++) {
				System.out.print(matrix[y][x] + " ");
			}
			System.out.print("\n");
		}
	}
	
	public void printDiagonals() {
		for (int diagonal : diagonals) {
			System.out.println("Symmetric diagonals " + diagonal);
			int tempDiag = diagonal;
			if (tempDiag != 1) {
				int y = 0;
				int x = tempDiag - 1;
				while (x < n) {
					System.out.print(matrix[y++][x++] + " ");
				}
				System.out.print("\n");
			}
			int y = tempDiag - 1;
			int x = 0;
			while (y < n) {
				System.out.print(matrix[y++][x++] + " ");
			}
			System.out.print("\n");
		}
	}
	
}