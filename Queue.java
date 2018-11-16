//Yiwen Zhang 201825695
//linked data structure: queue
public class Queue{
  //instance variables
  private Item head = null;//The first element in the queue.
  private Item tail = null;//The last element in the queue.

  private class Item{//structure of the item.
     int value;
     Item next;
  }
  //instance methods
  //method named enqueue: add new item to the end of the queue and return nothing.
  public void enqueue(int x){
    Item p = new Item();
    p.value = x;
    if(head == null){
      head = p;
      tail = p;
    }else{
      tail.next = p;
      tail = p;//Let the added item to be the tail.
    }
  }
  //method dequeue: remove the front item and return its value.
  public int dequeue(){
    if(head == null){
      return -1;
    }else{
      int x = head.value;
      head = head.next;
      return x;
    }
  }
  //method toString: returns a string representation of the queue.
  public String toString(){
    String s = "";
    for(Item p = head; p != null; p = p.next){
      s += p.value + " -> ";
    }
    s += "null";
    return s;
  }
  //using main method for testing purpose.
  public static void main(String[] args){
    Queue queue = new Queue();//constructor a new queue.
    for(int i = 0; i < args.length; i++){//use command line arguments.
      int x = Integer.parseInt(args[i]);//put every number into x for some checking.
      if(x > 0){//if x > 0, then join the queue.
        System.out.println("enqueue " + x);
        queue.enqueue(x);
      }else if(x < 0){//if x < 0, delete the front of the queue.
        x = queue.dequeue();
        if(x < 0){//in order to check if the queue is empty.
          System.out.println("The queue is empyt.");
        }else{//the queue is not empty, then print the deleted value.
          System.out.println("dequeue " + x);
        }
      }else{//if x = 0, then print the while queue.
        System.out.println(queue);
      }
    }
  }
}
