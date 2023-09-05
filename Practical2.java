import java.util.*;
public class Practical2 {
    public static boolean sortedArray = false;
    public static int noe;
    public static int max_noe;
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

    public static void binarySearch(int[] arr, int s, int e, int element){
        if(s>e){
            System.out.println("No element found");
            return;
        }
        int mid = (s+e)/2;
        if(arr[mid] == element){
            System.out.println("The element is at index : "+mid);
            return;
        }
        else if(arr[mid]<element) {
            binarySearch(arr, mid+1, e, element);
        }
        else {
            binarySearch(arr,s,mid-1,element);
        }
    }

    public static void linearSearch(int[] arr, int element){
        if(noe==0) {
            System.out.println("No element found");
            return;
        }
        else {
            for(int i=0; i<noe; i++){
                if(arr[i] == element){
                    System.out.println("The element is at index : "+i);
                    return;
                }
            }
            System.out.println("No element found");
        }
    }

    public static void insertArray(int[] arr){
        System.out.print("Enter the element you wish to insert : ");
        int element = sc.nextInt();
        System.out.print("Enter the index you wish to insert the element at : ");
        int index = sc.nextInt();
        if(index == noe) {
            arr[noe] = element;
            noe++;
            return;
        }
        else if(index>noe) {
            System.out.println("Invalid index");
            return;
        }
        for(int i=noe; i>index; i--){
            arr[i] = arr[i-1];
        }
        arr[index] = element;
        noe++;
    }

    public static void deleteArray(int[] arr){
        System.out.print("Enter the index you wish to delete the element at : ");
        int index = sc.nextInt();
        if(index == noe-1) {
            arr[noe-1] = 0;
            noe--;
            return;
        }
        else if(index>=noe) {
            System.out.println("Invalid index");
            return;
        }
        for(int i=index; i<noe-1; i++){
            arr[i] = arr[i+1];
        }
        arr[noe-1] = 0;
        noe--;
    }

    public static void printArray(int[] arr){
        System.out.println("The array is : ");
        for (int j = 0; j<noe; j++) System.out.print(arr[j] + " ");
        System.out.println();
    }

    public static void searchArray(int[] arr){
        System.out.print("Enter the element you wish to find : ");
        int element = sc.nextInt();
        if(sortedArray) binarySearch(arr, 0, noe, element);
        else linearSearch(arr, element);
    }

    public static void sortArray(int[] arr){
        sortedArray = true;
        int n = noe;
        boolean noSwap = false;
        for(int i=0; i<n; i++){
            for(int j = 0; j<n-i-1; j++){
                if(arr[j]>arr[j+1]){
                    int temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                    noSwap = false;
                }
                else noSwap = true;
            }
            if(noSwap) break;
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[20];
        int[] arr2 = inputArray();
        System.arraycopy(arr2, 0, arr, 0, arr2.length);
        noe = arr2.length;
        max_noe = 20;
        System.out.println("The array has " + noe +" elements.\n What operation do wish to perform on the array : 1. Insert  2. Delete  3. Transverse  4. Search  5. Sort  6. Exit");
        int choice = sc.nextInt();
        while(choice != 6){
            switch (choice) {
                case 1 -> insertArray(arr);
                case 2 -> deleteArray(arr);
                case 3 -> printArray(arr);
                case 4 -> searchArray(arr);
                case 5 -> sortArray(arr);
            }
            System.out.println("The array has " + noe +" elements.\n What operation do wish to perform on the array : 1. Insert  2. Delete  3. Transverse  4. Search  5. Sort  6. Exit");
            choice = sc.nextInt();
        }
        System.out.println("Thank you for using arrays!");
    }
}