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
    
    GA(){
	
    }

    ArrayList<String[]> scanCity(String filepath){
	File file = new File(filepath);
 
	try{
	    FileInputStream fis = new FileInputStream(file);
	    InputStreamReader isr = new InputStreamReader(fis);
	    BufferedReader br = new BufferedReader(isr);
	    String line;
	    private ArrayList point = new ArrayList(); // (x, y)

	    while((line = br.readLine()) != null){
		String[] tmp = line.split(",");
		point.add(tmp);
	    }
	}
	return point;
    }

    void setCityNum(ArrayList<String[]> point){
	this.cityNum = point.size();
    }

    void initCity2D(ArrayList<String[]> point){
	city = new double[cityNum][3];
	    
	for(int i = 0; i < cityNum; i++){
	    city[i][0] = i; // city num
	    city[i][1] = Integer.valueOf(xy.get(i)[0]); // x
	    city[i][2] = Integer.valueOf(xy.get(i)[1]); // y
	}
    }  

	void calcDist(){
	    for(int i = 0; i < cityNum; i++){

	    }
	}
	
}