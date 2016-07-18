import java.math.BigInteger;

public class ElgamalSecKey {
    private BigInteger x; // secret key
    private BigInteger p;

    ElgamalSecKey(BigInteger x, BigInteger p){
	this.x = x;
	this.p = p;
    }

    BigInteger Decrypt(BigInteger[] c){
	BigInteger m = BigInteger.ZERO;
	BigInteger c1x = c[0].modPow(this.x, this.p);
	
	try{
	    m = (c[1].multiply(c1x.modInverse(this.p))).mod(this.p);
	}catch(Exception e){
	    System.out.println("inverse not found");
	    System.exit(1);
	}
	
	return m;
    }
}