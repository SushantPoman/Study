

public class ArrayOperations {
    public static void main(String[] args) {
        // Creating an array of integers with size 5
        int[] arr = new int[5];
        // Inserting values into the array
        arr[0] = 10;
        arr[1] = 20;
        arr[2] = 30;
        arr[3] = 40;
        arr[4] = 50;
        // Accessing and printing a specific element
        System.out.println("Element at index 2: " + arr[2]);
        // Output: 30
        // Updating an element at a specific index
        arr[2] = 35;
        // Printing all elements (Traverse)
        System.out.println("Array Elements:");
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}

Output:
    Element at index 2: 30
    Array Elements:
    10
    20
    35
    40
    50