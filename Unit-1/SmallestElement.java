/*You are given an array consisting of N integers, and an integer, K. 
Your task is to determine the minimum element in subarrays of size K.

Sample Input1:
--------------
5
10 12 14 11 15
3

Sample Output1:
---------------
10 11 11

Sample Input2:
--------------
5
5 2 1 1 1
4

Sample Output2:
---------------
1 1

 */
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
        sc.close();
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
