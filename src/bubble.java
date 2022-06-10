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

    //starting off with a good one! All the best
    public static void mergeSort(ArrayList<Integer> array, ArrayList<Integer> temp, int lowStart, int highEnd){
        int middle = (lowStart + highEnd) / 2;
        mergeSort(array, temp, lowStart, middle);
        mergeSort(array, temp, middle + 1, highEnd);
        mergeHalves(array, temp, lowStart, highEnd);
    }

    public static void mergeHalves(ArrayList<Integer> array, ArrayList<Integer> temp, int lowStart, int highEnd){
        int lowEnd = (lowStart + highEnd) / 2;
        int highStart = lowEnd + 1;
        int size = highEnd - lowStart + 1;

        int left = lowStart;
        int high = highStart;
        int index = lowStart;

        while(left <= lowEnd && high <= highEnd){
            if (array.get(left) <= array.get(high)){
                temp.set(index, array.get(left));
                left += 1;
            }
            else{
                temp.set(index, array.get(high));
                high += 1;
            }
            index += 1;
            // if one of the pointers goes out of bounds, what we need to do is just copy the remainder of the elements
            temp.addAll(lowEnd - left + 1, array);
            temp.addAll(highEnd - high + 1, array);
            array.addAll(temp);
        }
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

    public static void insertionSort(int[] array){
        for(int i = 1; i < array.length; i++){
            int j = i - 1;
            int key = array[i];
            while(j >= 0 && key < array[j]){
                int temp = array[j];
                array[j] = array[j+1];
                array[j+1] = temp;
                j = j - 1;
            }
            array[j+1] = key;


        }
        System.out.printf("[");
        for(int i = 0; i < array.length; i++){
            System.out.print(array[i] + ", ");
        }
        System.out.printf("]");
    }

    public static void selectionSort(ArrayList<Integer> array){
        for(int i = 0; i < array.size() - 1; i++){
            int min = i;
            for(int j = i+1; j < array.size(); j++ ){
                if(array.get(j) < array.get(min)){
                    min = j;
                }
            }
            int temp = array.get(min);
            array.set(min, i);
            array.set(i, temp);
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
        //quickSort(array, L, H);
//        int[] insert_array = new int[]{10,12,23,4,25};
//        insertionSort(insert_array);
        //selectionSort(array);
        int low = 0;
        int high = array.size();
        mergeSort(array, new ArrayList<Integer>(), low, high);
        println(array);
    }
}
