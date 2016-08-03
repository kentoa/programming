import java.math.BigInteger;

public class RabinPubKey {
    private BigInteger B; // 0 <= B <= n - 1
    private BigInteger n; // n = p * q (p = q = 3 mod 4 だと復号処理が簡易化される)
    private boolean flag = true; // B != 0

    RabinPubKey(BigInteger B, BigInteger n){
	this.B = B;
	this.n = n;
	
	if(B.compareTo(BigInteger.ZERO) == 0){
	    flag = false;
	}
    }

}