import java.math.BigInteger;
import java.util.Random;

public class PaillierSecKey {
    private BigInteger p;
    private BigInteger q;
    private BigInteger lambda;

    // param for public key
    private BigInteger n;
    private BigInteger g;
    private BigInteger squareN;

    PaillierSecKey(BigInteger bit){
	long seed = 149L;
	Random rnd = new Random(seed);

	this.p = BigInteger.probablePrime(bit, rnd);
	this.q = BigInteger.probablePrime(bit, rnd);
	this.n = p.multiply(q);
	this.squareN = n.multiply(n);
    }

    


}