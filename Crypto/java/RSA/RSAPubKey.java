import java.math.BigInteger;

public class RSAPubKey {
    private BigInteger n, e; // public key
    
    public RSAPubKey(BigInteger n, BigInteger e){ // Constructor
	this.n = n;
	this.e = e;
    }
    
    public BigInteger getE(){
	return this.e;
    }
    
    public BigInteger getN(){
	return this.n;
    }

    public BigInteger Encrypt(BigInteger m){
	BigInteger c = m.modPow(this.e, this.n); 
	return c; 
    }
}
