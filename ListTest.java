class ListTest{

  public static void main(String[] args){
    ExpandableList list = new ExpandableList();
    list.print();
    for(int i = 1; i < 100; i++){
      list.add(i);
    }
    list.print();
  }
}
