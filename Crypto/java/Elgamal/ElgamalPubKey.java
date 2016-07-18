import java.math.BigInteger;

public class ElgamalPubKey {
    private BigInteger p, g, y; // pk(g, p, y = g^x mod p)
    
    ElgamalPubKey(BigInteger p, BigInteger g, BigInteger y){
	this.p = p;
	this.g = g;
	this.y = y;
    }

    BigInteger[] Encrypt(BigInteger m, BigInteger r){
	BigInteger[] c = new BigInteger[2];
	
	c[0] = g.modPow(r, this.p);
	c[1] = m.multiply(this.y.modPow(r, this.p)).mod(this.p);

	return c;
    }
}