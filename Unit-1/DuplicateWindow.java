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
                return false;
            }
        }

        for (int i = k; i < n; i++) {
            set.remove(arr[i - k]);

            if (!set.add(arr[i])) {
                return false;
            }
        }

        return true;
    }
}
