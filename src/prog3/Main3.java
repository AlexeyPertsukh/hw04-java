/*
3. Задача «Антиматерия». Написать программу, которая выполняет замену всех чисел двумерного int-массива на противоположные.
При этом отрицательные числа становятся положительными, а положительные – отрицательными.
Например: двумерный массив [2][3] {{1, -2, -3}, { 2, 5, -9 }}  преобразуется в {{ -1, 2, 3}, { -2, -5, 9}}
 */

import java.util.Random;

public class Main3 {

    public static void main(String[] args) {
	// write your code here

    Random  random = new Random();

    int arrLengthH = 5 + random.nextInt(5);
    int arrLengthW = 5 + random.nextInt(5);

    int     arr[][] = new  int[ arrLengthH][ arrLengthW];

     //заполнение исходного массива случайными числами от -50 до 50
    for (int i = 0; i < arr.length ; i++)
        for (int j = 0; j < arr[0].length; j++)
            arr[i][j] = random.nextInt(100) - 50;

    //вывод исходного массива на печать
    System.out.printf("Массив %d x %d со случайными значениями от -50 до 50 \n", arr.length, arr[0].length);
    System.out.println("----------------------------------------------------------");

    for (int i = 0; i < arr.length ; i++)
        {
            for (int j = 0; j < arr[0].length; j++)
                System.out.printf("%3d    ", arr[i][j]);

            System.out.println();
        }

     //меняем в массиве значения ячеек на противоположные и выводим на печать
     System.out.println("\nПоменяли значения на противоположные");
     System.out.println("----------------------------------------------------------");

     for (int i = 0; i < arr.length ; i++)
        {
            for (int j = 0; j < arr[0].length; j++)
            {
                arr[i][j] *= -1;
                System.out.printf("%3d    ", arr[i][j]);
            }
            System.out.println();
        }


    }
}
