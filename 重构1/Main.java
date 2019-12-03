import mv.*;
import ct.*;
import rt.*;
public class Main{
  public static void main(String[] args) {
      Customer c=new Customer("赵**");
      c. addRental(new Rental(new Movie("哪吒扎",2),9));
      c. addRental(new Rental(new Movie("悟空" ,2),8));
      c. addRental(new Rental(new Movie("战狼",1),7));
      System. out.print(c. statement());
  }
}