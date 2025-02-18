/*You are given an integer array nums of length n and an integer target. 
Your task is to find three integers in nums such that their sum is closest to the given target.

Return the sum of these three integers.

You may assume that each input would have exactly one solution.

Input Format:
-------------
Line-1: An integer n, the size of the array.
Line-2: n space-separated integers representing the elements of the array nums.
Line-3: A single integer target.

Output Format:
--------------
Line-1: Print a single integer, representing the sum of three integers closest to the target.

Sample Input-1:
---------------
4
-1 2 1 -4
1

Sample Output-1:
----------------
2

Sample Input-2:
---------------
3
0 0 0
1

Sample Output-2:
----------------
0

 */

import java.util.*;
public class ThreeSumClosest{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        
        int[] nums = new int[n];
        
        for(int i=0;i<n;i++)
        {
            nums[i] = sc.nextInt();
        }
        
        int target = sc.nextInt();

        sc.close();
        
        Solution sol = new Solution();
        
        int res = sol.threeSumClosest(nums , n , target);
        
        System.out.println(res);
    }
}

class Solution{
    int closestSum;
    
    public Solution(){
        this.closestSum =0;
    }
    
    public int threeSumClosest(int[] nums , int n , int t)
    {
        Arrays.sort(nums);
        closestSum = nums[0]+nums[1]+nums[2];
        
        for(int i=0;i<nums.length-2;i++)
        {
            int left = i+1,right = nums.length-1;
            
            while(left<right){
                int curr = nums[i] + nums[left] + nums[right];
                
                if(Math.abs(t-curr)< Math.abs(t-closestSum))
                {
                    closestSum = curr;
                }
                
                if(curr<t)
                {
                    left++;
                }
                else if(curr>t)
                {
                    right--;
                }
                else{
                    return curr;
                }
            }
        }
        return closestSum;
    }
}

