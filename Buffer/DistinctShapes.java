/*import java.util.*;

public class maxSum{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for(int i=0;i<n;i++)
        {
            nums[i] = sc.nextInt();
        }
        System.out.print(MaxSum(n,nums));
        
    }
    
    public static int MaxSum(int n , int[] nums)
    {
        int sum = 0, k=0;
        
        for(int i=0;i<n;i++)
        {
            sum+=nums[i];
            k+=i*nums[i];
        }
        
        int maxK = k;
        
        for(int j=1;j<=n;j++)
        {
            k = k + sum -n*nums[n-j];
            maxK = Math.max(maxK,k);
        }
        return maxK;
    }
} */

import java.util.*;

class DistinctShapes{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int arr[][] = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                arr[i][j] = sc.nextInt();
            }
        }

        sc.close();
        System.out.println(distShapes(m,n,arr));
    }
    
    static int distShapes(int m, int n, int arr[][]){
        Set<String> set = new HashSet<>();
        boolean visited[][] = new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(arr[i][j] ==1 && !visited[i][j]){
                    int br = i;
                    int bc = j;
                    StringBuilder sb = new StringBuilder();
                    sb.append(0);
                    sb.append(0);
                    helper(m,n,arr,sb,br,bc,visited);
                    set.add(sb.toString());
                }
            }
        }
        // System.out.println(set);
        return set.size();
        
    }
    
    static void helper(int m, int n, int arr[][], StringBuilder sb,int br, int bc, boolean[][] visited){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{br,bc});
        visited[br][bc] = true;
        while(!q.isEmpty()){
            int []curr = q.poll();
            int[] row = new int[]{-1,0,1,0};
            int []col = new int[]{0,1,0,-1};
            for(int i=0;i<4;i++){
                int newR = curr[0]+row[i];
                int newC = curr[1]+col[i];
                if(newR>=0 && newR<m && newC>=0 && newC<n && !visited[newR][newC] && arr[newR][newC] ==1){
                    visited[newR][newC] = true;
                    q.add(new int[]{newR, newC});
                    sb.append(newR-br);
                    sb.append(newC-bc);
                }
            }
        }
    }
}