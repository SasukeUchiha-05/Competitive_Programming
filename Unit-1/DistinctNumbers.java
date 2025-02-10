import java.util.*;
public class DistinctNumbers{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int p = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++)
        {
            arr[i] = sc.nextInt();
        }
        sc.close();
        distinctNums(arr , n , p);
    }
    public static void distinctNums(int [] arr , int n , int k)
    {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<k;i++)
        {
            map.put(arr[i], map.getOrDefault(arr[i],0)+1);
        }
        System.out.print(map.size());
        
        for(int i=k;i<n;i++)
        {
            if(map.get(arr[i-k]) == 1)
            {
                map.remove(arr[i-k]);
            }
            else{
                map.put(arr[i-k],map.get(arr[i-k])-1);
            }
            if(map.containsKey(arr[i]))
            {
                map.put(arr[i],map.get(arr[i])+1);
            }
            else{
                map.put(arr[i] , 1);
            }
            
            System.out.print(" "+ map.size());
        }
    }
}