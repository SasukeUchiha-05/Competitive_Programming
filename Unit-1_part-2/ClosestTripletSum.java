/*You are given three sorted integer arrays A[], B[], and C[], and an integer target.

Your task is to find one element from each array (A[i], B[j], and C[k]) such that the sum of these three elements is equal to target.

If there is no exact match, return the triplet with the minimum absolute difference to the target.

Input Format:
-------------
Line 1: An integer N, the size of the first array.
Line 2: N space-separated integers representing elements of array A.
Line 3: An integer M, the size of the second array.
Line 4: M space-separated integers representing elements of array B.
Line 5: An integer P, the size of the third array.
Line 6: P space-separated integers representing elements of array C.
Line 7: An integer target, the required sum.

Output Format:
--------------
Line-1: Print the triplet (A[i], B[j], C[k]) that either matches the target or has the closest sum to the target.

Constraints:
------------
Time Complexity: O(N + M + P)
Space Complexity: O(1)

Sample Input-1:
---------------
4
5 10 20 30
4
1 3 7 10
4
2 5 8 12
25

Sample Output-1:
----------------
10 7 8

Explanation:
-------------
The sum 10 + 7 + 8 = 25, which exactly matches target.


Sample Input-2:
---------------
3
1 5 10
3
3 6 9
3
4 7 8
30

Sample Output-2:
----------------
10 9 8

Explanation:
------------
The sum 10 + 9 + 8 = 27, which is the closest sum to 30 (minimum absolute difference |30 - 27| = 3). */


import java.util.*;

public class ClosestTripletSum{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int[] A = new int[n];
        for(int i=0;i<n;i++)
        {
            A[i] = sc.nextInt();
        }
        
        int m = sc.nextInt();
        int[] B = new int[m];
        for(int i=0;i<m;i++)
        {
            B[i] = sc.nextInt();
        }
        
        int p = sc.nextInt();
        int[] C = new int[p];
        for(int i=0;i<m;i++)
        {
            C[i] = sc.nextInt();
        }
        
        int target = sc.nextInt();
        sc.close();
        
        Solution sol = new Solution();
        
        int[] res = sol.closestTriplet(n,A,m,B,p,C,target);
        
        System.out.println(res[0] +" " + res[1] +" " + res[2] +" ");
    }
}

class Solution{
    public int[] closestTriplet(int n , int[] A , int m , int[] B , int p , int[] C , int target)
    {
        int closestSum = Integer.MAX_VALUE;
        
        int[] result = new int[3];
        
        for(int i=0;i<n;i++)
        {
            int rem = target -A[i];
            
            int[] closestPair = findClosestPair(B,C,rem);
            
            int currentSum = A[i] + closestPair[0] + closestPair[1];
            
            if (Math.abs(target - currentSum) < Math.abs(target - closestSum)){
                closestSum = currentSum;
                result[0] = A[i];
                result[1] = closestPair[0];
                result[2] = closestPair[1];
            }
            
        }
        return result; 
    }
    private int[] findClosestPair(int[] B, int[] C, int target){
        int left = 0, right = C.length - 1;
        int closestSum = Integer.MAX_VALUE;
        int[] closestPair = new int[2];

        while (left < B.length && right >= 0) {
            int sum = B[left] + C[right];
            if (Math.abs(target - sum) < Math.abs(target - closestSum)){
                closestSum = sum;
                closestPair[0] = B[left];
                closestPair[1] = C[right];
            }
            if (sum < target){
                left++; 
            } else{
                right--;
            }
        }
        return closestPair;
    }
}