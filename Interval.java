//Yiwen Zhang 201825695
public class Interval{
  //instance variables
  public double le;
  public double ri;

  //constructor
  public Interval(double left, double right){
    this.le = left;//good to use this. or le = left.
    this.ri = right;
  }

  //instance methods
  //if a point in this interval.
  public boolean contains(double x){
    if((x >= le) && (x <= ri)){//return (x >= le) && (x <= ri);
      return true;
    }else{
      return false;
    }
  }
  //decide if the two intervals intersect.

  public boolean intersects(Interval b){//the other way: think about if not intersects
    if(((le <= b.le) && (b.le <= ri)) ||//return !(a2 < b1 && b2 < a1);
    ((b.ri >= le) && (b.ri <= ri))){//return a2 >= b1 && b2 >= a1;
      return true;
    }else{
      return false;
    }
  }

  public double length(){
    return ri - le;
  }

  public String toString(){
    return "[" + le + "," + ri + "]";
  }

  //add main method to test
  public static void main(String[] args){
    double a_0 = Double.parseDouble(args[0]);
    double a_1 = Double.parseDouble(args[1]);
    double b_0 = Double.parseDouble(args[2]);
    double b_1 = Double.parseDouble(args[3]);
    Interval a = new Interval(a_0, a_1);
    Interval b = new Interval(b_0, b_1);
    System.out.println("The length of " + a.toString() + " is " + a.length());
    System.out.println("The length of " + b.toString() + " is " + b.length());
    if(a.intersects(b)){
      System.out.println(a.toString() + " and " + b.toString() + " intersect.");
    }else{
      System.out.println(a.toString() + " and " + b.toString() + " do not intersect.");
    }
    if(a.contains(0.0)){
      System.out.println(a.toString() + " contains the origin 0.");
    }else{
      System.out.println(a.toString() + " does not contain the origin 0.");
    }
    if(b.contains(0.0)){
      System.out.println(b.toString() + " contains the origin 0.");
    }else{
      System.out.println(b.toString() + " does not contain the origin 0.");
    }
  }

}
