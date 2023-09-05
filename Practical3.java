import java.sql.SQLOutput;
import java.util.*;
public class Practical3 {
    public static Scanner sc = new Scanner(System.in);

    public static int[] inputArray(){
        System.out.print("Enter the number of elements in the array : ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Now enter the array :");
        for(int i = 0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        return arr;
    }

    public static int[][] inputMatrix(int n, int m){
        System.out.println("Please enter " + n*m + " elements in row-wise order.");
        int[][] matrix = new int[n][m];
        for(int i = 0; i<n; i++){
            for(int j =0; j<m; j++){
                matrix[i][j] = sc.nextInt();
            }
        }
        return matrix;
    }

    public static void printArray(int[] arr){
        for(int i : arr) System.out.print(i + " ");
        System.out.println();
    }

    public static void printMatrix(int[][] matrix, int n, int m){
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                System.out.print(matrix[i][j] + "  ");
            }
            System.out.println();
        }
    }

    public static void reverseArray(int[] arr){
        int n = arr.length;
        for(int i =0; i<(n)/2; i++){
            int temp = arr[i];
            arr[i] = arr[n-1-i];
            arr[n-i-1] = temp;
        }
    }

    public static void collegeName(){
        StringBuilder result = new StringBuilder("Your college name is :");
        String[] arr = {"","","","","","",""};
        System.out.print("Enter your college name (7 words) : ");
        for(int i = 0; i<7; i++){
            arr[i] = sc.next();
        }
        for( String i : arr){
            result.append(" ").append(i);
        }
        System.out.println(result);
    }

    public static void decimalToBinary(){
        System.out.print("Enter the number you want to convert to binary : ");
        int n = sc.nextInt();
        int[] arr = new int[20];
        int count = 0;
        while(n!=0){
            arr[count] = n%2;
            n = n/2;
            count++;
        }
        arr = Arrays.copyOfRange(arr, 0, count);
        reverseArray(arr);
        printArray(arr);
    }

    public static void secondLargest(int[] arr){
        int max = arr[0];
        int nextMax = 0;
        for(int i = 1; i<arr.length; i++){
            if(arr[i] > nextMax && arr[i] < max) nextMax = arr[i];
            else if(arr[i] > max){
                nextMax = max;
                max = arr[i];
            }
        }
        System.out.println("The second largest number is " + nextMax);
    }

    public static void secondSmallest(int[] arr){
        int min = arr[0];
        int nextMin = Integer.MAX_VALUE;
        for(int i = 1; i<arr.length; i++){
            if(arr[i] < nextMin && arr[i] > min) nextMin = arr[i];
            else if(arr[i] < min) {
                nextMin = min;
                min = arr[i];
            }
        }
        System.out.println("The second smallest number is " + nextMin);
    }

    public static void oddEvenIndex(int[] arr){
        System.out.println("Original array :");
        printArray(arr);
        for(int i = 0; i<arr.length - 1;){
            int temp = arr[i];
            arr[i] = arr[i+1];
            arr[i+1] = temp;
            i+=2;
        }
        System.out.println("Odd-Even swapped index Array :");
        printArray(arr);
    }

    public static void addMatrix(){
        System.out.println("Enter order of matrix1 in the form : 2 3");
        int n1 = sc.nextInt();
        int m1 = sc.nextInt();
        int[][] matrix1 = inputMatrix(n1,m1);
        System.out.println("Enter order of matrix2 in the form : 2 3");
        int n2 = sc.nextInt();
        int m2 = sc.nextInt();
        if(n1 != n2 || m1 != m2){
            System.out.println("Incompatible matrix dimensions");
            return;
        }
        int[][] matrix2 = inputMatrix(n2,m2);
        int[][] result = new int[n1][m1];
        for(int i = 0; i<n1; i++){
            for(int j = 0; j<m1; j++){
                result[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }
        System.out.println("The resultant matrix is :");
        printMatrix(result, n1, m1);
    }

    public static void subtractMatrix(){
        System.out.println("Enter order of matrix1 in the form : 2 3");
        int n1 = sc.nextInt();
        int m1 = sc.nextInt();
        int[][] matrix1 = inputMatrix(n1,m1);
        System.out.println("Enter order of matrix2 in the form : 2 3");
        int n2 = sc.nextInt();
        int m2 = sc.nextInt();
        if(n1 != n2 || m1 != m2){
            System.out.println("Incompatible matrix dimensions");
            return;
        }
        int[][] matrix2 = inputMatrix(n2,m2);
        int[][] result = new int[n1][m1];
        for(int i = 0; i<n1; i++){
            for(int j = 0; j<m1; j++){
                result[i][j] = matrix1[i][j] - matrix2[i][j];
            }
        }
        System.out.println("The resultant matrix is :");
        printMatrix(result, n1, m1);
    }

    public static void multiplyMatrix(){
        System.out.println("Enter order of matrix1 in the form : 2 3");
        int n1 = sc.nextInt();
        int m1 = sc.nextInt();
        int[][] matrix1 = inputMatrix(n1,m1);
        System.out.println("Enter order of matrix2 in the form : 2 3");
        int n2 = sc.nextInt();
        int m2 = sc.nextInt();
        if(m1 != n2){
            System.out.println("Incompatible matrix dimensions");
            return;
        }
        int[][] matrix2 = inputMatrix(n2,m2);
        int[][] result = new int[n1][m2];
        for(int i = 0; i<n1; i++){
            for(int j = 0; j<m2; j++){
                for(int k = 0; k<n1; k++){
                    result[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }
        System.out.println("The resultant matrix is :");
        printMatrix(result, n1, m2);
    }

    public static void main(String[] args) {
        int[] arr = inputArray();
//         int[] arr = {1,4,2,4,56,24,62,13,63,13};
        //Question1
        System.out.println("Original Array :");
        printArray(arr);
        reverseArray(arr);
        System.out.println("Reversed Array :");
        printArray(arr);
        //Question2
        collegeName();
        //Question3
        decimalToBinary();
        //Question4
        secondLargest(arr);
        secondSmallest(arr);
        //Question5
        oddEvenIndex(arr);
        //Question6
        System.out.println("Enter a choice : 1. Matrix Addition   2. Matrix Subtraction   3. Matrix Multiplication");
        int choice = sc.nextInt();
        switch(choice){
            case 1 -> addMatrix();
            case 2 -> subtractMatrix();
            case 3 -> multiplyMatrix();
            default -> System.out.println("Invalid choice");
        }
    }
}