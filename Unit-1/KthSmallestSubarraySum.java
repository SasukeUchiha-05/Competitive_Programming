import java.util.*;
public class KthSmallestSubarraySum{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int P = sc.nextInt();
        int I = sc.nextInt();
        
        int[] marks = new int[P];
        for(int i=0;i<P;i++)
        {
            marks[i] = sc.nextInt();
        }
        sc.close();
        
        int result = Solution(P,I,marks);
        System.out.println(result);
    }
    public static int Solution(int n , int k , int[] arr)
    {
        int min = Integer.MAX_VALUE , sum = 0;
        
        for(int num:arr)
        {
            min = Math.min(min , num);
            sum+=num;
        }
        int low = min,high = sum;
        while(low<high)
        {
            int mid = low+(high-low)/2;
            int count = countSubArrays(arr,mid);
            
            if(count<k)
            {
                low = mid+1;
            }
            else{
                high = mid;
            }
            
        }
        return low;
        
    }
    private static int countSubArrays(int[] arr , int mid)
    {
        int sum = 0,count =0;
        int left = 0;
        for(int right = 0;right<arr.length;right++)
        {
            sum+= arr[right];
            
            while(sum>mid)
            {
                sum-=arr[left];
                left++;
            }
            
            count+=(right-left+1);
        }
        return count;
    }
    
}