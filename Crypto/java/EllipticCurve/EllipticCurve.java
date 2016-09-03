import java.math.BigInteger;

public class EllipticCurve {
    private BigIntger a;
    private BigInteger b;
    private BigInteger p; // prime number, 5 <= p 
   
    EllipticCurve(){
	
    }

    EllipticCurve(BigInteger a, BigInteger b, BigInteger p){
	this.a = a;
	this.b = b;
	this.p = p;
    }

    /*
    public boolean checkEC(){ // 暗号に利用可能かの判定
	boolean flag = true;

	if(p.compareTo(new BigInteger("5")) == -1 || (a.multiply(a)).compareTo(BigInteger.ZERO) != 0){
	
	}

	return flag;
    }
    */
    

}