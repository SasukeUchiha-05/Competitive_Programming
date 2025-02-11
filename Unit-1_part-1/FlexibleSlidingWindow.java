// import java.util.*;
public class FlexibleSlidingWindow {
    public static int maxSubArraySum(int[] books ,int n , int k)
    {
        int maxBooks = 0, sum = 0, left = 0;

        for(int right =0;right<n;right++)
        {
            sum+=books[right];

            while(sum>k)
            {
                sum-=books[left];
                left++;
            }

            maxBooks = Math.max(maxBooks , right -left+1);
            System.out.println("right "+ right + " left " + left+" sum "+ sum +" maxBooks "+ maxBooks );
        }

        return maxBooks;
    }

    public static void main (String[] args) {
    //  int[] books = {3,1,2,4,5,2};
    // int[] books = {1,1,2,1,1,1,4,2};
    // int[] books = {1,8,2,7,1,1,4,2};
    int[] books = {1,1,2,8,1,2,4,2};
     int n = 6;
     int k = 6;
    System.out.println(maxSubArraySum(books, n, k));
    }
}
