/*Mr Bond is a spy and he is working on a mission to solve that mission he needs 
list of numbers which are password to a secret locker, he got a secret code from his informer 
which consists of a circular array code of length of n and a key k.

To decrypt the code, he must replace every number. All the numbers are replaced simultaneously.
with your programming skills help bond to decrypt the code.
The following are the rules to be followed to decrypt the code.

If k > 0, replace the ith number with the sum of the next k numbers.
If k < 0, replace the ith number with the sum of the previous k numbers.
If k == 0, replace the ith number with 0.

As code is circular, the next element of code[n-1] is code[0], and the previous element of code[0] is code[n-1].

Input Format: 
-------------
Line-1: An integer (n)
Line-2: n space separated integers
Line-3: An integer (k)

Output Format:
---------------
Line-1: list of integers

Sample Input-1:
---------------
4
5 7 1 4
3

Sample Output-1: 
----------------
[12,10,16,13]

Explanation: Each number is replaced by the sum of the next 3 numbers. 
The decrypted code is [7+1+4, 1+4+5, 4+5+7, 5+7+1]. Notice that the numbers wrap around.

Sample Input-2:
---------------
4
1 2 3 4
0

Sample Output-2:
----------------
[0,0,0,0]

Explanation: When k is zero, the numbers are replaced by 0. 

Sample Input-3:
---------------
4
2 4 9 3
-2

Sample Output-3:
----------------
[12,5,6,13]

Explanation: The decrypted code is [3+9, 2+3, 4+2, 9+4]. 
Notice that the numbers wrap around again. If k is negative, the sum is of the previous numbers.
 

Constraints:

n == code.length
1 <= n <= 100
1 <= code[i] <= 100
-(n - 1) <= k <= n - 1 */

import java.util.*;

public class Decode{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr =new int[n];
        
        for(int i=0;i<n;i++)
        {
            arr[i] = sc.nextInt();
        }
        int k = sc.nextInt();

        sc.close();
        
        Solution sol = new Solution(n,arr,k);
        
        sol.decode();
    }
}

class Solution{
    int n;
    int[] arr;
    int k;
    int start;
    int end;
    int sum;
    
    int[] result;
    
    public Solution(int n , int[] arr , int k){
        this.n = n;
        this.arr = arr;
        this.k = k;
        this.sum = 0;
        this.result = new int[n];
    }
    
    public void decode()
    {
        if(k==0)
        {
            Arrays.fill(result,0);
            System.out.println(Arrays.toString(result));
            return;
        }
        
        if (k>0)
        {
            for(int i=1;i<=k;i++)
            {
                sum+=arr[i%n];
            }
            start=1;
            end=k;
        }else{
            for(int i=n+k;i<n;i++)
            {
                sum+=arr[i];
            }
            start = n+k;
            end=n-1;
        }
        
        for(int i=0;i<n;i++){
            result[i] = sum;
            sum-=arr[start%n];
            start++;
            end++;
            sum+=arr[end%n];
        }
        
        System.out.println(Arrays.toString(result));
    }
}