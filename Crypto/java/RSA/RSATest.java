import java.math.BigInteger;

public class RSATest {

    RSATest(){}

    static void RSATest(){
	BigInteger p = BigInteger.valueOf(5), q = BigInteger.valueOf(7);
	BigInteger e = BigInteger.valueOf(5), M = BigInteger.valueOf(2);
	
	System.out.println("M = " + M);

	RSAPubKey pk = new RSAPubKey(p, q, e);
	
	System.out.println("pk: (n, e) = " + "(" + pk.getN() + ", " + pk.getE() + ")");

	BigInteger C = pk.Encrypt(M);
	
	System.out.println("C = " + C);

	RSASecKey sk = new RSASecKey(p, q, e); // if e | (p-1)(q-1), error!
	
	System.out.println("sk: d = " + sk.getD());

	BigInteger DecC = sk.Decrypt(C);
	
	System.out.println("M = " + DecC);
    }

    public static void main(String[] args){
	RSATest();
    }
}