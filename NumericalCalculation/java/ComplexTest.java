
public class ComplexTest {
    static Complex c1 = new Complex(1, 2);
    static Complex c2 = new Complex(3, 4);

    static void addTest(){
	Complex c = c1.add(c2);
	c.print();
    }

    public static void main(String[] args){
	addTest();
    }
}