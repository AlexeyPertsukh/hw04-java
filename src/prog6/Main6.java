/*
6. Задача «Ищейка». В заданном массиве int [5][5] произвести поиск числа, который ввёл пользователь.
Показать на экране координаты каждой ячейки, содержащий число, которое пользователь ищет.
 */

import java.util.Random;
import java.util.Scanner;

public class Main6 {

    public static void main(String[] args) {
	// write your code here

        final int   ARR_LNG = 5;

        final int   MODE_INP_MANUAL = 1;
        final int   MODE_INP_RANDOM = 2;

        int modeInp;
        int findCnt = 0;
        int findVal;
        int arr[][] = new int[ARR_LNG][ARR_LNG];

        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        do {
            System.out.printf("Введите режим заполнения  массива (%d-вручную, %d-случайными числами): ", MODE_INP_MANUAL, MODE_INP_RANDOM );
            modeInp = sc.nextInt();

        } while (modeInp  != MODE_INP_MANUAL   && modeInp  != MODE_INP_RANDOM );

        //заполнение массива
        for (int i = 0; i < arr.length; i++)
            for (int j = 0; j < arr[0].length; j++)
                if(modeInp == MODE_INP_MANUAL)
                    {
                        System.out.printf("Введите элемент массива [%d][%d]: ",i ,j);
                        arr[i][j] = sc.nextInt();
                    }
                else
                    arr[i][j] = random.nextInt(1000);

        System.out.println();

        //вывод массива на экран
        for (int i = 0; i < arr.length ; i++)
        {
            for (int j = 0; j < arr[0].length; j++)
                System.out.printf("%5d    ", arr[i][j]);

            System.out.println();
        }

        //поиск числел в массиве
        System.out.println();
        System.out.print("Введите число для поиска: ");
        findVal = sc.nextInt();

        for (int i = 0; i < arr.length; i++)
            for (int j = 0; j < arr[0].length; j++)
                 if(findVal == arr[i][j])
                 {
                     findCnt++;

                     if (findCnt == 1) //нашли первое вхождение числа в массив
                         System.out.println("Координаты числа в массиве:");

                     System.out.printf("[ %d , %d ] \n", i, j);
                 }

        if(findCnt != 0)
            System.out.printf("\nВсего вхождений числа %d в массив: %d", findVal, findCnt);
        else
            System.out.printf("Число %d в массиве отсутствует", findVal);

    }
}
