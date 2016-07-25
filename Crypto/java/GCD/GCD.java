import java.math.BigInteger;

public class GCD {

    BigInteger gcd(BigInteger a, BigInteger b){
	BigInteger res, tmp;

	if(a.compareTo(b) == -1){
	    tmp = b;
	    b = a;
	    a = tmp;
	}
	
	if(b.compareTo(BigInteger.ZERO) == 0){
	    return a;
	}
	else if(b.compareTo(BigInteger.ONE) == 0){
	    return BigInteger.ONE;
	}
	else
	    return gcd(b, a.mod(b));
    }

}