/*Malika taught a new fun time program practice for Engineering Students.
As a part of this she has given set of N numbers, and asked the students 
to perform the operations listed below:
1. sumRange(start, end) - return the sum of numbers between the indices start and end, both are inclusive.
2. update(ind, val) - update the value at the index 'ind' to 'val'.

Your task is to solve this problem using Fenwick Tree concept.

Input Format:
-------------
Line-1: Two integers N and Q, size of the array(set of numbers) and query count.
Line-2: N space separated integers.
next Q lines: Three integers option, start/ind and end/val.

Output Format:
--------------
An integer result, for every sumRange query.


Sample Input-1:
---------------
8 5
1 2 13 4 25 16 17 8
1 2 6		//sumRange
1 0 7		//sumRange
2 2 18	//update
2 4 17	//update
1 2 7		//sumRange

Sample Output-1:
----------------
75
86
80



Sample Input-2:
---------------
8 5
1 2 13 4 25 16 17 8
1 2 6		
1 0 7		
2 2 18	
2 4 17	
1 0 7

Sample Output-2:
----------------
75
86
83
 */
import java.util.*;
class FenwickTree {
    private int[] BIT;
    private int n;

    // Constructor: Initialize BIT with size (n + 1)
    public FenwickTree(int size) {
        this.n = size;
        BIT = new int[n + 1];
        // BIT[0] =0; // 1-based index
    }

    // Function to update index i by adding value x
    public void init(int i, int x) {
        i++;
        while (i <= n) {
            BIT[i] += x;
            i += (i & -i);  // Move to the next index
        }
    }

    public void update(int i,int val){
        int diff = val-BIT[i];
        BIT[i] = val;
        init(i,diff);
    }

    // Function to get the prefix sum from index 1 to i
    public int prefixSum(int i) {
        int sum = 0;
        i++;
        while (i > 0) {
            sum += BIT[i];
            i -= (i & -i);  // Move to parent
        }
        return sum;
    }

    // Function to get the sum in range [l, r]
    public int rangeSum(int l, int r) {
        return prefixSum(r) - prefixSum(l - 1);
    }

    // Function to build the BIT from an array
    public void buildBIT(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            init(i , arr[i]); // 1-based indexing
        }
    }



    // Print BIT array (for debugging)
    public void printBIT() {
        for (int i = 0; i <= n; i++) {
            System.out.print(BIT[i] + " ");
        }
        System.out.println();
    }
}
public class BIT{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();
        int[] base = new int[n];

        for(int i=0;i<n;i++){
            base[i] = sc.nextInt();
        }
        sc.close();

        FenwickTree fw = new FenwickTree(n);
        fw.buildBIT(base);

        // fw.printBIT();
        // int res = fw.rangeSum(2, 6);
        // System.out.println(res);
    }
}