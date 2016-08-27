
public class Complex {
    private double re;
    private double im;

    public Complex(){
	this.re = 0;
	this.im = 0;
    }

    public Complex(double re, double im){
	this.re = re;
	this.im = im;
    }

    public void setRe(double re){
	this.re = re;
    }

    public void setIm(double im){
	this.im = im;
    }

    public double getRe(){
	return this.re;
    }

    public double getIm(){
	return this.im;
    }

    public Complex add(Complex b){
	return new Complex(this.re + b.getRe(), this.im + b.getIm());
    }

    public Complex sub(Complex b){
	return new Complex(this.re - b.getRe(), this.im - b.getIm());
    }

    public Complex mul(Complex b){
	Complex c = new Complex();

	c.setRe(this.re * b.getRe() - this.im * b.getIm());
	c.setIm(this.re * b.getIm() + this.im * b.getRe());
	return c;
    }

    public Complex conjugate(){
	return new Complex(getRe(), -getIm());
    }

    public void print(){
	System.out.println("value of complex number: " + getRe() + " + " + getIm() + "i");
    }

}