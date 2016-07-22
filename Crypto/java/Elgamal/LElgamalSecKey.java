import java.math.BigInteger;

public class LElgamalSecKey {
    private BigInteger x; // secret key

    LElgamalSecKey(BigInteger x){
	this.x = x;
    }

    BigInteger Decrypt(BigInteger[] c, BigInteger p, BigInteger h){
	BigInteger hm = BigInteger.ZERO;
	BigInteger c1x = c[0].modPow(this.x, p);
	
	try{
	    hm = (c[1].multiply(c1x.modInverse(p))).mod(p);
	}catch(Exception e){
	    System.out.println("inverse not found");
	    System.exit(1);
	}
	
	BigInteger m = BigInteger.ONE, tmp_h = h;

	while(tmp_h.compareTo(hm) != 0){
	    tmp_h.multiply(h);
	    m.add(BigInteger.ONE);
	}

	return m;
    }
}