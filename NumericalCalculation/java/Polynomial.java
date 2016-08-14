import java.util.ArrayList;

public class Polynomial {
    private ArrayList<Integer> coeff = new ArrayList<>(); // f(x) = c0 + c1*x + c2*x^2 + ...

    public Polynomial(){
    
    }

    public Polynomial(int[] coeff){
	for(int i = 0, len = coeff.length; i < len; i++){
	    setCoeff(coeff[i]);
	}
    }

    public Polynomial(ArrayList<Integer> coeff){
	for(int i = 0, len = coeff.size(); i < len; i++){
	    setCoeff(coeff.get(i));
	}
    }

    public void setCoeff(int coeff){
	this.coeff.add(coeff);
    }

    public int getVal(int x){
	int tmp = 1, fx = 0, deg = getDegree();
	ArrayList<Integer> xval = new ArrayList<>();

	for(int i = 0; i < deg; i++){
	    xval.add(tmp);
	    tmp *= x;
	}

	for(int i = 0; i < deg; i++){
	    fx += this.coeff.get(i) * xval.get(i); 
	}
	return fx;
    }

    public int getCoeffAt(int i){
	int c = this.coeff.get(i); 
	return c;
    }

    public int getDegree(){
	int deg = this.coeff.size();
	return deg;
    }    

    public Polynomial AddCoeff(Polynomial coeffA, Polynomial coeffB){
	Polynomial coeff = new Polynomial();
    
	int degA = coeffA.getDegree(), degB = coeffB.getDegree();
    
	if(degA < degB){
	    for(int i = degA; i < degB; i++){
		coeffA.setCoeff(0);
	    }
	}
	else if(degB < degA){
	    for(int i = degB; i < degA; i++){
		coeffB.setCoeff(0);
	    }
	}
    
	int newdeg = coeffA.getDegree(); 
    
	for(int i = 0; i < newdeg; i++){
	    coeff.setCoeff(coeffA.getCoeffAt(i) + coeffB.getCoeffAt(i));
	}    
	return coeff;
    }

    public Polynomial SubCoeff(Polynomial coeffA, Polynomial coeffB){
	Polynomial coeff = new Polynomial();
	
	int degA = coeffA.getDegree(), degB = coeffB.getDegree();
	
	if(degA < degB){
	    for(int i = degA; i < degB; i++){
		coeffA.setCoeff(0);
	    }
	}
	else if(degB < degA){
	    for(int i = degB; i < degA; i++){
		coeffB.setCoeff(0);
	    }
	}
	
	int newdeg = coeffA.getDegree(); 
	
	for(int i = 0; i < newdeg; i++){
	    coeff.setCoeff(coeffA.getCoeffAt(i) - coeffB.getCoeffAt(i));
	}    
	return coeff;
    }

    public Polynomial MulCoeff(Polynomial coeffA, Polynomial coeffB){
	Polynomial coeffC = new Polynomial();
	int degA = coeffA.getDegree(), degB = coeffB.getDegree();
	int degC = degA + degB - 1;

	for(int i = 0; i < degC; i++){
	    coeffC.setCoeff(0);
	}

	for(int i = 0; i < degA; i++){
	    for(int j = 0; j < degB; j++){
		Polynomial tmp = new Polynomial();
		for(int k = 0; k < i + j; k++){ //ミスがあるので修正する
		    tmp.setCoeff(0);
		}
		tmp.setCoeff(coeffA.getCoeffAt(i) * coeffB.getCoeffAt(j));
		// tmp.printPolynomial(); //debug
		coeffC = AddCoeff(coeffC, tmp);
	    }
	}
	return coeffC;
    }
    
    public Polynomial polyDiff(){ // differentiation
	Polynomial df = new Polynomial();
	int deg = getDegree();

	for(int i = 1; i < deg; i++){
	    df.setCoeff(getCoeffAt(i) * i);
	}
	return df;
    }
    
    public Polynomial ModularReduction(Polynomial coeffA, Polynomial coeffB){
	Polynomial coeff = new Polynomial();
	Polynomial x = new Polynomial();
	int degA = coeffA.getDegree(), degB = coeffB.getDegree();
	int deg, ro;

	if(degA < degB){
	    deg = degB - degA;
	    ro = coeffB.getCoeffAt(degB - 1);
	    
	    for(int i = 0; i < deg; i++){
		x.setCoeff(0);
	    }

	    x.setCoeff(ro);
	    x = MulCoeff(x, coeffA);
	    coeff = SubCoeff(coeffB, x);
	}else{
	    deg = degA - degB;
	    ro = coeffA.getCoeffAt(degA - 1);
	    
	    for(int i = 0; i < deg; i++){
		x.setCoeff(0);
	    }

	    x.setCoeff(ro);
	    x = MulCoeff(x, coeffB);
	    coeff = SubCoeff(coeffA, x);
	}	
	return coeff;
    }

    void printPolynomial(){
	int deg = getDegree();

	System.out.print("[");
	for(int i = 0; i < deg; i++){
	    System.out.print(getCoeffAt(i));
	    if(i != deg - 1) System.out.print(" ");
	}
	System.out.println("]");
    }
}