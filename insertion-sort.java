import java.util.Arrays;

public class insertion {

    public static int [] insertionSort(int arr[]){
        int i,j,key;
        for (j = 1; j < arr.length; j++){
            key=arr[j];
            //insertar en la secuencia ordenada
            i = j -1;
            while(i >= 0 && (arr[i] > key)){
                arr[i+1] = arr[i];
                    i--;
            }
            arr[i+1] = key;

        }
        return arr;
    }
    public static void main (String [] args ) {

        int unorderedList[]={45,67,88,88,88,90,1,2,345,66};

        System.out.println(Arrays.toString(insertionSort(unorderedList)));

    }

}
