public class selectionsort {

    public static void selectionSort(int arr[]){
        for (int turn=0; turn<arr.length-1; turn++){
            int minPos = turn;
            for (int j=turn+1; j<=arr.length-1;j++){
                if(arr[minPos]>arr[j]){ // increasing order
                // if(arr[minPos]<arr[j]){  for descreasing order
                    minPos=j;
                }
            }

            int temp = arr[minPos];
            arr[minPos]=arr[turn];
            arr[turn]=temp;
        }
    }

      public static void printArr(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    
    public static void main(String args[]){
        int arr[]={50,34,21,7,4};
        selectionSort(arr);
        printArr(arr);


    }
}
