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
}