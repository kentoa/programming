
public class MontecarloTest {

    static void MontecarloTest(){
	int n = 1000000;

	Montecarlo m = new Montecarlo();

	double pi = m.Montecarlo(n);

	System.out.println("(Math.PI, Montecarlo.pi) = (" + Math.PI + ", " + pi + ")");

    }

    public static void main(String[] args){
	MontecarloTest();
    }

}