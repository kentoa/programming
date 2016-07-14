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
    
    public static void RSAPubKeyTest(){
	BigInteger p = BigInteger.valueOf(5), q = BigInteger.valueOf(7), e = BigInteger.valueOf(23);
	RSAPubKey pk = new RSAPubKey(p, q, e);
	
	System.out.println("(n, e) = " + "(" + pk.getN() + ", " + pk.getE() + ")");
    }
    
    public static void main(String[] args){
	RSAPubKeyTest();
    }
}
