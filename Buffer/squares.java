/*Given an integer array nums sorted in non-decreasing order, 
return an array of the squares of each number sorted in non-decreasing order.

Input Format:
-------------
Line-1: An integer N
Line-2: N space seperated integers

Output Format:
--------------
Line-1: A list of integers

Sample Input-1:
---------------
5
-4 -1 0 3 10

Sample Output-1: 
----------------
[0, 1, 9, 16, 100]

 */

 import java.util.*;

 class squares{
     public static void main (String[] args) {
         Scanner sc = new Scanner(System.in);
         int n = sc.nextInt();
         
         int[] arr = new int[n];
         
         for(int i=0;i<n;i++)
         {
             arr[i] = sc.nextInt();
         }

         sc.close();
         
         int[] result = Squares(n,arr);
         
         System.out.println(Arrays.toString(result));
     }
     
     public static int[] Squares(int n , int[] arr)
     {
         // List<Integer> list = new ArrayList<>(n+1);
         
         int i=0,j=n-1;
         int index = n-1;
         
         int[] res = new int[n];
         while(i<=j)
         {
             if(Math.abs(arr[i]) > Math.abs(arr[j]))
             {
                 res[index] = arr[i]*arr[i];
                 i++;
             }
             else{
                 res[index] = arr[j]*arr[j];
                 j--;
             }
             index--;
             
         }
         // Collections.reverse(list);
         return res;
     }
 }