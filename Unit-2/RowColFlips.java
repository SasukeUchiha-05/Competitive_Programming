/* You are given an array time where time[i] denotes the time taken by the ith bus to complete one trip.

Each bus can make multiple trips successively; that is, the next trip can start immediately after completing the current trip. 
Also, each bus operates independently; that is, the trips of one bus do not influence the trips of any other bus.

You are also given an integer totalTrips, which denotes the number of trips all buses should make in total. 
Return the minimum time required for all buses to complete at least totalTrips trips.

Input Format:
-------------
Line-1: An integer n, size of time
Line-2: n space separated integers, time[i]
Line-3: An integer, totalTrips

Sample Input-1:
---------------
3
1 2 3
5

Sample Output-1: 
----------------
3
 
Explanation:
-------------
-> At time t = 1, the number of trips completed by each bus are [1,0,0]. 
  The total number of trips completed is 1 + 0 + 0 = 1.
-> At time t = 2, the number of trips completed by each bus are [2,1,0]. 
  The total number of trips completed is 2 + 1 + 0 = 3.
-> At time t = 3, the number of trips completed by each bus are [3,1,1]. 
  The total number of trips completed is 3 + 1 + 1 = 5.
So the minimum time needed for all buses to complete at least 5 trips is 3.

Sample Input-2:
---------------
1
2
1

Sample Output-2: 
----------------
2


Explanation:
--------------
There is only one bus, and it will complete its first trip at t = 2.
So the minimum time needed to complete 1 trip is 2.
 

Constraints:
------------
1 <= time.length <= 10^5
1 <= time[i], totalTrips <= 10^7
*/

import java.util.*;

class RowColFlips{
    public boolean removeOnes(int[][] grid)
    {
        if(grid.length <= 1) return true;
        
        for(int i=1;i<grid.length;i++)
        {
            if(!equalsOrComplement(grid[0],grid[i])){
                return false;
            }
        }
        return true;
    }


private boolean equalsOrComplement(int[] row1 , int[] rowNot1)
{
    boolean equals = true, complement = true;
    
    for(int i=0;i<row1.length;i++)
    {
        equals = equals && ((row1[i] ^ rowNot1[i]) == 0);
        
        complement = complement && ((row1[i] ^ rowNot1[i]) ==1);
    }
    
    return equals || complement;
}

public static void main(String args[])
{
    Scanner sc = new Scanner(System.in);
    int m = sc.nextInt();
    int n = sc.nextInt();
    
    int[][] grid = new int[m][n];
    
    for(int i=0;i<m;i++)
    {
        for(int j=0;j<n;j++)
        {
            grid[i][j] = sc.nextInt();
        }
    }

    sc.close();
    System.out.print(new RowColFlips().removeOnes(grid));
    
}

    
    
    
}
