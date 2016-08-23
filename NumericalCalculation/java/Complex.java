
public class Complex {
    private double Re;
    private double Im;

    public Complex(){

    }

    public Complex(double Re, double Im){
	this.Re = Re;
	this.Im = Im;
    }

    public void setRe(double Re){
	this.Re = Re;
    }

    public void setIm(double Im){
	this.Im = Im;
    }

    public double getRe(){
	return this.Re;
    }

    public double getIm(){
	return this.Im;
    }

    public Complex add(Complex b){
	Complex c = new Complex();
	c.setRe(this.Re + b.getRe());
	return c;
    }

}