/*
 A string is good if there are no repeated characters.
Given a string s, return the number of good substrings of length three in s.
Note that if there are multiple occurrences of the same substring, every occurrence should be counted.
A substring is a contiguous sequence of characters in a string.

Sample Input-1:
---------------
xyzzaz

Sample Output-1:
----------------
1

Explanation: 
------------
There are 4 substrings of size 3: "xyz", "yzz", "zza", and "zaz". 
The only good substring of length 3 is "xyz".

Sample Input-2:
---------------
aababcabc

Sample Output-2:
----------------
4

Explanation: 
------------
There are 7 substrings of size 3: "aab", "aba", "bab", "abc", "bca", "cab", and "abc".
The good substrings are "abc", "bca", "cab", and "abc".
 */



import java.util.*;
class GoodStrings{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        sc.close();
        
        System.out.println(noOfGoodStrings(input));
    }
    
    public static int noOfGoodStrings(String s)
    {
        int n = s.length();
        int k = 3;
        int counter = 0;
        
        if(n<=k)
        {
            if(isGoodString(s))
            {
                return 1;
            }
            return 0;
        }
        for(int i=0;i<=n-k;i++)
        {
            String curr = s.substring(i,i+3);
            
            if(isGoodString(curr))
            {
                counter++;
            }
        }
        return counter;
    }
    
    private static boolean isGoodString(String str)
    {
        // HashSet<Character> set = new HashSet<>();
        
        // for(char c: str.toCharArray()){
        //     if(set.contains(c)){
        //         return false;
        //     }
        //     set.add(c);
        // }
        // return true;
        
     return str.charAt(0) != str.charAt(1) &&
            str.charAt(0) != str.charAt(2) &&
            str.charAt(1) != str.charAt(2);
    }
}
