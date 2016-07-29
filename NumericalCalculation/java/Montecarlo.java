import java.util.Random;

public class Montecarlo {

    double Montecarlo(int n){
	double pi = 0, radius = 1, dist = 0;
	double[] x = new double[n], y = new double[n];
	long seed = 149L;
	Random r = new Random(seed);

	int num_of_points = 0;

	for(int i = 0; i < n; i++){
	    x[i] = r.nextDouble();
	    y[i] = r.nextDouble();

	    dist = Math.pow(x[i], 2) + Math.pow(y[i], 2);

	    if(dist < radius){
		num_of_points++;
	    }
	}

	pi = 4 * (double)num_of_points / n; 
	return pi;
    }

}