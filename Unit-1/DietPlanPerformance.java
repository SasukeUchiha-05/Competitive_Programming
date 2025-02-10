import java.util.*;
public class DietPlanPerformance{
    public static int DietPerformanceCalc(int[] calories , int n , int days , int lower , int upper)
    {
        int total_points = 0;
        int sum = 0;
        for(int i=0;i<days;i++)
        {
            sum+= calories[i];
        }
        
        if(sum<lower)
        {
            total_points--;
        }
        else if(sum>upper)
        {
            total_points++;
        }
        
        // int curr_points = total_points;
        for(int j=days;j<n;j++)
        {
            sum+=calories[j] - calories[j-days];
            
            if(sum>upper)
            {
                total_points++;
            }
            else if(sum<lower){
                total_points--;
            }
            
        }
        return total_points;
    }
    
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] calories = new int[n];
        for(int i=0;i<n;i++)
        {
            calories[i] = sc.nextInt();
        }
        int days = sc.nextInt();
        
        int lower = sc.nextInt();
        int upper = sc.nextInt();

        sc.close();
        
        int total_points = DietPerformanceCalc(calories , n , days , lower , upper);
        System.out.println(total_points);
    }
}