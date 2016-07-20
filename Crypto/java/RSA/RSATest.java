import java.math.BigInteger;

public class RSATest {

    static void RSATest(){
	BigInteger p = BigInteger.valueOf(5), q = BigInteger.valueOf(7);
	BigInteger n = p.multiply(q), e = BigInteger.valueOf(5); // public key
	BigInteger phi = (p.subtract(BigInteger.ONE)).multiply(q.subtract(BigInteger.ONE));	

	BigInteger m = BigInteger.valueOf(2); // plain text
	System.out.println("m = " + m);

	RSAPubKey pk = new RSAPubKey(n, e);
	System.out.println("pk: (n, e) = " + "(" + pk.getN() + ", " + pk.getE() + ")");

	BigInteger c = pk.Encrypt(m);
	System.out.println("c = " + c);

	RSASecKey sk = new RSASecKey(phi, n, e); // if e | (p-1)(q-1), error!

	m = sk.Decrypt(c);
	System.out.println("m = " + m);
    }

    public static void main(String[] args){
	RSATest();
    }
}