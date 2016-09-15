import java.math.BigInteger;


public class PaillierTest {

    static void PaillierTest(){
	PaillierSecKey sk = new PaillierSecKey(1024);
	PaillierPubKey pk = new PaillierPubKey(sk);

	BigInteger m1 = new BigInteger("3");
	BigInteger m2 = new BigInteger("-3");
	BigInteger r = new BigInteger("2");

	BigInteger c1 = pk.Encrypt(m1, r);
	BigInteger c2 = pk.Encrypt(m2, r);

	System.out.println("Dec(E(3)) = " + sk.Decrypt(c1));
	System.out.println("Dec(E(-3)) = " + sk.Decrypt(c2));
    }


    public static void main(String[] args){
	PaillierTest();
    }
}