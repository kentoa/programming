import java.math.BigInteger;

public class LElgamalTest {

    static void LElgamalTest(){
	BigInteger p, g, x, y, r, h, m1, m2; // pk(p, g, y), sk(x)
	
	p = BigInteger.valueOf(9991);
	g = BigInteger.valueOf(2);
	x = BigInteger.valueOf(3);
	y = g.modPow(x, p);
	r = BigInteger.valueOf(2);
	h = BigInteger.valueOf(2);
	m1 = BigInteger.valueOf(5);
	m2 = BigInteger.valueOf(3);

	BigInteger[] param = {p, g, x, y, r, h};
	
	System.out.print("[ p g x y r h ] = [ ");
	for(int i = 0, end = param.length; i < end; i++){
	    System.out.print(param[i] + " ");
	}
	System.out.println("]");
	System.out.println("(m1, m2) = (" + m1 + ", " + m2 + ")");

	LElgamalPubKey pk = new LElgamalPubKey(p, g, h, y);
	BigInteger c1[] = pk.Encrypt(m1, r);
	System.out.println("C1(c1, c2) = " + c1[0] + ", " +c1[1]);
	
	BigInteger c2[] = pk.Encrypt(m2, r);
	System.out.println("C2(c1, c2) = " + c2[0] + ", " +c2[1]);
	
	BigInteger csum[] = {c1[0].multiply(c2[0]), c1[1].multiply(c2[1])};

	LElgamalSecKey sk = new LElgamalSecKey(x);
	m1 = sk.Decrypt(c1, p, h);
	System.out.println("m1 = " + m1);

	BigInteger msum = sk.Decrypt(csum, p, h); // mの値が大きすぎると復号に時間がかかるはず
	System.out.println("m1 + m2 = " + msum);
    }

    public static void main(String[] args){
	LElgamalTest();
    }

}