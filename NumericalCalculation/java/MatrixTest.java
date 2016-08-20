
public class MatrixTest {
    static double[][] a = {{1, 2}, {3, 4}};
    static double[][] b = {{5, 6}, {7, 8}};

    static Matrix A = new Matrix(a);
    static Matrix B = new Matrix(b);
    static Matrix mat = new Matrix();	

    public static void EyeTest(){
	Matrix E = mat.eye(2, 3);
	E.print();
    }

    public static void AddTest(){
	Matrix C = mat.add(A, B);
	C.print();
    }

    public static void SubTest(){
	Matrix C = mat.sub(A, B);
	C.print();
    }

    public static void MulTest(){
	Matrix C = mat.mul(A, B);
	C.print();
    }    

    public static void main(String[] args){
	// EyeTest();
	// AddTest();
	// SubTest();
	MulTest();
    }
}