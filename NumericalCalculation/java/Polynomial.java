import java.util.ArrayList;

public class Polynomial {
    private ArrayList<Integer> coeff = new ArrayList<>(); // f(x) = c0 + c1*x + c2*x^2 + ...

    public void SetCoeff(ArrayList<Integer> coeff){
	int len = coeff.size();
	
	for(int i = 0; i < len; i++){
	    this.coeff.add(coeff.get(i));
	}
    }

    public void SetCoeff(int[] coeff){
	int len = coeff.length;
	
	for(int i = 0; i < len; i++){
	    this.coeff.add(coeff[i]);
	}
    }

    public int getVal(int x){
	int tmp = 1, fx = 0, deg = this.coeff.size();
	ArrayList<Integer> PowerOfX = new ArrayList<>();

	for(int i = 0; i < deg; i++){
	    PowerOfX.add(tmp);
	    tmp *= x;
	}

	for(int i = 0; i < deg; i++){
	    fx += this.coeff.get(i) * PowerOfX.get(i); 
	}
	return fx;
    }

    public int getCoeffAt(int i){
	int ci = this.coeff.get(i); 
	return ci;
    }

    public Polynomial AddCoeff(Polynomial coeffA, Polynomial coeffB){
	Polynomial coeff = new Polynomial();


	return coeff;
    }

}