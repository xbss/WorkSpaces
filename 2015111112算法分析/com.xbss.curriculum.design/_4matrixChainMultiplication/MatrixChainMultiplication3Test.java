package _4matrixChainMultiplication;

public class MatrixChainMultiplication3Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MatrixChainMultiplication3 matrixChainMultiplication3 = new MatrixChainMultiplication3();
		matrixChainMultiplication3.run();
		System.out.println("min:" + matrixChainMultiplication3.MIN);
		System.out.println("s");
		for (int i = 0; i < matrixChainMultiplication3.S.length; i++) {
			for (int j = 0; j < matrixChainMultiplication3.S[0].length; j++) {
				System.out.printf("%5d", matrixChainMultiplication3.S[i][j]);
			}
			System.out.println();
		}
		System.out.println();
		System.out.println("m");
		for (int i = 0; i < matrixChainMultiplication3.M.length; i++) {
			for (int j = 0; j < matrixChainMultiplication3.M[0].length; j++) {
				System.out.printf("%5d", matrixChainMultiplication3.M[i][j]);
			}
			System.out.println();
		}
		System.out.println();

	}

}
