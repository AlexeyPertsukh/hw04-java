/*
5. Требуется заполнить пустой массив размерностью [5][5]  числами, которые вводит пользователь, и вычислить их сумму.
Если пользователь вводит ноль или в массиве закончились свободные ячейки,
то ввод следует прекратить и вывести сумму того что пользователь уже задал.
 */

import java.util.Scanner;

public class Main5 {

    public static void main(String[] args) {
	// write your code here

        int val = 0;
        int sum = 0;

        Scanner sc = new Scanner(System.in);

        int arr[][] = new int[5][5];

        //Заполнение массива юзером
        for (int i = 0; i < arr.length; i++)
        {
            for (int j = 0; j < arr[0].length; j++)
            {
                System.out.printf("Введите элемент массива[%d][%d] или 0 для выхода : ",i ,j );
                val = sc.nextInt();
                if (val != 0)
                {
                    arr[i][j] = val;
                    sum += val;
                }
                else
                    break;
            }
            if (val == 0)
                break;
        }

        //вывод массива на экран
        System.out.println();

        for (int i = 0; i < arr.length ; i++)
        {
            for (int j = 0; j < arr[0].length; j++)
                System.out.printf("%5d   ", arr[i][j]);

            System.out.println();
        }

        System.out.println();
        System.out.println("Сумма всех элементов массива: " + sum);
    }
}
