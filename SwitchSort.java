//Yiwen Zhang 201825695
class SwitchSort{

static int[] SwitchSort(int[] x){
  int len = x.length - 1;
  for(int k = len; k > 0; k--){
    for(int i = 0; i < k; i ++){
      if(x[i] > x[i + 1]){
        int key = x[i];
        x[i] = x[i + 1];
        x[i + 1] = key;
      }
    }
  }return x;
}

public static void main(String args[]){
  int[] seq = new int[args.length];
  System.out.print("Before sorting:");
  for(int i = 0; i < args.length; i ++){
    seq[i] = Integer.parseInt(args[i]);
    System.out.print(" " + seq[i]);
  }
  System.out.println();
  SwitchSort(seq);
  System.out.print("After sorting:");
  for(int j = 0; j < seq.length; j++){
    System.out.print(" " + seq[j]);
  }
  System.out.println();
}

}
