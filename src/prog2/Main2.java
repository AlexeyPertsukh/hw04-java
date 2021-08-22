/*
2. Задача «Деньги любят счёт». В двумерном массиве типа double хранятся пары значений: цена товара, количество штук.
Например: double[2][2] = { { 12.50, 1.0 }, { 50.25, 2.0 } } и т.д.
Вам нужно посчитать итоговую сумму чека перемножив цену товара на количество штук по каждой строке и сложив итоговые суммы всех строчек.
*/



import java.util.Scanner;

public class Main2 {

    public static void main(String[] args) {
	// write your code here

        final int   MAX_ARR_LNG = 5;
        double      prodPrice;
        double      prodPriceTotal= 0;

        Scanner sc = new Scanner(System.in);

        double  prodArr[][] = new double[MAX_ARR_LNG][2];

        for (int i = 0; i < prodArr.length; i++)
        {
            System.out.printf("Товар #%d. Цена:       ", (i+1));
            prodArr[i][0] = sc.nextDouble();

            System.out.printf("Товар #%d. Количество: ", (i+1));
            prodArr[i][1] = sc.nextDouble();
        }

        System.out.println("\nЧек покупки");

        for (int i = 0; i < prodArr.length; i++)
        {
            prodPrice = prodArr[i][0] * prodArr[i][1];
            prodPriceTotal += prodPrice;

            System.out.printf("Товар #%d: %7.2f грн  x  %7.2f =  %7.2f грн  \n", i, prodArr[i][0], prodArr[i][1], prodPrice);

        }

        System.out.printf("\nВсего: %.2f грн", prodPriceTotal);

    }
}
