
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
	int row = getRow();
	int col = getCol();

	for(int i = 0; i < row; i++){
	    for(int j = 0; j < col; j++){
		System.out.print(getVal(i, j) + " ");
	    }
	    System.out.println();
	}
    }

    public Matrix add(Matrix A){
	int row = getRow(), rowA = A.getRow();
	int col = getCol(), colA = A.getCol();	
	Matrix C = new Matrix(row, col);

	if(row != rowA || col != colA){
	    System.out.println("Matrix Size is not match");
	    System.exit(1);
	}
	else{
	    for(int i  = 0; i < row; i++){
		for(int j = 0; j < col; j++){
		    C.setVal(i, j, getVal(i, j) + A.getVal(i, j));
		}
	    }
	}
	return C;
    }

    public Matrix sub(Matrix A){
	int row = getRow(), rowA = A.getRow();
	int col = getCol(), colA = A.getCol();	
	Matrix C = new Matrix(rowA, colA);

	if(row != rowA || col != colA){
	    System.out.println("Matrix size is not match");
	    System.exit(1);
	}
	else{
	    for(int i  = 0; i < row; i++){
		for(int j = 0; j < col; j++){
		    C.setVal(i, j, getVal(i, j) - A.getVal(i, j));
		}
	    }
	}
	return C;
    }

    public Matrix mul(Matrix A){
	int row = getRow(), rowA = A.getRow();
	int col = getCol(), colA = A.getCol();
	Matrix C = zeros(row, colA);
	
	if(col != rowA){
	    System.out.println("Matrix size is not match");
	    System.exit(1);
	}else{
	    for(int i = 0; i < row; i++){
		for(int k = 0; k < colA; k++){
		    for(int j = 0; j < col; j++){
			C.setVal(i, k, C.getVal(i, k) + (getVal(i, j) * A.getVal(j, k)));
		    }
		}
	    }
	}
	return C;
    }

    public Matrix transpose(){
	int row = getRow(), col = getCol();
	Matrix T = new Matrix(col, row);
	
	for(int i = 0; i < row; i++){
	    for(int j = 0; j < col; j++){
		T.setVal(j, i, getVal(i, j));
	    }
	}
	return T;
    }

    public Matrix vercat(Matrix A, Matrix B){ // vertically concatenate A and B
	int rowA = A.getRow(), rowB = B.getRow();
	int colA = A.getCol(), colB = B.getCol();
	Matrix C = new Matrix(rowA + rowB, colA);
	
	if(colA != colB){
	    System.out.println("column size is not match");
	    System.exit(1);
	}else{
	    for(int i = 0; i < rowA; i++){
		for(int j = 0; j < colA; j++){
		    C.setVal(i, j, A.getVal(i, j));
		}
	    }
	    
	    for(int i = 0; i < rowB; i++){
		for(int j = 0; j < colB; j++){
		    C.setVal(i + rowA, j, B.getVal(i, j));
		}
	    }
	}
	return C;
    }

    public Matrix horzcat(Matrix A, Matrix B){ // concatenate A and B
	int rowA = A.getRow(), rowB = B.getRow();
	int colA = A.getCol(), colB = B.getCol();
	Matrix C = new Matrix(rowA, colA + colB);
	
	if(rowA != rowB){
	    System.out.println("column size is not match");
	    System.exit(1);
	}else{
	    for(int i = 0; i < rowA; i++){
		for(int j = 0; j < colA; j++){
		    C.setVal(i, j, A.getVal(i, j));
		}
	    }
	    
	    for(int i = 0; i < rowB; i++){
		for(int j = 0; j < colB; j++){
		    C.setVal(i, j + colA, B.getVal(i, j));
		}
	    }
	}
	return C;
    }
    
}