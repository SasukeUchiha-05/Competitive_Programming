/*
Flexible sliding window.
Find the maximum number of books we can read in k minutes, 
where each element of the array contains the time in minutes required to read a book.

Example
For the input array {1, 1, 2, 1, 1, 1, 4, 2} and k = 8:

The algorithm dynamically adjusts the window size.
It identifies subarrays like (1, 1, 2, 1, 1, 1), (1, 2, 1, 1, 1), (2, 1, 1, 1), etc., which satisfy the sum condition.
The longest subarray has a length of 6.

sum = 1 + 1 + 2 + 1 + 1 + 1 = 7 < 8

*/ 




class NaiveMaxBooks{
    public static void main(String[] args)
    {
        // int[] books ={1,1,2,1,1,1,4,2};
        int[] books2 = {1,6,2,1,4,1,1,1};
        int k = 8;
        System.out.println(maxBooksNaive(books2,k));
    }
    public static int maxBooksNaive(int [] books , int k)
    {
        int n = books.length;
        int maxBooks = 0;

        for(int i=0;i<n;i++)
        {
            int sum = 0;
            for(int j = i;j<n;j++)
            {
                sum+=books[j];

                if(sum>k)
                {
                    break;
                }
                maxBooks = Math.max(maxBooks , j-i+1);
            }
        }
        return maxBooks;
    }
}

/*
 Sliding Window Approach:

1. We maintain a window of books (a subarray) whose total reading time is ≤ k.
2. We expand the window from the right (add books) as long as the total reading time stays within k.
3. If the total reading time exceeds k, we shrink the window from the left (remove books) until we satisfy the constraint.
4. At every step, we track the maximum window size encountered.

 */