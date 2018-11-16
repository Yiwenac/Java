//Yiwen Zhang 201825695
//write a class to Implement a linked list data structure.
public class SortedDoublyLinkedList{

  //instance variables
  private Item head = null;
  private Item tail = null;
  private class Item{//each item contains two pointers
    int value;
    Item next;//the pointer points the next element.
    Item prev;//the pointer points the before element.
   }
   //instance methods
   //method insert(int x) insert new item, return nothing.
   //the list must remain sorted.
   public void insert(int x){
     Item p = new Item();
     p.value = x;
     if(head == null){//if the list is empty, then add the item.
       head = p;
       tail = p;
     }else{//the list is not empty and sorted.
       if(x <= head.value){//insert before the head.
         p.next = head;
         head.prev = p;
         head = p;
       }
       else if(x >= tail.value){//insert after the tail.
         tail.next = p;
         p.prev = tail;
         tail = p;
       }
       else{//insert the item inside the list.
         for(Item i = head; i != null; i = i.next){
           if(i.value <= x && x <= i.next.value){//find the right position.
             p.next = i.next;
             i.next.prev = p;
             i.next = p;
             p.prev = i;
             break;
           }
         }
       }
     }
   }
   //delete(int x):method to delete all the items.
   public void delete(int x){
     if(head == null){//check if the list is empty.
       System.out.println("The list is empty.");
     }else{//if delete completely then break.
       for(Item i = head; i.value <= x; i = i.next){
         if(head.value == x){//if delete the head.
           head.next.prev = null;
           head = head.next;
         }else if(tail.value == x){//if delete the tail.
           tail.prev.next = null;
           tail = tail.prev;
         }else if(x == i.value){
           i.prev.next = i.next;
           i.next.prev= i.prev;
         }
       }
     }
   }
   //toString: print the doubly linked list.
   public String toString(){
     String s = "null <- ";
     Item p = head;
     while(p != tail){
       s += p.value + " <-> ";
       p = p.next;
     }
     s += tail.value + " -> null";
     return s;
   }
   //reverseString: print the doubly linked list in reverse.
   public String reverseString(){
     String s = "null <- ";
     for(Item p = tail; p != head; p = p.prev){
       s += p.value + " <-> ";
     }
     s += head.value + " -> null";
     return s;
   }
   //main method for testing.
   public static void main(String[] args){
     SortedDoublyLinkedList list = new SortedDoublyLinkedList();
     for(int i = 0; i < args.length; i++){
       int x = Integer.parseInt(args[i]);
       if(x > 0){//if x > 0, put x into the list.
         list.insert(x);
       }else if(x < 0){//if x < 0
         if(list.head == null){//if the list is empty.
           System.out.println("The list is null.");
         }else{//if not empty, delete -x.
           list.delete(-x);
         }
       }else{//if x = 0; print the list.
         System.out.println(list);
       }
     }
   }
   
}
