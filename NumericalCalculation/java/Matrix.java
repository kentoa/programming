
public class Matrix {
    private double[][] matrix;

    public Matrix(int row, int col){
	this.matrix = new double[row][col];
    }

    public void setVal(int row, int col, double val){
	this.matrix[row][col] = val;
    }

    public double getVal(int row, int col){
	return this.matrix[row][col];
    }

    public int getRow(){
	return this.matrix.length;
    }

    public int getCol(){
	return this.matrix[0].length;
    }

    public Matrix zeros(int row, int col){
	Matrix A = new Matrix(row, col);
	
	for(int i = 0; i < row; i++){
	    for(int j = 0; j < col; j++){
		A.setVal(i, j, 0);
	    }
	}
	return A;
    }
   
    public Matrix ones(int row, int col){
	Matrix A = new Matrix(row, col);
	
	for(int i = 0; i < row; i++){
	    for(int j = 0; j < col; j++){
		A.setVal(i, j, 1);
	    }
	}
	return A;
    } 
    
    public Matrix eye(int row, int col){
	Matrix A = new Matrix(row, col);
	int val;

	for(int i = 0; i < row; i++){
	    for(int j = 0; j < col; j++){
		val = (i == j)? 1 : 0;
		A.setVal(i, j, val);
	    }
	}
	return A;
    }

    /*
    public Matrix add(Matrix A, Matrix B){
	Matrix C;

	return C;
    }
    */
}