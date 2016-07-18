import java.math.BigInteger;

public class ElgamalTest {

    static void ElgamalTest(){
	BigInteger p, g, x, y, r, m; // pk(p, g, y), sk(x)
	
	p = BigInteger.valueOf(1021);
	g = BigInteger.valueOf(2);
	x = BigInteger.valueOf(3);
	y = g.modPow(x, p);
	r = BigInteger.valueOf(4);
	m = BigInteger.valueOf(5);

	BigInteger[] param = {p, g, x, y, r, m};
	
	System.out.print("(p g x y r m) = ");
	for(int i = 0, end = param.length; i < end; i++){
	    System.out.print(param[i] + " ");
	}
	System.out.println();

	ElgamalPubKey pk = new ElgamalPubKey(p, g, y);
	BigInteger c[] = pk.Encrypt(m, r);
	System.out.println("(c1, c2) = " + c[0] + ", " +c[1]);
	
	ElgamalSecKey sk = new ElgamalSecKey(x, p);
	m = sk.Decrypt(c);
	System.out.println("m = " + m);
    }

    public static void main(String[] args){
	ElgamalTest();
    }

}