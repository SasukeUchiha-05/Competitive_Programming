import java.util.*;
class MaxOfAllSubarraysOfSizeK{
    public static void MaximumElement(int[] arr , int n , int k)
    {
        List<Integer> array = new ArrayList<>();
        for(int i=0;i<k;i++)
        {
            array.add(arr[i]);
        }
        
        int maxEle = Collections.max(array);
        System.out.print(maxEle);
        
        for(int i=k;i<n;i++)
        {
            array.remove(0);
            array.add(arr[i]);
            maxEle = Collections.max(array);
            System.out.print(" " + maxEle);
        }
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int[] arr = new int[N];
        
        for(int i=0;i<N;i++)
        {
            arr[i] = sc.nextInt();
        }
        sc.close();
        
        MaximumElement(arr,N,K);
    }
}

