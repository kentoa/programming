import java.math.BigInteger;


public class RSAPubKey {
    private BigInteger n, e; // public key
    
    public RSAPubKey(BigInteger p, BigInteger q, BigInteger e){ // Constructor
	this.n = p.multiply(q);
	this.e = e;
    }
    
    public BigInteger getE(){
	return this.e;
    }
    
    public BigInteger getN(){
	return this.n;
    }

    public BigInteger Encrypt(BigInteger m){
	BigInteger c;
	c = m.modPow(this.e, this.n); 
	return c; 
    }
    
    public static void RSAPubKeyTest(){
	BigInteger p = BigInteger.valueOf(5), q = BigInteger.valueOf(7);
	BigInteger e = BigInteger.valueOf(2), m = BigInteger.valueOf(3);
	RSAPubKey pk = new RSAPubKey(p, q, e);
	
	System.out.println("(n, e) = " + "(" + pk.getN() + ", " + pk.getE() + ")");
	
	BigInteger c = pk.Encrypt(m);
	
	System.out.println("c = " + c);
    }
    
    public static void main(String[] args){
	RSAPubKeyTest();
    }
}
