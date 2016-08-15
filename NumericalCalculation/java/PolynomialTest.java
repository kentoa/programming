
public class PolynomialTest {

    static void PolynomialTest(){
	int[] a = {1, 2};
	int[] b = {3, 4};

	Polynomial coeffA = new Polynomial(a);
	Polynomial coeffB = new Polynomial(b);

	coeffA.printPolynomial();
	coeffB.printPolynomial();

	// Polynomial coeffAdd = coeffA.AddCoeff(coeffA, coeffB);
	// Polynomial coeffSub = coeffA.SubCoeff(coeffA, coeffB);
	Polynomial coeffMul = coeffA.MulCoeff(coeffA, coeffB);

	
	// coeffAdd.printPolynomial();
	// coeffSub.printPolynomial();
	coeffMul.printPolynomial();

	// Polynomial dfa = coeffA.polyDiff();
	// dfa.printPolynomial();

	int c[] = {2, 3, 1};
	int d[] = {1, 1};

	Polynomial coeffC = new Polynomial(c);
	Polynomial coeffD = new Polynomial(d);

	Polynomial coeffMR = new Polynomial();
	coeffMR = coeffMR.ModularReduction(coeffC, coeffD);

	coeffMR.printPolynomial();

    }

    public static void main(String[] args){
	PolynomialTest();
    }    
}