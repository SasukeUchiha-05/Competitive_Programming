/*Two brothers are playing a game based on two sorted lists of numerical elements and a target sum.

The first brother provides:
-> Two sorted lists of integers.
-> A target sum.

The second brother's task is to find and return the closest pair of elements (one from each list) 
whose sum is closest to the given target.

Rules:
------
Each pair must consist of one element from each list.
If multiple pairs have the same closest sum, return any one valid pair.
The input lists are already sorted in ascending order.
The result must be printed as a comma-separated pair.

Input Format:
-------------
Line 1: An integer N1, representing the size of the first list.
Line 2: N1 space-separated integers, representing elements of the first sorted list.
Line 3: An integer N2, representing the size of the second list.
Line 4: N2 space-separated integers, representing elements of the second sorted list.
Line 5: An integer X, representing the target sum.

Output Format:
--------------
Line-1: Print a comma-separated pair (a, b), where a is from list_1 and b is from list_2, such that their sum is closest to the target sum.

Sample Input-1:
---------------
4
1 4 5 7
4
10 20 30 40
32

Sample Output-1:
----------------
1,30

Explanation:
------------
The closest pair to 32 is (1,30) → 1 + 30 = 31, which is the closest sum to 32.

Sample Input-2:
---------------
3
2 4 6
4
5 7 11 13
15

Sample Output-2:
----------------
2,13

Explanation:
------------
The closest pair to 15 is (2,13) → 2 + 13 = 15, which is an exact match.
 */
import java.util.*;
public class ClosestPair{
    
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt();
        int[] arr1 = new int[n1];
        for(int i=0;i<n1;i++)
        {
            arr1[i] = sc.nextInt();
        }
        int n2 = sc.nextInt();
        int[] arr2 = new int[n2];
        for(int i=0;i<n2;i++)
        {
            arr2[i] = sc.nextInt();
        }
        int target = sc.nextInt();

        sc.close();
        
        int[] res = closestPair(n1,arr1,n2,arr2,target);
        System.out.println(res[0]+","+res[1]);
        
    }
    
    private static int[] closestPair(int n1 , int [] arr1 , int n2 , int[] arr2 , int target)
    {
        int i=0,j=arr2.length-1;
        int closestSum = Integer.MAX_VALUE;
        int closestI = -1,closestJ=-1;
        
        while(i<n1 && j>=0)
        {
            int temp = arr1[i] + arr2[j];
            if(Math.abs(target-temp)<Math.abs(target-closestSum))
            {
                closestSum = temp;
                closestI=arr1[i];
                closestJ=arr2[j];
            }
            
            if(temp<target)
            {
                i++;
            }
            else{
                j--;
            }
        }
        return new int[]{closestI,closestJ};
    }
}