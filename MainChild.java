class Main{
   int i;
   Main(int x){
      this.i=x;
   }
   int getvar(){
      return i;
   }
}
public class MainChild(){
   public static void main(String args[]){
      MainChild mc = new MainChild();
      System.out.println(getvar());
   }  
}