// Yiwen Zhang LSE ID:201825695
// input one argument n, find the next prime number.
class PrimeAtLeast{
  static boolean isprime(int n){
    boolean flag = true;
    if(n == 1){
      flag = false;
    }else if(n == 2){
      flag = true;
    }else{
      for(int i = 2; i <= Math.sqrt(n); i ++){
        if(n % i == 0){
          flag = false;
        }
      }
    }
    return flag;
  }

  public static void main(String[] args){
    int n = Integer.parseInt(args[0]);
    int k = n;
    while(n <= k){
      if(isprime(k)){
        System.out.println(k + " is the nearest next prime.");
        break;
      }else{k++;}
    }
  }
}
