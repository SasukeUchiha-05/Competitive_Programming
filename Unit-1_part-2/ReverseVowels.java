/*Given a string s, reverse only all the vowels in the 
string and return it.

The vowels are 'a', 'e', 'i', 'o', and 'u', and they can 
appear in both lower and upper cases, more than once.

Sample Input-1:
---------------
hello

Sample Output-1:
----------------
holle

Sample Input-2:
----------------
Keshavmemorial

Sample Output-2:
----------------
Kashivmomerael
 */

 import java.util.*;
public class ReverseVowels{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        String inp = sc.nextLine();
        sc.close();
        
        reverseVowels(inp);
    }
    public static void reverseVowels(String inp)
    {
        Set<Character> set = new HashSet<>();
        char[] arr = {'a','e','i','o','u','A','E','I','O','U'};
        for(char v:arr)
        {
            set.add(v);
        }
        
        char[] opn = inp.toCharArray();
        
        int i=0 , j=opn.length-1;
        
        reverse(opn , i , j,set);
        
        for(int y=0;y<opn.length;y++)
        {
            System.out.print(opn[y]);
        }
    }
    private static void reverse(char[] arr , int l , int r, Set<Character> set)
    {
        while(l<r)
        {
            if(set.contains(arr[l]) && set.contains(arr[r]))
            {
                char temp = arr[l];
                arr[l] = arr[r];
                arr[r] = temp;
                l++;
                r--;
            }
            else{
                if(!set.contains(arr[l]))
                {
                    l++;
                }
                else if(!set.contains(arr[r])){
                    r--;
                }
            }
            
        }
    }
}