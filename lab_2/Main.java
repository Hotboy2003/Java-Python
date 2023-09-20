import java.util.Arrays;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        //problem_1();
        //problem_2();
        //problem_3();
        //problem_4();
        //problem_5();
        //problem_6();
        problem_7();
    }

    public static void problem_1()
    {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        int n = str.length();
        int start = 0, maxLength = 0;
        int[] visited = new int[256]; // Массив для хранения индексов символов

        Arrays.fill(visited, -1);

        int i;
        for (i = 0; i < n; i++)
        {
            char currentChar = str.charAt(i);

            if (visited[currentChar] != -1)
            {
                start = Math.max(start, visited[currentChar] + 1);
            }

            visited[currentChar] = i;
            maxLength = Math.max(maxLength, i - start + 1);
        }

        System.out.println(str.substring(start, start + maxLength));
    }

    public static void problem_2()
    {
        Scanner scanner = new Scanner(System.in);

        //ввод первого массива
        System.out.println("Напишите длину первого массива");
        int a = scanner.nextInt();
        int[] first = new int[a];
        System.out.println("Вводите числа первого массива по порядку");
        int j = 0;
        for (int i=0;i<a;i++)
        {
            j = scanner.nextInt();
            first[i] = j;
        }

        //ввод второго массива
        System.out.println("Напишите длину второго массива");
        int b = scanner.nextInt();
        int[] second = new int[b];
        System.out.println("Вводите числа второго массива по порядку");
        int q = 0;
        for (int i=0;i<b;i++)
        {
            q = scanner.nextInt();
            second[i] = q;
        }

        //что то типа сортировки вставками
        int c = a+b;
        int a_first = 0;
        int a_second = 0;
        int[] final_array = new int[c];
        for (int i = 0; i<c;i++)
        {
            if (a_first <= (a-1) && a_second <= (b-1))
            {
                if (first[a_first] <= second[a_second])
                {
                    final_array[i] = first[a_first];
                    a_first += 1;
                } else
                {
                    final_array[i] = second[a_second];
                    a_second += 1;
                }
            } else if (a_first>(a-1))
            {
                final_array[i] = second[a_second];
                a_second += 1;
            } else if (a_second>(b-1))
            {
                final_array[i] = first[a_first];
                a_first += 1;
            }
        }
        System.out.println(Arrays.toString(final_array));
    }

    public static void problem_3()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Напишите длину массива");
        int a = scanner.nextInt();
        int[] array = new int[a];
        System.out.println("Вводите числа массива по порядку");
        int j = 0;
        for (int i=0;i<a;i++)
        {
            j = scanner.nextInt();
            array[i] = j;
        }

        int maxsum = array[0];
        int currentsum = array[0];
        for (int i=0;i<array.length;i++)
        {
            currentsum = Math.max(array[i], currentsum + array[i]);
            maxsum = Math.max(maxsum, currentsum);
        }
        System.out.println(maxsum);
    }

    public static void problem_4()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите количество строк");
        int m = scanner.nextInt();
        System.out.println("Введите количество столбцов");
        int n = scanner.nextInt();
        //создание двух двумерных массивов
        int[][] array = new int[m][n];
        int[][] final_array = new int[n][m];

        //ввод двумерного массива
        System.out.println("Вводите числа массива по порядку (сначала строку, потом столбцы)");
        for (int i=0;i<m;i++)
        {
            for (int j=0;j<n;j++)
            {
                array[i][j] = scanner.nextInt();
            }
        }

        //Поворот на 90 градусов
        for (int i=0;i<m;i++)
        {
            for (int j=0;j<n;j++)
            {
                final_array[j][m-i-1] = array[i][j];
            }
        }

        //вывод финального массива
        for (int i=0;i<n;i++)
        {
            for (int j=0;j<m;j++)
            {
                System.out.print(final_array[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void problem_5()
    {
        Scanner scanner = new Scanner(System.in);
        StringBuilder builder = new StringBuilder();
        System.out.println("Напишите длину массива");
        int a = scanner.nextInt();
        int[] array = new int[a];
        System.out.println("Вводите числа массива по порядку");
        for (int i=0;i<a;i++)
        {
            array[i] = scanner.nextInt();
        }
        System.out.println("Введите число target");
        int target = scanner.nextInt();
        int count =0;

        for (int i=0;i<(a-1);i++)
        {
            for (int j=i;j<a;j++)
            {
                if (array[i] + array[j] == target)
                {
                    System.out.printf("%d %s%n",array[i], array[j]);
                    count ++;
                    break;
                }
            }
        }
        if (count == 0)
        {
            System.out.println("null");
        }
    }

    public static void problem_6()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите количество строк");
        int m = scanner.nextInt();
        System.out.println("Введите количество столбцов");
        int n = scanner.nextInt();
        //создание двух двумерных массивов
        int[][] array = new int[m][n];

        //ввод двумерного массива
        System.out.println("Вводите числа массива по порядку (сначала строку, потом столбцы)");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                array[i][j] = scanner.nextInt();
            }
        }

        int sum = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                sum += array[i][j];
            }
        }
        System.out.println(sum);
    }

    public static void problem_7()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите количество строк");
        int m = scanner.nextInt();
        System.out.println("Введите количество столбцов");
        int n = scanner.nextInt();
        //создание двух двумерных массивов
        int[][] array = new int[m][n];

        //ввод двумерного массива
        System.out.println("Вводите числа массива по порядку (сначала строку, потом столбцы)");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                array[i][j] = scanner.nextInt();
            }
        }

        for (int i=0;i<m;i++)
        {
            int max_number = array[i][0];
            for (int j=1;j<n;j++)
            {
                if (max_number < array[i][j])
                {
                    max_number = array[i][j];
                }
            }
            System.out.println(max_number);
        }
    }
}

