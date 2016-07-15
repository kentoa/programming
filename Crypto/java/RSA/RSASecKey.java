import java.math.BigInteger;

public class RSASecKey {
    private BigInteger d;
    private BigInteger phi; // φ(pq) = (p - 1)(q - 1)
    private BigInteger n; // n = p * q

    RSASecKey(BigInteger p, BigInteger q, BigInteger e){
	this.phi = (p.subtract(BigInteger.ONE)).multiply(q.subtract(BigInteger.ONE));
	try{
	this.d = e.modInverse(phi);
	this.n = p.multiply(q);
	}catch(Exception ex){
	    System.out.println("inverse not found");
	    System.exit(1);
	}
    }

    public BigInteger getD(){
	return this.d;
    }

    public BigInteger Decrypt(BigInteger c){
	BigInteger m =  c.modPow(this.d, this.n);
	return m;
    }
}