import java.util.ArrayList;
import java.util.Scanner;

public class quickSort {

    public static void println(ArrayList<Integer> array){
        for(Integer i: array) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static int partition(ArrayList<Integer> array, int low, int high){
        int pivot = array.get(high);
        int i = low - 1;
        for(int j = low; j <= high - 1; j++){
            if(array.get(j) < pivot){
                // swap array.get(i) && array.get(j)
                i++;
                int temp = array.get(i);
                array.set(i, array.get(j));
                array.set(j, temp);
            }
        }
        int temp = array.get(high);
        array.set(high, array.get(i+1));
        array.set(i+1, temp);

        return i + 1;
    }

    public static void quickSort(ArrayList<Integer> array, int low, int high){
        if(low < high){
            int p = partition(array, low, high);
            quickSort(array, low, p-1);
            quickSort(array, p+1, high);
        }
    }

    public static void main(String[] args){
        ArrayList<Integer> array = new ArrayList<>();
        Scanner my_scanner = new Scanner(System.in);
        int num;
        System.out.println("Enter an integer");
        num = my_scanner.nextInt();

        for(int i = 0; i < num; i++){
            System.out.println("Enter the number: ");
            array.add(my_scanner.nextInt());
        }

        Integer L = 0;
        Integer H = array.size() - 1;

        println(array);
        quickSort(array, L, H);
        println(array);
    }

}
