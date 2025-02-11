import java.util.Scanner;

public class fixed_Window {
    public static int max_sum(int[] arr , int n , int k)
    {
        int max_sum = 0;
        //compute the base case for the window to work with.
        for(int i=0;i<k;i++)
        {
            max_sum += arr[i];
        }
        
        int window_sum = max_sum;
        //start moving through the array with a window of size k , and update the window_sum accordingly.
        for(int i=k;i<n;i++)
        {
            window_sum += arr[i] - arr[i-k];
            max_sum = Math.max(max_sum , window_sum);
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
