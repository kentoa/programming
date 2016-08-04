import java.math.BigInteger;

public class RabinPubKey {
    private BigInteger B; // 0 <= B <= n - 1
    private BigInteger n; // n = p * q (p = q = 3 mod 4 だと復号処理が簡易化される)

    RabinPubKey(BigInteger B, BigInteger n){
	this.B = B;
	this.n = n;
    }

    public BigInteger Encrypt(BigInteger x){
	BigInteger c = x.multiply(x.add(this.B)).mod(n);
	return c;
    }

}