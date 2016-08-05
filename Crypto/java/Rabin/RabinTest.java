import java.math.BigInteger;

public class RabinTest {
    
    static void RabinTest(){
	BigInteger p = new BigInteger("7"), q = new BigInteger("11");
	BigInteger n = p.multiply(q), B = BigInteger.ZERO;

	RabinPubKey pk = new RabinPubKey(B, n);

	BigInteger c = pk.Encrypt(new BigInteger("8"));
	System.out.println("c = " + c);

    }

    public static void main(String[] args){
	RabinTest();
    }

}