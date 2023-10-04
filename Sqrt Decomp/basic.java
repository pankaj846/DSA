
import java.util.*;

public class basic {

	static int block[];
	static int block_size;
	static int org_arr[];

	private static void preprocess(int arr[], int n) {
		int root_n = (int) Math.ceil(Math.sqrt(n));

        block_size = root_n; 
        int block_len = (int)Math.ceil(n/ (double)root_n);

		block = new int[block_len];
		org_arr = arr.clone();
        
		int sum = 0;

		for (int i = 0; i < n; i++) {

			if (i!=0 && i%block_size == 0) {                
				block[ (i / block_size)-1] = sum;  
                System.out.println(sum);              
				sum = 0;
			}
			sum += arr[i];
		}
        block[block_len-1] = sum;
        System.out.println(Arrays.toString(block));
        
	}

	private static int query(int i, int j) {

		int sum = 0;

		for (int idx = i; idx <= j; ) {

			// if we're at initial pos on block, take whole sum of block
			if (idx % block_size == 0 && idx+block_size-1 <= j) {
				sum += block[idx / block_size];
				idx += block_size;
			}

			else {
					sum += org_arr[idx];
                    idx++;
				}		
		}

		return sum;
	}

	public static void main(String args[]) {
		int input[] = { 1, 5, 2, 4, 6, 1, 3, 5, 7, 10 };
		int n = input.length;

		preprocess(input, n);

		System.out.println("query(3, 8) : " + query(3, 8));
		System.out.println("query(1, 6) : " + query(1, 6));
//		update(8, 0);
		System.out.println("query(8, 8) : " + query(8, 8));
	}

}


