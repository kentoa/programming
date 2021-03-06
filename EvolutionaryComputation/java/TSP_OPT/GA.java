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

    void initCity(String filepath){
	File file = new File(filepath);
 
	try{
	    FileInputStream fis = new FileInputStream(file);
	    InputStreamReader isr = new InputStreamReader(fis);
	    BufferedReader br = new BufferedReader(isr);
	    String line;
	    ArrayList<String[]> point = new ArrayList<>(); // (x, y, ...)
	    
	    int row = 0;
	    while((line = br.readLine()) != null){
		
		if(line.equals("EOF")) break;
		
		if(5 < row){
		    String[] tmp = line.split(" ");
		    point.add(tmp);
		}
		row++;
	    }

	    setCityNum(point);
	    System.out.println(cityNum);
	    setDim(point);
	    city = new double[cityNum][dim + 1];    

	    for(int i = 0; i < cityNum; i++){
		for(int j = 0; j < dim + 1; j++){
		    city[i][j] = Double.parseDouble(point.get(i)[j]); // (citynum, x, y, ...)
		}
	    }
	}catch(Exception e){
	    System.out.println("can't open the file");
	    System.exit(1);
	}
    }

    void setCityNum(ArrayList<String[]> point){
	this.cityNum = point.size();
	System.out.println("number of city : " + this.cityNum);
    }

    void setDim(ArrayList<String[]> point){
	this.dim = point.get(0).length - 1;
	System.out.println("number of dimension : " + this.dim);
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
	    for(int j = 0; j < dim + 1; j++){
		System.out.print(city[i][j] + " ");
	    }
	    System.out.println();
	}
    }
    
    public static void main(String[] args){
	GA ga = new GA();
	ga.initCity(args[0]);
	ga.printCity();
    }
    
}