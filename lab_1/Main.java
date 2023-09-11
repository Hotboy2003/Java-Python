import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        problem_1();
        //problem_2();
        //problem_3();
        //problem_4();
        //problem_5();
    }

    public static void problem_1() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите число: ");
        int number = scanner.nextInt();
        int count = 0;

        while (number != 1) {
            if (number % 2 == 0) {
                number = number / 2;
                count += 1;
            } else if (number % 2 != 0) {
                number = 3 * number + 1;
                count += 1;
            }
        }

        System.out.println(count);
    }

    public static void problem_2() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите количество чисел ряда: ");
        int number = scanner.nextInt();
        int[] Array = new int[number];
        int final_number = 0;

        System.out.println("Вводите числа ряда по порядку: ");
        for (int i = 0; i < number; i++) {
            int a = scanner.nextInt();
            if (i%2==0){
                final_number += a;
            } else {
                final_number -= a;
            }
        }
        System.out.println(final_number);

    }

    public static void problem_3() {
        Scanner scanner = new Scanner(System.in);
        int flag = 0;
        int x_0 = 0;
        int y_0 = 0;
        int count = 0;
        int count_final = 0;
        int a = 0;
        String s = "";
        System.out.println("Введите координаты клада: ");
        int x_clad = scanner.nextInt();
        int y_clad = scanner.nextInt();
        System.out.println("Вводите направление, а потом количество шагов: ");

        while (true) {
            s = scanner.next();
            if (s.equals("стоп")) {
                break;
            }
            a = scanner.nextInt();
            scanner.nextLine();
            if (s.equals("север")) {
                y_0 += a;
                count += 1;
            } else if (s.equals("юг")) {
                y_0 -= a;
                count += 1;
            } else if (s.equals("запад")) {
                x_0 -= a;
                count += 1;
            } else if (s.equals("восток")) {
                x_0 += a;
                count += 1;
            }

            if (x_0 == x_clad && y_0 == y_clad) {
                flag += 1;
                if (flag == 1) {
                    count_final = count;
                }
            }
        }
        System.out.println(count_final);
    }

    public static void problem_4() {
        Scanner scanner = new Scanner(System.in);
        int dorogi = 0;
        int tunelli = 0;
        int height_tunell = 0;
        int min_height = 10000;
        int flag = -1;
        int count = 0;
        int max_height = 0;

        System.out.println("Введите колмчество дорог: ");
        dorogi = scanner.nextInt();
        int[] arr;
        arr = new int[dorogi];

        for (int i = 0; i < dorogi; i++) {
            System.out.println("Введите количество тунеллей на дороге: ");
            tunelli = scanner.nextInt();
            min_height = 10000;
            flag += 1;
            System.out.println("Вводите высоты туннелей по порядку: ");
            for (int j = 0; j < tunelli; j++) {
                height_tunell = scanner.nextInt();
                min_height = Math.min(height_tunell, min_height);
            }
            arr[flag] = min_height;
        }

        for (int i = 0; i < dorogi; i ++) {
            if (max_height < arr[i]) {
                max_height = arr[i];
                count = i+1;
            }
        }
        System.out.println(count);
        System.out.println(max_height);
    }

    public static void problem_5() {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        int x_100 = (int) x/100;
        int x_10 = (int) x/10;
        x_10 = x_10%10;
        int x_1 = (int) x%10;

        int summ = x_1 + x_10 + x_100;
        int proiz = x_1 * x_10 * x_100;
        if (summ%2==0 && proiz%2==0) {
            System.out.println("Число дважды четное");
        } else {
            System.out.println("Число не дважды четное");
        }
    }
}
