/*
7. Задача «Суровые судьи КВН». 5 членов жюри КВН оценивают выступления команд, выставляя оценки от 1 до 5.
Нужно последовательно ввести оценки судий, поместить их в массив и вычислить среднее арифметическое, получив,
таким образом, итоговую оценку за выступление команды. Для получения среднего арифметического из 5 оценок –
просуммируйте все оценки и разделите их на 5 (на число оценок).
Например, судьи выставили оценки: 2,4,5,3,4. Итоговая оценка команды будет (2+4+5+3+4) / 5 = 3.6.
 */

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main7 {

    public static void main(String[] args) {

        double  teamRatingAverage = 0;

        String  teamNameCur;

        Scanner sc = new Scanner(System.in);

        String  teamArrName[] = new String[] {"Плюшки имени Ярослава Мудрого", "95 квартал", "Федор Двинятин", "Сборная Мурманска",
                                            "РУДН, Москва", "Дети лейтенанта Шмидта", "Уральские пельмени"} ;

        String  arbiterArrName[]    = new String[] {"Гусман", "Галустян", "Ярмольник", "Пельш", "какая-то блондинка"};

        int     arbiterArrRating[]  = new int[arbiterArrName.length];   //массив с оценками

        Random random = new Random();

        teamNameCur = teamArrName[ random.nextInt( teamArrName.length )];
        System.out.printf("Оцените выступление команды КВН \"%s\" \n", teamNameCur);

        //ввод оценок
        for (int i = 0; i < arbiterArrName.length; i++)
            do {
                System.out.printf("%d. Оценку ставит %s (1-5): ", i+1, arbiterArrName[i]);
                arbiterArrRating[i] = sc.nextInt();
            } while (arbiterArrRating[i] < 1 ||arbiterArrRating[i] > 5);

        //Обработка результатов
        for (int i = 0; i <  arbiterArrRating.length; i++)
            teamRatingAverage += arbiterArrRating[i];

        teamRatingAverage /= arbiterArrRating.length;  //среднее за выступление

        //Вывод результатов
        System.out.println();
        System.out.println("Оценки за выступление: " + Arrays.toString( arbiterArrRating ));
        System.out.printf("Средний бал:            %.1f ",  teamRatingAverage);

    }
}
