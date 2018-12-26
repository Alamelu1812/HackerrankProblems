/*
 * An algorithm that modifies the matrix such that if an element in MXN matrix is 0, its 
 * entire row and column are set to 0.
 */


public class ZeroMatrix {
	
	public void nullifyRow(int[][] matrix,int r) {
		for(int c=0;c<matrix[0].length;c++)
			matrix[r][c] = 0;
	}
	
	public void nullifyColumn(int[][] matrix,int c) {
		for(int r=0;r<matrix.length;r++)
			matrix[r][c] = 0;
	}
	
	public void setMatrixToZeroes(int[][] matrix) {
		boolean hasRowZero = false; //variable to hold whether the first row has a zero
		boolean hasColZero = false; //variable to hold whether the first column has a zero
		
		//Checking whether first row has zero
		for(int c=0;c<matrix[0].length;c++) {
			if(matrix[0][c] == 0) {
				hasRowZero = true;
				break;
			}
		}
		
		//Checking whether first column has zero
		for(int r=0;r<matrix.length;r++) {
			if(matrix[r][0] == 0) {
				hasColZero = true;
				break;
			}
		}
		
		//Mark rows and columns that contains a zero
		for(int r=1;r<matrix.length;r++) {
			for(int c=1;c<matrix[0].length;c++) {
				if(matrix[r][c] == 0) {
					matrix[r][0] = 0;
					matrix[0][c] = 0;
				}
			}
		}
		
		//Nullifying Rows
		for(int r=1;r<matrix.length;r++) {
			if(matrix[r][0] == 0) 
				nullifyRow(matrix,r);
		}
		
		//Nullifying Columns
		for(int c=1;c<matrix[0].length;c++) {
			if(matrix[0][c] == 0) 
				nullifyColumn(matrix,c);
		}
		
		//Nullify first row if necessary
		if(hasRowZero)
			nullifyRow(matrix,0);
		
		if(hasColZero)
			nullifyColumn(matrix,0);
	}
	
	public static void main(String[] args) {
		ZeroMatrix object = new ZeroMatrix();
		
		//Creating input for function
		int[][] matrix = new int[3][3];
		int value = 1;
		for(int r=0;r<3;r++) {
			for(int c=0;c<3;c++)
				matrix[r][c] = value++;
		}
		
		matrix[2][2] = 0;
		matrix[0][0] = 0;
		
		System.out.println("Input matrix");
		for(int r=0;r<3;r++) {
			for(int c=0;c<3;c++)
				System.out.print(matrix[r][c]+" ");
			System.out.println();
		}
		
		object.setMatrixToZeroes(matrix);
		
		System.out.println("Output matrix");
		for(int r=0;r<3;r++) {
			for(int c=0;c<3;c++)
				System.out.print(matrix[r][c]+" ");
			System.out.println();
		}
	}

}
