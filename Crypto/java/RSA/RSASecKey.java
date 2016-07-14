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
	BigInteger m;
	
	m =  c.modPow(this.d, this.n);
	
	return m;
    }

    public static void RSASecKeyTest(){
	BigInteger p = BigInteger.valueOf(5), q = BigInteger.valueOf(7);
	BigInteger e = BigInteger.valueOf(5), c = BigInteger.valueOf(32);

	RSASecKey sk = new RSASecKey(p, q, e); // if e | (p-1)(q-1), error!
	System.out.println("d = " + sk.getD());

	BigInteger m = sk.Decrypt(c);
	System.out.println("m = " + m);
    }

    public static void main(String[] args) throws ArithmeticException{
	RSASecKeyTest();
    }

}