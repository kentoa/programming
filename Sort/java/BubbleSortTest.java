
public class BubbleSortTest {
    
    static void BubbleSortTest(String FilePath){
	
	BubbleSortTest bst = new BubbleSortTest();
	BubbleSort bs = new BubbleSort();
	
	int[] list = bst.Scan(FilePath);
	
	long start = System.currentTimeMillis();
	
	int[] res = bs.bubble_sort(list);
	
	long end = System.currentTimeMillis();
	
	System.out.println("Execution Time:" + (end - start) / 1000000f + "ms");
	bst.print(res);
	
    }

    int[] Scan(String FilePath){
	ArrayList<Integer> list = new ArrayList<Integer>();
	
	try {
	    BufferedReader br = new BufferedReader(new FileReader(path));
	    String line;

	    while((line = br.readLine()) != null){
		String[] str = line.split(",");
		 
		for(int i = 0; i < str.length; i++){
		    list.add(Integer.parseInt(str[i]));
		}
	    }
	    br.close();
	} catch(IOException ex) {
	    ex.printStackTrace();
	}

	int len = list.size();
	int[] lista = new int[len];

	for(int i = 0; i < len; i++){
	    lista[i] = list.get(i);
	}

	return lista;
    }

    void print(int[] list){
	for(int i = 0, len = list.length; i < len; i++){
	    System.out.print(list[i] + " ");
	}
	System.out.println();
    }
}