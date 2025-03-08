import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.*;
class Emp{
    int empno =20;
}

class A{

    static int num=10;
 
   public static void main(String[] args){
 
      new A().m1(num);
 
      System.out.print(" " + num);
 
   }
 
  
 
 void m1(int num) {
 
    num++;
 
    for(int num = 3; num < 6; num++)
 
         System.out.print(" " + num);
 
    }
 
 }