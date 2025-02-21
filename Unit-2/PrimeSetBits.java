/*Given two integers left and right, return the count of numbers in the inclusive range [left, right]
 having a prime number of set bits in their binary representation.

Recall that the number of set bits an integer has the number of 1's present when written in binary.

For example, 21 written in binary is 10101, which has 3 set bits.
 
Input Format:
-------------
Line-1: Two separated integers

Output Format:
--------------
Line-1: An integer

Sample Input-1:
---------------
6  10

Sample Output-1:
---------------
4

Explanation:
------------
6  -> 110 (2 set bits, 2 is prime)
7  -> 111 (3 set bits, 3 is prime)
8  -> 1000 (1 set bit, 1 is not prime)
9  -> 1001 (2 set bits, 2 is prime)
10 -> 1010 (2 set bits, 2 is prime)
4 numbers have a prime number of set bits.

Sample Input-2:
---------------
10 15

Sample Output-2:
---------------
5

Explanation:
------------
10 -> 1010 (2 set bits, 2 is prime)
11 -> 1011 (3 set bits, 3 is prime)
12 -> 1100 (2 set bits, 2 is prime)
13 -> 1101 (3 set bits, 3 is prime)
14 -> 1110 (3 set bits, 3 is prime)
15 -> 1111 (4 set bits, 4 is not prime)
5 numbers have a prime number of set bits.
 */

 import java.util.*;
 public class PrimeSetBits{
     public static void main(String args[])
     {
         Scanner sc = new Scanner(System.in);
         int left = sc.nextInt();
         int right = sc.nextInt();

         sc.close();
         
         System.out.print(countPrimeSetBits(left,right));
     }
     
     private static boolean isPrime(int n)
     {
         if(n<2) return false;
         
         for(int i=2;i<=Math.sqrt(n);i++)
         {
             if(n%i == 0) return false;
         }
         return true;
     }
     
     private static int countSetBits(int n)
     {
         int count = 0;
         while(n>0){
             count+=n&1;
             n>>=1;
         }
         return count;
     }
     
     private static  int countPrimeSetBits(int left , int right)
     {
         int result = 0;
         for(int num = left ;num<=right;num++){
             int bits = countSetBits(num);
             if(isPrime(bits)){
                 result++;
             }
         }
         return result;
     }
 }