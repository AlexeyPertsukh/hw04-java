/*
•	1. Задача «Задом наперёд».
Написать программу, которая выполняет переворот исходного одномерного массива.
Например: для массива  [1,  2, 3, 4, 5, 6, 7] должно получиться [7, 6, 5, 4, 3, 2, 1]
 */



import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main1 {

    public static void main(String[] args) {
	// write your code here

        final int   ARR_LNG_MIN = 3;
        final int   ARR_LNG_MAX = 30;

        final int   MODE_INP_MANUAL = 1;
        final int   MODE_INP_RANDOM = 2;

        int     arrLength;
        int     buff;
        int     modeInp;

        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        do {
            System.out.printf("Введите размер массива (%d-%d): ", ARR_LNG_MIN, ARR_LNG_MAX);
            arrLength = sc.nextInt();

        } while (arrLength < ARR_LNG_MIN || arrLength  > ARR_LNG_MAX);

        do {
            System.out.printf("Введите режим заполнения  массива (%d-вручную, %d-случайными числами): ", MODE_INP_MANUAL, MODE_INP_RANDOM );
            modeInp = sc.nextInt();

        } while (modeInp  != MODE_INP_MANUAL && modeInp  != MODE_INP_RANDOM );

        System.out.println();

        int arr[] = new int[arrLength];

        //заполняем массив
        for (int i = 0; i < arr.length; i++)
            if(modeInp == MODE_INP_MANUAL) {
                System.out.printf("Введите элемент массива [%d]: ", i);
                arr[i] = sc.nextInt();
            }
            else
                arr[i] = random.nextInt(100);


        System.out.println();
        System.out.println("Исходный массив: " + Arrays.toString(arr));

        //переворачиваем массив
        for (int i = 0; i < (arr.length / 2); i++)
        {
            buff = arr[i];      //промежуточный буфер
            arr[i] = arr[arr.length - i - 1];
            arr[arr.length - i - 1] = buff;
        }

        System.out.println("Переворот:       " + Arrays.toString(arr));
    }
}
