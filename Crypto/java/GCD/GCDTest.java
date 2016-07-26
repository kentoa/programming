import java.math.BigInteger;


public class GCDTest {

    static void gcdTest(){
	BigInteger a = new BigInteger("3");
	BigInteger b = new BigInteger("5");
	BigInteger c = new BigInteger("6");
	BigInteger res;
	GCD process = new GCD();

	res = process.gcd(a, b);
	System.out.println("gcd(3, 5) = " + res);

	res = process.gcd(a, c);
	System.out.println("gcd(3, 6) = " + res);

    }

    public static void main(String[] args){
	gcdTest();
    }
}