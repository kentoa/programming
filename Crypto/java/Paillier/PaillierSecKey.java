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

    PaillierSecKey(int bit){
	keyGen(bit);
	this.lambda = lcm(p.subtract(BigInteger.ONE), q.subtract(BigInteger.ONE));
	this.n = p.multiply(q);
	this.squareN = n.multiply(n);
	this.g = n.add(BigInteger.ONE);
    }

    BigInteger getN(){
	return n;
    }

    BigInteger getSquareN(){
	return squareN;
    }

    BigInteger getG(){
	return g;
    }

    void keyGen(int bit){
	long seed = 149L;
	Random rnd = new Random(seed);
	
	this.p = BigInteger.probablePrime(bit, rnd);
	this.q = BigInteger.probablePrime(bit, rnd);
    }
    
    BigInteger Decrypt(BigInteger c){
	BigInteger m;
	BigInteger fc = c.modPow(lambda, squareN);
	BigInteger fg = g.modPow(lambda, squareN);
	
	fc = fc.subtract(BigInteger.ONE);
	fg = fg.subtract(BigInteger.ONE);	
	fc = fc.divide(n);
	fg = fg.divide(n);

	m = fc.multiply(fg.modInverse(n));
	m = m.mod(n);

	if(m.multiply(new BigInteger("2")).compareTo(n) == 1){ // if n/2 < m, m= m - n
	    m = m.subtract(n);
	}

	return m;
    }    

    BigInteger lcm(BigInteger p, BigInteger q){
        BigInteger pq = p.multiply(q);
	BigInteger gcd = p.gcd(q);

	return pq.divide(gcd);
    }

}