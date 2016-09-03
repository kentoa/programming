
public class ComplexTest {
    static Complex c1 = new Complex(1, 2);
    static Complex c2 = new Complex(3, 4);

    static void addTest(){
	Complex c = c1.add(c2);
	c.print();
    }

    static void subTest(){
	Complex c = c1.sub(c2);
	c.print();
    }

    static void mulTest(){
	Complex c = c1.mul(c2);
	c.print();
    }

    static void divTest(){
	Complex c = c1.div(c2);
	c.print();
    }

    static void absTest(){
	double abs = c1.abs();
	System.out.println("abs(c1) = " + abs);
    }

    static void conjugateTest(){
	Complex c = c1.conjugate();
	c.print();
    }

    static void argTest(){
	System.out.println(c1.arg());
    }

    public static void main(String[] args){
	// addTest();
	// subTest();
	// mulTest();
	// divTest();
	// absTest();
	// conjugateTest();
	argTest();
    }
}