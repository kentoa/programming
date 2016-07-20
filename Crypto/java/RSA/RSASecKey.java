import java.math.BigInteger;

public class RSASecKey {
    private BigInteger d;
    private BigInteger phi; // φ(pq) = (p - 1)(q - 1)
    private BigInteger n; // n = p * q

    RSASecKey(BigInteger phi, BigInteger n, BigInteger e){
	this.phi = phi;

	try{
	this.d = e.modInverse(phi);
	this.n = n;
	}catch(Exception ex){
	    System.out.println("inverse not found");
	    System.exit(1);
	}
    }

    public BigInteger Decrypt(BigInteger c){
	BigInteger m =  c.modPow(this.d, this.n);
	System.out.println("d = " + this.d);
	return m;
    }
}