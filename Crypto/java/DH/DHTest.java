import java.math.BigInteger;

public class DHTest {

    public static void DHTest(){
	BigInteger a = BigInteger.valueOf(2), b = BigInteger.valueOf(3); // random value
	BigInteger g = BigInteger.valueOf(2), p = BigInteger.valueOf(1021); // (g, p) is a public, p is a prime number

	DHUser Alice = new DHUser(a);
	DHUser Bob = new DHUser(b);

	BigInteger Ka = Alice.sendKey(g, p);
	BigInteger Kb = Bob.sendKey(g, p);

	System.out.println("(Ka, Kb) : (" + Ka + ", " + Kb + ")");
	
	Alice.setKey(Kb);
	Bob.setKey(Ka);

	Alice.setSharedKey(p);
	Bob.setSharedKey(p);

	System.out.println("Alice's shared key value: " + Alice.getSharedKey() );
	System.out.println("Bob's shared key value: " + Bob.getSharedKey() );
    }

    public static void main(String[] args){
	DHTest();
    }

}