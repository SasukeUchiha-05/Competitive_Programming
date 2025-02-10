import java.util.*;
public class Naive_Approach{
    public static int max_sum(int [] arr , int n , int k)
    {
        int max_sum = Integer.MIN_VALUE;

        for(int i=0;i<n-k+1;i++)
        {
            int curr_sum=0;
            for(int j=0;j<k;j++)
            {
                curr_sum = curr_sum + arr[i+j]; 
            }
            max_sum = Math.max(curr_sum , max_sum);

        }
        return max_sum;
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++)
        {
            arr[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        sc.close();

        System.out.println(max_sum(arr,n,k));

    }
}