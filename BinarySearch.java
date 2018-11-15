//Yiwen Zhang 201825695
class BinarySearch{
	static boolean found;
	static int counter;

	public static int binarysearch(long key, int[] x, int i, int j) {
		counter += 1;
		int mid = i + (j - i) / 2;
		if (i == j) {
			if(i >= x.length){
				found = false;
			}else if(x[i] == key){
					found = true;
			}
			return i;
		}
		if (x[mid] >= key) {
			return binarysearch(key, x, i, mid);
		} else {
			return binarysearch(key, x, mid + 1, j);
		}
	}

	public static void printoutput(long key, int[] x, int i, int j){
		int index = binarysearch(key, x, i, j);
		if(found){
			System.out.println("Key " + key + " found at index " + index + ", after " + counter + " binary search interations.");
		}else{
			System.out.println( "Key " + key + " not found, should be at index " + index + ", after " + counter + " binary search interations.");
		}
		counter = 0;
		found = false;
	}


	public static void main(String[] args){
		found = false;
		counter = 0;
		//test1
		int[] array1 = {1, 3, 6, 7, 7, 7, 9};
		System.out.print("Testing a small array: ");
		for(int i = 0; i < array1.length; i ++){
			System.out.print(array1[i] + " ");
		}
		System.out.println();
		printoutput(0, array1, 0, 7);//test1, key 0
		printoutput(1, array1, 0, 7);//test1, key 1
		printoutput(7, array1, 0, 7);//test1, key 7
		printoutput(10, array1, 0, 7);//test1, key 10
		System.out.println();
		//test2
		int[] array2 = new int[10000000];
		for(int j = 0; j < 10000000; j ++){
			array2[j] = j * 2;
		}
		System.out.print("Testing a large array with 100000000 entries: 0 2 4 6 ... 19999998\n");
   	printoutput(5000000, array2, 0, 10000000);//test2, key 5000000
		printoutput(5000001, array2, 0, 10000000);//test2, key 5000001
		System.out.println();
		//test 3
		int[] array3 = new int[10000000];
		for(int l = 0; l < 10000000; l ++){
			array3[l] = 10;
		}
		System.out.print(" Testing a large array with 10000000 indentical entries: 10 10 10 ... 10\n");
		printoutput(10, array3, 0, 10000000);//test3, key 10
		printoutput(9, array3, 0, 10000000);//test3, key 9
		printoutput(11, array3, 0, 10000000);//test3, key 11
  }
}
