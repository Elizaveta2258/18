import java.util.*;
interface Expression{
    boolean isEqual ( int a ,int  b);
}
public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner input = new Scanner(System.in);
        System.out.println("Выберите метод сортировки up (по возрастанию )или down (по убыванию)");
        String in = input.nextLine();
        int[] array = new int[10];
        for (int i = 0; i < array.length; i ++){
            array[i] = random.nextInt(100);
            System.out.print(array[i] + " ");
        }
        if (in.equals("up")) {
            Expression x = (a,b) -> a > b;
            bubbleSort(array, x);
        }
        else {
            Expression x = (a,b) -> a < b;
            bubbleSort(array, x);
        }
        System.out.println("\n Отсортированный массив");
        for (int j : array) {
            System.out.print(j + " ");
        }
    }
    public static void bubbleSort(int[] sortArr,Expression x){
        for (int i = 0; i < sortArr.length - 1; i++) { //по  строкам
            for (int j = 0; j < sortArr.length - i - 1; j++) { // по неотсортированному выражение
                if (x.isEqual(sortArr[j],sortArr[j + 1])) { // использование лямбды
                    int temp = sortArr[j];
                    sortArr[j] = sortArr[j + 1];
                    sortArr[j + 1] = temp;
                }
            }
        }
    }
}
