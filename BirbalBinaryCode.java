import java.util.Scanner;

public class BirbalBinaryCode {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int I = sc.nextInt(); // Read input integer I
        System.out.println(getBBC(I)); // Print BBC representation
        sc.close();
    }

    public static String getBBC(int I) {
        // Step 1: Compute k = ceil(log2(I + 2)) - 1
        int num = I + 2; // I + 2 to determine the range
        int k = 0;
        // Find the highest set bit position (log2 equivalent)
        while (num > 0) {
            num >>= 1; // Right shift by 1
            k++;
        }
        k--; // Subtract 1 to get ceil(log2(I + 2)) - 1

        // Step 2: Compute offset = I - (2^k - 1)
        int powerOfTwo = 1 << k; // 2^k using left shift
        int offset = I - (powerOfTwo - 1);

        // Step 3: Convert offset to k-bit binary string using bit manipulation
        StringBuilder result = new StringBuilder();
        for (int i = k - 1; i >= 0; i--) {
            // Check if the i-th bit is set in offset
            int bit = (offset >> i) & 1;
            result.append(bit);
        }

        return result.toString();
    }
}