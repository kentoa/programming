import java.math.BigInteger;

public class PaillierPubKey {
    private BigInteger n;
    private BigInteger g;
    private BigInteger squareN;

    PaillierPubKey(PaillierSecKey sk){
	this.n = sk.getN();
	this.g = sk.getG();
	this.squareN = sk.getSquareN();
    }
    
    BigInteger Encrypt(BigInteger m, BigInteger r){
	BigInteger c = (g.modPow(m, squareN)).multiply(r.modPow(n, squareN));
	c = c.mod(squareN);
	
	return c;
    }

    BigInteger getN(){
	return n;
    }

    BigInteger getG(){
	return g;
    }

    BigInteger getSquareN(){
	return squareN;
    }
    
}