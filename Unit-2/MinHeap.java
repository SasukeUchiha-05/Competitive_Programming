/*Design and implement a Min Heap data structure using an array in Java. 
In a Min Heap, every parent node is less than or equal to its child nodes, 
ensuring that the smallest element is always at the root.

Sample Input:
-------------
5
1 2 3 4 5

Sample Output:
--------------
The min value is 1 */

import java.util.*;

public class MinHeap {
    private int[] Heap;
    private int size;
    private int maxsize;

    // Constructor to initialize an empty min heap
    public MinHeap(int maxsize) {
        this.maxsize = maxsize;
        this.size = 0;
        Heap = new int[maxsize];
    }

    // Return the index of the parent
    private int parent(int pos) {
        return (pos - 1) / 2;
    }

    // Return the index of the left child
    private int leftChild(int pos) {
        return 2 * pos + 1;
    }

    // Return the index of the right child
    private int rightChild(int pos) {
        return 2 * pos + 2;
    }

    // Check if the node at pos is a leaf node
    private boolean isLeaf(int pos) {
        return pos >= size / 2 && pos < size;
    }

    // Swap nodes at positions fpos and spos
    private void swap(int fpos, int spos) {
        int temp = Heap[fpos];
        Heap[fpos] = Heap[spos];
        Heap[spos] = temp;
    }

    // Recursive function to min heapify the subtree at index pos
    private void minHeapify(int pos) {
        if (isLeaf(pos)) return;

        int left = leftChild(pos);
        int right = rightChild(pos);
        int smallest = pos;

        if (left < size && Heap[left] < Heap[smallest]) {
            smallest = left;
        }
        if (right < size && Heap[right] < Heap[smallest]) {
            smallest = right;
        }
        if (smallest != pos) {
            swap(pos, smallest);
            minHeapify(smallest);
        }
    }

    // Insert a new element into the min heap
    public void insert(int element) {
        if (size >= maxsize) {
            System.out.println("Heap is full!");
            return;
        }

        Heap[size] = element;
        int current = size;
        size++;

        // Bubble up
        while (current > 0 && Heap[current] < Heap[parent(current)]) {
            swap(current, parent(current));
            current = parent(current);
        }
    }

    // Remove and return the minimum element from the heap
    public int extractMin() {
        if (size == 0) {
            System.out.println("Heap is empty!");
            return -1;
        }
        int min = Heap[0];
        Heap[0] = Heap[size - 1];
        size--;
        minHeapify(0);
        return min;
    }

    // Display the heap's structure (for each parent, show its children)
    public void print() {
        for (int i = 0; i < size / 2; i++) {
            System.out.print("Parent: " + Heap[i]);
            if (leftChild(i) < size)
                System.out.print(" Left Child: " + Heap[leftChild(i)]);
            if (rightChild(i) < size)
                System.out.print(" Right Child: " + Heap[rightChild(i)]);
            System.out.println();
        }
    }

    // Main method to demonstrate the Min Heap operations
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        MinHeap minHeap = new MinHeap(n);
        
        // Insert n elements into the heap
        for (int i = 0; i < n; i++) {
            minHeap.insert(scan.nextInt());
        }
        minHeap.print();

        // Extract and display the minimum element
        System.out.println("The min value is " + minHeap.extractMin());
        
        scan.close();
    }
}
