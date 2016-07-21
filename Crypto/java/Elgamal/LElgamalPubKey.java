import java.math.BigInteger;

public class LElgamalPubKey {
    private BigInteger p, g, h, y; // pk(g, p, h, y = g^x mod p)
    
    LElgamalPubKey(BigInteger p, BigInteger g, BigInteger h, BigInteger y){
	this.p = p;
	this.g = g;
	this.h = h;
	this.y = y;
    }

    BigInteger[] Encrypt(BigInteger m, BigInteger r){
	BigInteger[] c = new BigInteger[2];
	
	c[0] = g.modPow(r, this.p);
	c[1] = (h.modPow(m, this.p)).multiply(this.y.modPow(r, this.p)).mod(this.p);

	return c;
    }
}