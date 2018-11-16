//Yiwen Zhang 201825695
public class Rectangle{
  //instance variables
  private Interval x;//put interval and rectangle in the same folder then it works.
  private Interval y;
  //constructor
  public Rectangle(Interval a, Interval b){
    x = a;
    y = b;
  }
  //instance methods
  public double area(){
    return x.length() * y.length();
  }

  public double perimeter(){
    return 2 * (x.length() + y.length());
  }

  public boolean intersects(Rectangle b){
    if((x.contains(b.x.le) && y.le <= b.y.ri) || (x.contains(b.x.ri) && (y.le <= b.y.ri))){
      return true;//return this.xinterval.intersects(b.xinterval) &&
    }else{// this.yinterval.intersects(b.yinterval);
      return false;
    }
  }

  public boolean contains(Rectangle b){
    if(x.contains(b.x.le) && x.contains(b.x.ri) && y.contains(b.y.le) && y.contains(b.y.ri)){
      return true;
    }else{
      return false;
    }
  }

  public String toString(){
    return this.toString + " x " + b.toString();
  }

  //main method to test
  public static void main(String[] args){
    Interval x_1 = new Interval(1, 3);
    Interval y_1 = new Interval(1, 7);
    Interval x_2 = new Interval(-1, 2);
    Interval y_2 = new Interval(-1, 6);
    Rectangle a = new Rectangle(x_1, y_1);
    Rectangle b = new Rectangle(x_2, y_2);
    System.out.println("The area of rectangle a is: " + a.area());
    System.out.println("The perimeter of rectangle a is: " + a.perimeter());
    System.out.println("Do two rectangles intersect: " + a.intersects(b));
    System.out.println("Does rectangle a contain rectangle b: " + a.contains(b));
  }
}
