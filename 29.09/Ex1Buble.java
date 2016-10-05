import java.util.Arrays;

public class Ex1Buble {

    public static void main(String[] args) {

    	int[] a = {0,2,3,1,2,6,8,-8};
    	boolean isSorted = false;
    	int swap;

    	while(!isSorted) {

    		isSorted=true;

    		for (int i = 0; i < a.length - 1; i++) {

    			if (a[i] > a[i+1]) {

    				swap = a[i+1];
    				a[i+1] = a[i];
    				a[i] = swap;
    				isSorted=false;

    			}
    		}
    	}

    	System.out.print(Arrays.toString(a));

    }
}