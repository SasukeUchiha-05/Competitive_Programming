import java.util.*;
//problem similar to DietPlanPerformance maintaining points and all 
class Fighter{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] points = new int[N];
        for(int i=0;i<N;i++)
        {
            points[i] = sc.nextInt();
        }
        
        int K = sc.nextInt();
        int lower = sc.nextInt();
        int upper = sc.nextInt();

        sc.close();
        
        Solution sol = new Solution(N , points , K , lower , upper);
        int total_points = sol.Solve();
        System.out.println(total_points);
    }
}

class Solution{
    int n,k,lower,upper;
    int[] points;
    
    Solution(int n , int[] points , int k , int lower , int upper)
    {
        this.n=n;
        this.k=k;
        this.lower=lower;
        this.upper=upper;
        this.points=points;
    }
    
    public int Solve()
    {
        int total_points = 0;
        int sum = 0;
        for(int i=0;i<k;i++){
            sum+= points[i];
        }
        if(sum<lower)
        {
            total_points--;
        }
        else if(sum>upper)
        {
            total_points++;
        }
        
        for(int j = k;j<n;j++)
        {
            sum+= points[j] - points[j-k];
            
            if(sum>upper)
            {
                total_points++;
            }
            else if(sum<lower)
            {
                total_points--;
            }
        }
        return total_points;
    }
}