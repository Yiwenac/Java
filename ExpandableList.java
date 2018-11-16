public class ExpandableList{
  private int[] value;
  private int entries;

  public ExpandableList(){
    entries = 0;
    value = new int[1];
  }
  //public ExpandableList(int[] numbers){
  //  entries =

  public void print(){
    for(int i = 0; i < entries; i++){
      System.out.print(value[i] + " ");
    }
  }
  public void add(int number){
    if(entries == value.length){
      int[] new_value = new int[2 * value.length];
      for(int i = 0; i < value.length; i++){
        new_value[i] = value[i];
      }
      value = new_value;
      value[entries] = number;
      entries++;
    }
  }
  }
}
