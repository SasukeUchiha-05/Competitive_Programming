/*You are given an integer N. Your task is to return an array ans of length N + 1 
where each ans[i] represents the number of 1's in the binary representation of i.

Input Format:
--------------
A single integer N, representing the range from 0 to N.

Output Format:
---------------
An array of N+1 integers where each element represents the count of 1s in the binary representation of each number from 0 to N.

Sample Input-1:
---------------
2

Sample Output-1:
----------------
[0,1,1]

Explanation:
------------
0 --> 0
1 --> 1
2 --> 10

Sample Input-2:
---------------
5

Sample Output-2:
--------------- 
[0,1,1,2,1,2]

Explanation:
------------
0 --> 0
1 --> 1
2 --> 10
3 --> 11
4 --> 100
5 --> 101

 */

 import java.util.*;

class CountingBits{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int[] arr = new int[n+1];

        sc.close();
        
        Solution sol = new Solution();
                
        arr = sol.countBits(n);
        System.out.print("[");
        
        for(int i=0;i<n;i++)
        {
            System.out.print(arr[i] +",");
        }
        System.out.print(arr[n]);
        System.out.print("]");
    }
}

class Solution{
    public int[] countBits(int n)
    {
        int[] arr = new int[n+1];
        arr[0] =0;
        
        for(int i=1;i<=n;i++)
        {
            int ct = 0,x=i;
            
            while(x>0){
                ct+=(x&1);
                x=x>>1;
            }
            arr[i] = ct;
        }
        return arr;
        
    }
}


