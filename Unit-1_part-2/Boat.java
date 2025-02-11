import java.util.*;
class Boat{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] weights = new int[n];
        
        for(int i=0;i<n;i++)
        {
            weights[i] = sc.nextInt();
        }
        int limit = sc.nextInt();

        sc.close();
        
        System.out.println(noOfBoats(weights, n ,limit));
    }
    
    public static int noOfBoats(int[] weights , int n, int limit)
    {
        Arrays.sort(weights);
        int i=0,j=n-1;
        int boats = 0;
        
        while(i<=j)
        {
            if(weights[i]+weights[j]<=limit)
            {
                i++;
            }
            j--;
            boats++;
        }
        return boats;
    }
}