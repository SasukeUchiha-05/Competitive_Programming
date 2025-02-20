import java.util.*;
class test{
    public static void main(String[] args) {
        // System.out.println('0'-'1');

        int n = 2;
        for(int i=1;i<=n;i++)
        {
            int count =0,x=i;
            while(x>0)
            {
                count+=(x&1);   
                x=x>>1;

            }
            System.out.println(count);
        }
        // System.out.println(count);
        System.out.println(1&1);
        // System.out.println('a'-0);
    }

}