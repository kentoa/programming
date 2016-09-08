import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class GA {
    private double city[][];
    private double dist[][];
    private double solution[]; // city path
    private int cityNum;
    private int dim; // length of vector
    int start_exchange, end_exchange; // 交叉
    
    GA(){
	
    }

    ArrayList<String[]> scanCity(String filepath){
	File file = new File(filepath);
 
	try{
	    FileInputStream fis = new FileInputStream(file);
	    InputStreamReader isr = new InputStreamReader(fis);
	    BufferedReader br = new BufferedReader(isr);
	    String line;
	    ArrayList<String[]> point = new ArrayList<>(); // (x, y)
	    
	    int row = 0;
	    while((line = br.readLine()) != null && row++ > 6){
		String[] tmp = line.split(",");
		point.add(tmp);
	    }
	}catch(Exception e){
	    System.out.println("can't open the file");
	    System.exit(1);
	}
	return point;
    }

    void setCityNum(ArrayList<String[]> point){
	this.cityNum = point.size();
    }

    void setDim(ArrayList<String[]> point){
	this.dim = point.get(0).length -1;
    }

    void initCity(ArrayList<String[]> point){
	city = new double[cityNum][dim + 1];	    

	setCityNum(point);
	setDim(point);

	for(int i = 0; i < cityNum; i++){
	    for(int j = 0; j < dim + 1; j++){
		city[i][j] = Double.valueOf(point.get(i)[j]); // (citynum, x, y, ...)
	    }
	}  
    }
    
    /*
      void calcDist(){
      double square_x, square_y;
      for(int i = 0; i < cityNum; i++){
      for(int j = 0; j < cityNum; j++){
      if(i == j) dist[i][j] = 0;
      else{
      square_elem += Math.pow(city[i][k] - city[j][1], 2);
      square_y = Math.pow(city[i][2] - city[j][2], 2);
      dist[i][j] = Math.sqrt(square_x + square_y); 
      }
      }
      }
      }
    */
    
    void printCity(){
	for(int i = 0; i < cityNum; i++){
	    for(int j = 0; j < dim + 1; dim++){
		System.out.print(city[i][j] + " ");
	    }
	    System.out.println();
	}
    }
    
    public static void main(String[] args){
	GA ga = new GA();
	ArrayList<String[]> point  = ga.scanCity("/Users/akiyama/Desktop/github/programming/EvolutionalyComputation/tsp/eil51.tsp");
	ga.initCity(point);
	ga.printCity();
    }
    
}