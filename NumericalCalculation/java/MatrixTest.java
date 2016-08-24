
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
	Matrix C = A.add(B);
	C.print();
    }

    public static void SubTest(){
	Matrix C = A.sub(B);
	C.print();
    }

    public static void MulTest(){
	Matrix C = A.mul(B);
	C.print();
    }    

    public static void TransTest(){
	double[][] t = {{1, 2, 3}, {4, 5, 6}};
	Matrix T = new Matrix(t);
	T = T.transpose();
	T.print();
    }
    
    public static void VerCatTest(){
	Matrix C = A.vercat(B);
	C.print();
    }

    public static void HorzCatTest(){
	Matrix C = A.horzcat(B);
	C.print();
    }

    public static void main(String[] args){
	// EyeTest();
	// AddTest();
	// SubTest();
	// MulTest();
	// TransTest();
	// VerCatTest();
	HorzCatTest();
    }
}