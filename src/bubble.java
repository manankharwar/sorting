import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class bubble {
    // this one can take all the parameters like string, integers, etc.
    @SafeVarargs
    public static void println(ArrayList<Integer>... array){
        for(ArrayList<Integer> i: array) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void bubbleSort(ArrayList<Integer> array){
        for(int i = 0; i < array.size() - 1; i++){
            for(int j = i + 1; j < array.size(); j++){
                if(array.get(i) > array.get(j)){
                    // we swap the elements
                    Integer temp = array.get(j);
                    array.set(j, array.get(i));
                    array.set(i, temp);
                }
            }
        }
        println(array);
    }

    public static void optimizedBubbleSort(ArrayList<Integer> array){
        boolean isSwapped = false;
        for(int i = 0; i < array.size() - 1; i++){
            for(int j = i + 1; j < array.size(); j++){
                if (array.get(i) > array.get(j)){
                    isSwapped = true;
                    // swapping happens
                    Integer temp = array.get(j);
                    array.set(j, array.get(i));
                    array.set(i, temp);
                }
            }
            if(!isSwapped){
                break;
            }
        }
        println(array);
    }

    public static Integer partition(ArrayList<Integer> array, Integer low, Integer high){
        int pivot_value = array.get(high);
        int i = low - 1; // index of smaller element and indicates the correct position of the pivot_value
        for(int j = low; j <= high - 1; j++){
            if (array.get(j) < pivot_value){
                i++;
                // swap two elements
                int temp = array.get(j);
                array.set(j, array.get(i));
                array.set(i, temp);
            }
        }
        int temp = array.get(high);
        array.set(high, array.get(i + 1));
        array.set(i + 1, temp);
        return i + 1;
    }
    public static void quickSort(ArrayList<Integer> array, Integer L, Integer H){
        if(L < H){
            int p = partition(array, L, H);
            quickSort(array, L, p - 1);
            quickSort(array, p + 1, H);
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
        //bubbleSort(array);
        //optimizedBubbleSort(array);
        quickSort(array, L, H);
        println(array);
    }
}
