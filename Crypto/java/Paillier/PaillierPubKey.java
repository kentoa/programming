import java.math.BigInteger;

public class PaillierPubKey {
    private BigInteger n;
    private BigInteger g;
    private BigInteger square_n;

    PaillierPubKey(BigInteger n){
	this.n = n;
	this.g = n.add(BigInteger.ONE);
	this.square_n = n.multiply(n);
    }
    
    BigInteger encrypt(BigInteger m){
	BigInteger c = (g.modPow(m, square_n)).multiply(r.modPow(n));
	c = c.mod(square_n);
	
	return c;
    }

    BigInteger getN(){
	return n;
    }

    BigInteger getG(){
	return g;
    }

    BigInteger getSquareN(){
	return square_n;
    }
    
}
