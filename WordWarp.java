//input: n and a sentence
//output: words in this sentence which length is no longer than n.
class WordWarp{

  public static void main(String[] args){
    int n = Integer.parseInt(args[0]), wordlength, i, j;
    if(args[1].length() > n){
      return;
    }// determine whether the first word is longer than n.
    for(i = 1; i <= args.length; i = i + j - 1){
      wordlength = args[i].length();
      for(j = i + 1; wordlength <= n; j++){
        wordlength = wordlength + args[j].length();
        System.out.print(args[j - 1] + " ");
      }// the second iteration to add length and determine length <= n.
      System.out.print("\n");
    }//the first iteration to figure the first word of every line
  }
}
