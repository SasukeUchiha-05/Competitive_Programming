import java.util.*;

public class SmallestElement {
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
        SmallestEle(arr , n , k);
        
    }

    public static void SmallestEle(int[] arr , int n , int k)
    {
        List<Integer> arrayList = new ArrayList<>();

        for(int i=0;i<k;i++)
        {
            arrayList.add(arr[i]);
        }
        int minEle = Collections.min(arrayList);
        System.out.print(minEle);

        for(int i=k;i<n;i++)
        {
            arrayList.remove(0);
            arrayList.add(arr[i]);
            minEle = Collections.min(arrayList);
            System.out.print(","+ minEle);
        }
    }
}
