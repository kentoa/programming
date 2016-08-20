
public class Matrix {
    private double[][] matrix;

    public Matrix(){

    }

    public Matrix(double[][] matrix){
	int row = matrix.length, col = matrix[0].length;
	this.matrix = new double[row][col];

	for(int i = 0; i < row; i++){
	    for(int j = 0; j < col; j++){
		this.matrix[i][j] = matrix[i][j];
	    }
	}
    }

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

    public void print(){
	int row = this.matrix.length;
	int col = this.matrix[0].length;

	for(int i = 0; i < row; i++){
	    for(int j = 0; j < col; j++){
		System.out.print(this.matrix[i][j] + " ");
	    }
	    System.out.println();
	}
    }

    public Matrix add(Matrix A, Matrix B){
	int rowA = A.getRow(), rowB = B.getRow();
	int colA = A.getCol(), colB = B.getCol();	
	Matrix C = new Matrix(rowA, colA);

	if(rowA != rowB || colA != colB){
	    System.out.println("Matrix Size is not match");
	    System.exit(1);
	}
	else{
	    for(int i  = 0; i < rowA; i++){
		for(int j = 0; j < colA; j++){
		    C.setVal(i, j, A.getVal(i, j) + B.getVal(i, j));
		}
	    }
	}
	return C;
    }

    public Matrix sub(Matrix A, Matrix B){
	int rowA = A.getRow(), rowB = B.getRow();
	int colA = A.getCol(), colB = B.getCol();	
	Matrix C = new Matrix(rowA, colA);

	if(rowA != rowB || colA != colB){
	    System.out.println("Matrix size is not match");
	    System.exit(1);
	}
	else{
	    for(int i  = 0; i < rowA; i++){
		for(int j = 0; j < colA; j++){
		    C.setVal(i, j, A.getVal(i, j) - B.getVal(i, j));
		}
	    }
	}
	return C;
    }

    public Matrix mul(Matrix A, Matrix B){
	int rowA = A.getRow(), rowB = B.getRow();
	int colA = A.getCol(), colB = B.getRow();
	Matrix C = A.zeros(rowA, colB);
	
	if(colA != rowB){
	    System.out.println("Matrix size is not match");
	    System.exit(1);
	}else{
	    for(int i = 0; i < rowA; i++){
		for(int k = 0; k < colB; k++){
		    for(int j = 0; j < colA; j++){
			C.setVal(i, k, C.getVal(i, k) + (A.getVal(i, j) * B.getVal(j, k)));
		    }
		}
	    }
	}
	return C;
    }

    public Matrix transpose(Matrix A){
	int row = A.getRow(), col = A.getCol();
	Matrix T = new Matrix(col, row);
	
	for(int i = 0; i < row; i++){
	    for(int j = 0; j < col; j++){
		T.setVal(j, i, A.getVal(i, j));
	    }
	}
	return T;
    }
    
}