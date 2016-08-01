public class BubbleSort {
    
    int[] bubbleSort(int[] list){ //ascending order
	int tmp, len = list.length;
	
	for(int i = 0; i < len; i++){
	    for(int j = len - 1; i < j; j--){
		if(list[j] < list[j - 1]){
		    tmp = list[j];
		    list[j] = list[j - 1];
		    list[j - 1] = tmp;
		}
	    }
	}
	return list;
    }
    
}