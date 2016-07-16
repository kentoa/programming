import java.math.BigInteger;

public class RSATest {

    static void RSATest(){
	BigInteger p = BigInteger.valueOf(5), q = BigInteger.valueOf(7);
	BigInteger n = p.multiply(q), e = BigInteger.valueOf(5); // public key
	BigInteger phi = (p.subtract(BigInteger.ONE)).multiply(q.subtract(BigInteger.ONE));	

	BigInteger M = BigInteger.valueOf(2); // plain text
	System.out.println("M = " + M);

	RSAPubKey pk = new RSAPubKey(n, e);
	System.out.println("pk: (n, e) = " + "(" + pk.getN() + ", " + pk.getE() + ")");

	BigInteger C = pk.Encrypt(M);
	System.out.println("C = " + C);

	RSASecKey sk = new RSASecKey(phi, n, e); // if e | (p-1)(q-1), error!
	System.out.println("sk: d = " + sk.getD());

	BigInteger DecC = sk.Decrypt(C);
	System.out.println("M = " + DecC);
    }

    public static void main(String[] args){
	RSATest();
    }
}