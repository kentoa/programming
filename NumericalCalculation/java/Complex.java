
public class Complex {
    private double re;
    private double im;

    public Complex(){
	re = 0;
	im = 0;
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
	return re;
    }

    public double getIm(){
	return im;
    }

    public Complex add(Complex b){
	return new Complex(re + b.getRe(), im + b.getIm());
    }

    public Complex sub(Complex b){
	return new Complex(re - b.getRe(), im - b.getIm());
    }

    public Complex mul(Complex b){
	Complex c = new Complex();

	c.setRe(re * b.getRe() - im * b.getIm());
	c.setIm(re * b.getIm() + im * b.getRe());
	return c;
    }

    public Complex div(Complex b){
	Complex c = new Complex();
	double denominator = b.getRe() * b.getRe() + b.getIm() * b.getIm();

	c.setRe((re * b.getRe() + im * b.getIm()) / denominator);
	c.setIm((im * b.getRe() + re * b.getIm()) / denominator);
	return c;
    }

    public Complex conjugate(){
	return new Complex(getRe(), -getIm());
    }

    public double abs(){
	return Math.sqrt(re * re + im * im);
    }

    public double arg(){
	return Math.atan(im / re);
    }

    public void print(){
	System.out.println("a + bi = " + getRe() + " + " + getIm() + "i");
    }

}