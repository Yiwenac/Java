class CountingSort{

  static void countingSort(int[] x){
    //find the biggest entry max of the array.
    for(int i = 0; i < x.length - 1; i++){
      if(x[i + 1] < x[i]){
        int temp = x[i];
        x[i] = x[i + 1];
        x[i + 1] = temp;
      }
    }
    int max = x[x.length - 1];
    //create an int array c of size max + 1 to document the number of elements.
    int[] c = new int[max + 1];
    for(int i = 0; i < x.length; i++){
      c[x[i]]++;
    }
    //put j which c[j] is true into array x.
    int i = 0;
    for(int j = 0; j < max + 1; j++){
      while((c[j] > 0) && (i < x.length)){
        x[i] = j;
        i++;
        c[j]--;
      }
    }
  }


  public static void main(String[] args){
    int[] x = {6, 6, 5, 5, 5, 2, 1};
    outArray(x, "Before sorting: ");
    countingSort(x);
    outArray(x, "After sorting: ");
  }

  static void outArray(int[] x, String info){
    System.out.println(info);
    for(int i = 0; i < x.length; i++){
      System.out.print(x[i] + " ");
    }
    System.out.println();
  }
}
