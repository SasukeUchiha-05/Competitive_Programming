/*Birbal is creating a new binary code system BBC (Birbal Binary Code) as follows:

I	f(I)
-------
0	""
1	"0"
2	"1"
3	"00"
4	"01"
5	"10"
6	"11"
7	"000"

You are given an integer value I, where I is positive number.
Your task is to find BBC representation of  the given number I.

Input Format:
-------------
Line-1: An integer I

Output Format:
--------------
Line-2: Print the BBC representation of I.


Sample Input-1:
---------------
23

Sample Output-1:
----------------
1000


Sample Input-2:
---------------
45

Sample Output-2:
----------------
01110
 */

 import java.util.*;

 public class EncodeNumber{
     public static void main(String args[])
     {
         Scanner sc = new Scanner(System.in);
         // System.out.println(Integer.toBinaryString(sc.nextInt()+1).substring(1));
         
         int n = sc.nextInt();

         sc.close();
         
         Solution sol = new Solution();
         
         
         System.out.println(sol.encodeNumber(n));
     }
 }
 
 class Solution{
     
     public String encodeNumber(int n){
         
         StringBuilder res = new StringBuilder();
         n+=1;
         while(n>0){
             res.append(n&1);
             n>>=1;
         }
         res.reverse();
         return res.toString().substring(1);
     }
 }
 