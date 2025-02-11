/*
 You are visiting a farm that has a single row of fruit trees arranged from left to right.

The trees are represented by an integer array fruits where fruits[i] is the type of fruit the ith tree produces.
You want to collect as much fruit as possible. 

However, the owner has some strict rules that you must follow:
You only have two baskets, and each basket can only hold a single type of fruit. 
There is no limit on the amount of fruit each basket can hold.

Starting from any tree of your choice, you must pick exactly one fruit from every tree (including the start tree)
while moving to the right. The picked fruits must fit in one of your baskets.

Once you reach a tree with fruit that cannot fit in your baskets, you must stop.
Given the integer array fruits, return the maximum number of fruits you can pick.

Sample Input-1:
---------------
3
1 2 1

Sample Output-1: 
----------------
3

Explanation: We can pick from all 3 trees.

Sample Input-2:
--------------- 
4
0 1 2 2 

Sample Output-2: 
----------------
3

Explanation: We can pick from trees [1,2,2].
If we had started at the first tree, we would only pick from trees [0,1].

Sample Input-3: 
---------------- 
5
1 2 3 2 2

Sample Output-4: 
----------------
4

Explanation: We can pick from trees [2,3,2,2].
If we had started at the first tree, we would only pick from trees [1,2].
 */

 import java.util.*;
public class Fruit{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] fruits = new int[n];
        
        for(int i=0;i<n;i++)
        {
            fruits[i] = sc.nextInt();
        }

        sc.close();
        
        System.out.println(noOfOptimalTrees(fruits,n));
    }
    public static int noOfOptimalTrees(int[] fruits , int n)
    {
        Map<Integer,Integer> map = new HashMap<>();
        int maxFruits = 0;
        int left = 0;
        
        for(int right = 0;right<n;right++)
        {
            map.put(fruits[right] , map.getOrDefault(fruits[right],0)+1);
            
            
            while(map.size()>2){
                map.put(fruits[left], map.get(fruits[left])-1);
                if(map.get(fruits[left]) ==0)
                {
                    map.remove(fruits[left]);
                }
                left++;
            }
            
            maxFruits = Math.max(maxFruits ,right-left+1);
        }
        return maxFruits;
    }
}