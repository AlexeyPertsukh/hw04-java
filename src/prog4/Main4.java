/*
4. Задача «Только оригиналы». В исходном двумерном массиве удалить все дубликаты чисел, заменив их нулями.
То есть, если какое-то число встречается больше одного раза – первый экземпляр числа оставить – остальные заменить нулями.
 */


import java.util.Random;
import java.util.Scanner;

public class Main4 {

    public static void main(String[] args) {
	// write your code here

        final int   ARR_LNG_MIN = 3;
        final int   ARR_LNG_MAX = 20;

        final int   MODE_INP_MANUAL = 1;
        final int   MODE_INP_RANDOM = 2;

        int     modeDelDoub;
        String  strModeDelDoubl;
        int     modeInp;
        int     cntDelDoub=0;

        int lineAdr;
        int idx0I,  idx0J;
        int idx1I,  idx1J;

        int     arrLength;

        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        do {
            System.out.print("Введите режим удаления дубликатов (0-обнуление, 1-удаление из массива): ");
            modeDelDoub = sc.nextInt();

        } while (modeDelDoub < 0  || modeDelDoub > 1);


        do {
            System.out.printf("Введите размер массива (%d-%d): ", ARR_LNG_MIN, ARR_LNG_MAX);
            arrLength = sc.nextInt();

        } while (arrLength < ARR_LNG_MIN  || arrLength > ARR_LNG_MAX);

        do {
            System.out.printf("Введите режим заполнения  массива (%d-вручную, %d-случайными числами): ", MODE_INP_MANUAL, MODE_INP_RANDOM );
            modeInp = sc.nextInt();

        } while (modeInp != MODE_INP_MANUAL   && modeInp != MODE_INP_RANDOM );



        int arr[][] = new int[arrLength][arrLength];
        //Заполнение массива
        for (int i = 0; i < arr.length; i++)
            for (int j = 0; j < arr[0].length; j++)
             if(modeInp == MODE_INP_MANUAL)                   //заполнение массива вручную
            {
                System.out.printf("Введите элемент массива [%d][%d]: ", i, j);
                arr[i][j] = sc.nextInt();
            }
        else
               arr[i][j] = random.nextInt(arr.length * arr[0].length);  //заполнение массива рандомом


        //вывод исходного массива на экран
        System.out.println();
        System.out.println("Исходный массив " );

        for (int i = 0; i < arr.length ; i++)
        {
            for (int j = 0; j < arr[0].length; j++)
                System.out.printf("%5d   ", arr[i][j]);

            System.out.println();
        }

        //удаление дубликатов

        int lineArrLength = arr.length * arr[0].length; //общее количество ячеек в массиве

        for (int i = 0; i < arr.length ; i++)
            for (int j = 0; j < arr[0].length; j++)
            {
               lineAdr= (i * arr[0].length) + j;    // Преобразуем 2-мерный адрес ячеек в 1-мерный(линейный)

                for (int k = lineAdr+1; k < lineArrLength; k++)     //обрабатываем массив как псевдоодномерный- так проще
                {
                  idx0J = k % arr[0].length;            //Преобразуем 1-мерный адрес ячеек в 2-мерный
                  idx0I = (k - idx0J)/arr[0].length;


                  if(arr[i][j] == arr[idx0I][idx0J])        //нашли дубликат
                  {
                      if (modeDelDoub == 0)
                          arr[idx0I][idx0J] = 0;              //Режим удаления дубликата: обнуление
                      else
                          {                                     //Режим удаления дубликата: удаление из массива
                            for (int k2 = k; k2 < lineArrLength - 1; k2++)
                            {
                              idx0J = k2 % arr[0].length;
                              idx0I = (k2 - idx0J) / arr[0].length;

                              idx1J = (k2 + 1) % arr[0].length;
                              idx1I = ((k2 + 1) - idx1J) / arr[0].length;

                              arr[idx0I][idx0J] = arr[idx1I][idx1J];
                            }

                            idx0J = (lineArrLength - 1) % arr[0].length;
                            idx0I = (lineArrLength - 1 - idx0J) / arr[0].length;
                            arr[idx0I][idx0J] = 0;

                            k--;
                            lineArrLength--;
                          }
                      cntDelDoub++;
                  }
                }

            }

        //вывод массива без дубликатов на экран
        System.out.println();
        strModeDelDoubl = (modeDelDoub == 0) ? "обнуление дубликатов" : "удаление из массива";
        System.out.println("Режим удаления дубликатов: " + strModeDelDoubl);

        System.out.println("Очистили от дубликатов " );

        for (int i = 0; i < arr.length ; i++)
        {
            for (int j = 0; j < arr[0].length; j++)
                System.out.printf("%5d   ", arr[i][j]);

            System.out.println();
        }

        System.out.println("\nУдалено дубликатов: " + cntDelDoub);

    }
}
