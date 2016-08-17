
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

    public Matrix zeros(int row, int col){
	double[][] matrix = new double[row][col];
	
	for(int i = 0; i < row; i++){
	    for(int j = 0; j < col; j++){
		matrix[i][j] = 0;
	    }
	}
	return matrix;
    }
   
    public Matrix ones(int row, int col){
	double[][] matrix = new double[row][col];
	
	for(int i = 0; i < row; i++){
	    for(int j = 0; j < col; j++){
		matrix[i][j] = 1;
	    }
	}
	return matrix;
    } 
    
    public Matrix eye(int row, int col){
	double[][] matrix = new double[row][col];

	for(int i = 0; i < row; i++){
	    for(int j = 0; j < col; j++){
		matrix[i][j] = (i == j)? 1 : 0;
	    }
	}
    }

}