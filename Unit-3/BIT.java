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
class FenwickTree{
    private int[] BIT;
    private int n;
    private int[] nums;
    
    public FenwickTree(int size){
        this.n = size;
        BIT = new int[n+1];
    }
    
    public void init(int i,int x){
        i++;
        while(i<=n){
            BIT[i]+=x;
            i+=(i&-i);
        }
    }
    
    public void update(int i,int val){
        int diff = val-nums[i];
        nums[i] = val;
        init(i,diff);
    }
    
    int prefixSum(int i){
        int sum =0;
        i++;
        while(i>0){
            sum+=BIT[i];
            i-=(i&-i);
        }
        return sum;
    }
    
    public int rangeSum(int l,int r){
        return prefixSum(r)-prefixSum(l-1);
    }
    
    public void buildBIT(int[] arr){
        this.nums = arr;
        for(int i=0;i<arr.length;i++){
            init(i,arr[i]);
        }
    }
    public void printBIT(){
           for(int i=0;i<=n;i++){
            System.out.print(BIT[i]+ " ");  
           }
           System.out.println();
    }
    
} 

public class BIT{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();
        
        List<Integer> list = new ArrayList<>();
        
        int[] arr = new int[n];
        
        for(int i=0;i<n;i++)
        {
            arr[i] = sc.nextInt();
        }
        FenwickTree fw = new FenwickTree(n);
        fw.buildBIT(arr);
        fw.printBIT();
        
        for(int j=0;j<q;j++)
        {
            int choice = sc.nextInt();
            int arg1 = sc.nextInt();
            int arg2 = sc.nextInt();
            
            if(choice ==1){
                list.add(fw.rangeSum(arg1,arg2));
            }
            else if (choice == 2){
                fw.update(arg1,arg2);
                // fw.printBIT();
            }
        }
        
        for(int i:list){
            System.out.println(i);
        }
    }
}