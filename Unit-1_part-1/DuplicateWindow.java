/*Given an integer array of nums and an integer window size X, 
return true if there are duplicate values (nums[i]== nums[j])in that Window(X)
X size is always <= abs(i - j) where i and j are two distinct indices of array.

Input Format:
-------------
Line-1: An integer N, Array Size
Line-2: Space separated integers, array elements
Line-3: An integer X, window size

Output Format:
--------------
Line-1: Booelan value, true/false


Sample Input-1:
---------------
4
1 2 3 1  
3 

Sample Output-1: 
----------------
false

Sample Input-2:
---------------
6
1 2 3 3 2 3
2

Sample Output-2: 
----------------
true */
import java.util.*;
// to find the dup elements in window size k using hash set
public class DuplicateWindow {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int x = sc.nextInt();

        System.out.println(dupWindow(arr, n, x));

        sc.close(); 
    }

    public static boolean dupWindow(int[] arr, int n, int k) {
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < k; i++) {
            if (!set.add(arr[i])) { 
                return true;
            }
        }

        for (int i = k; i < n; i++) {
            set.remove(arr[i - k]);

            if (!set.add(arr[i])) {
                return true;
            }
        }

        return false;
    }
}
