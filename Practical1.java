class Practical1 {
    public static void bubbleSort(int[] arr){
        int n = arr.length;
        boolean noSwap = false;
        //while(true){
        for(int i=0; i<n; i++){
            for(int j = 0; j<n-i-1; j++){
                if(arr[j]>arr[j+1]) {
                    int temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                    noSwap = false;

                }
                else noSwap = true;
            }
            if(noSwap) break;
        }
        //}
    }
    public static void printArray(int[] arr){
        for (int i : arr){
            System.out.print(i+" ");
        }
        System.out.println();
    }

    public static void SortedArray(int[] arr1, int n) {
        // Sorted Array
        for(int i = 1; i<=n; i++) arr1[i-1] = i;
    }

    public static void ReverseSortedArray(int[] arr2, int n) {
        // Reverse Sorted Array
        for(int i = 1; i<=n; i++) arr2[i-1] = n-i;
    }

    public static void RandomArray(int[] arr3, int n) {
        // Random Array
        for(int i = 1; i<=n; i++) arr3[i-1] = (int)(Math.random()*n);
    }

    public static long TimeCalculation(int[] arr1){
        //printArray(arr1);
        long start = System.currentTimeMillis();
        bubbleSort(arr1);
        long end = System.currentTimeMillis();
        //printArray(arr1);
        return end-start;
    }

    public static void main(String[] args) {
        // Sorted Array
        long[] timeSortedArray = new long[10];
        System.out.println("For Sorted Array: ");
        for(int i = 1; i<=10; i++){
            int[] arr1 = new int[i*1000];
            SortedArray(arr1, i*1000);
            timeSortedArray[i-1] = TimeCalculation(arr1);
            System.out.println(i+" : "+timeSortedArray[i-1]+"    ");
        }
        // Reverse Sorted Array
        long[] timeReverseSortedArray = new long[10];
        System.out.println("For Reverse Sorted Array: ");
        for(int i = 1; i<=10; i++){
            int[] arr1 = new int[i*1000];
            ReverseSortedArray(arr1, i*1000);
            timeReverseSortedArray[i-1] = TimeCalculation(arr1);
            System.out.println(i+" : "+timeReverseSortedArray[i-1]+"    ");
        }
        // Random Array
        long[] timeRandomArray = new long[10];
        System.out.println("For Random Array: ");
        for(int i = 1; i<=10; i++){
            int[] arr1 = new int[i*1000];
            RandomArray(arr1, i*1000);
            timeRandomArray[i-1] = TimeCalculation(arr1);
            System.out.println(i+" : "+timeRandomArray[i-1]+"    ");
        }
    }
}