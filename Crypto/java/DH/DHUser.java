import java.math.BigInteger;

public class DHUser {
    private BigInteger r; // random secret number
    private BigInteger K; // recieved key
    private BigInteger SharedKey; // share key

    DHUser(BigInteger r){
	this.r = r;
    }

    public BigInteger sendKey(BigInteger g, BigInteger p){
	BigInteger K = g.modPow(this.r, p);
	return K;
    }

    public void setKey(BigInteger K){
	this.K = K;
    }

    public void setSharedKey(BigInteger p){
	this.SharedKey = this.K.modPow(this.r, p);
    }

    public BigInteger getSharedKey(){
	return this.SharedKey;
    }
}