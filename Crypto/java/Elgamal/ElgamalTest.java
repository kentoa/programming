import java.math.BigInteger;

public class ElgamalTest {

    static void ElgamalTest(){
	BigInteger p, g, x, y, r, m1, m2; // pk(p, g, y), sk(x)
	
	p = BigInteger.valueOf(1021);
	g = BigInteger.valueOf(2);
	x = BigInteger.valueOf(3);
	y = g.modPow(x, p);
	r = BigInteger.valueOf(4);
	m1 = BigInteger.valueOf(5);
	m2 = BigInteger.valueOf(3);

	BigInteger[] param = {p, g, x, y, r};
	
	System.out.print("[ p g x y r ] = [ ");
	for(int i = 0, end = param.length; i < end; i++){
	    System.out.print(param[i] + " ");
	}
	System.out.println("]");
	System.out.println("(m1, m2) = (" + m1 + ", " + m2 + ")");

	ElgamalPubKey pk = new ElgamalPubKey(p, g, y);
	BigInteger c1[] = pk.Encrypt(m1, r);
	System.out.println("C1(c1, c2) = " + c1[0] + ", " +c1[1]);
	
	BigInteger c2[] = pk.Encrypt(m2, r);
	System.out.println("C2(c1, c2) = " + c2[0] + ", " +c2[1]);
	
	BigInteger cmul[] = {c1[0].multiply(c2[0]), c1[1].multiply(c2[1])};

	ElgamalSecKey sk = new ElgamalSecKey(x, p);
	m1 = sk.Decrypt(c1);
	System.out.println("m1 = " + m1);

	BigInteger mmul = sk.Decrypt(cmul);
	System.out.println("m1 * m2 = " + mmul);
    }

    public static void main(String[] args){
	ElgamalTest();
    }

}