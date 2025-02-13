import java.util.*;

public class test {
    public static void main(String args[]) {
        int[] arr1 = {10, 13, 15, 20};
        int[] arr2 = {12, 17, 30, 40};
        int target = 45;

        int[] res = ClosestPair(arr1, arr2, target);
        System.out.println("Closest Pair: " + res[0] + ", " + res[1]);
    }

    private static int[] ClosestPair(int[] arr1, int[] arr2, int target) {
        int i = 0, j = arr2.length - 1;
        int closestSum = Integer.MAX_VALUE;
        int closestI = -1, closestJ = -1;

        while (i < arr1.length && j >= 0) {
            int tempSum = arr1[i] + arr2[j];

            // Check if this sum is closer to the target than previous closest
            if (Math.abs(target - tempSum) < Math.abs(target - closestSum)) {
                closestSum = tempSum;
                closestI = arr1[i];
                closestJ = arr2[j];
            }

            if (tempSum < target) {
                i++; // Move right in arr1 to increase sum
            } else {
                j--; // Move left in arr2 to decrease sum
            }
        }

        return new int[]{closestI, closestJ};
    }
}
