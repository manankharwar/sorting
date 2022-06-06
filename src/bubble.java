import java.util.ArrayList;
import java.util.Scanner;

public class bubble {
    // this one can take all the parameters like string, integers, etc.
    public static void println(ArrayList<Integer>... array){
        for(ArrayList i: array) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void bubbleSort(ArrayList<Integer> array){
        for(Integer i = 0; i < array.size() - 1; i++){
            for(Integer j = i + 1; j < array.size(); j++){
                if (array.get(i) <= array.get(j)){
                    // Do nothing
                }
                else{
                    // we swap the elements
                    Integer temp = array.get(j);
                    array.set(j, array.get(i));
                    array.set(i, temp);
                }
            }
        }
        println(array);
    }

    public static void main(String[] args){
        ArrayList<Integer> array = new ArrayList<Integer>();
        Scanner my_scanner = new Scanner(System.in);
        int num;
        System.out.println("Enter an integer");
        num = my_scanner.nextInt();

        for(int i = 0; i < num; i++){
            System.out.println("Enter the number: ");
            array.add(my_scanner.nextInt());
        }
        println(array);
        bubbleSort(array);
    }
}
