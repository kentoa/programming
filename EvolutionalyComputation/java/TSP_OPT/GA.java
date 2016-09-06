import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class GA {
    private double city[][];
    private double dist[][];
    
    GA(){
	
    }

    void initCity2D(String filepath){
	File file = new File(filepath);
	
	try{
	    FileInputStream fis = new FileInputStream(file);
	    InputStreamReader isr = new InputStreamReader(fis);
	    BufferedReader br = new BufferedReader(isr);
	    String line;
	    ArrayList xy = new ArrayList();

	    while((line = br.readLine()) != null){
		String[] point = line.split(",");
		xy.add(point);
	}

	    int row = xy.size();
	    city = new double[row][2];
	    
	    for(int i = 0; i < row; i++){
		city[i][0] = Integer.valueOf(xy.get(i)[0]);
		city[i][1] = Integer.valueOf(xy.get(i)[1]);
	    }
	}
	
}