public class HomeWorkApp {
    public static void main(String[] args) {

        System.out.println("(#1) ---------------------------------------");
        int[] invArr = { 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 };
        invertArray(invArr);

        System.out.println("\n\n(#2) ---------------------------------------");
        print1DArray(fillArray(100));

        System.out.println("\n(#3) ---------------------------------------");
        int[] chgArr = {  1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1  };
        changeArray(chgArr);

        System.out.println("\n(#4) ---------------------------------------");
        fillDiagonal(4);

        System.out.println("\n(#5) ---------------------------------------");
        int[] initArr = getInitArray(11, 101);
        print1DArray(initArr);

        System.out.println("\n(#6) ---------------------------------------");
        int[] minMaxArr = {20, 25, 1, 15, 60, 75, 30, 21};
        printMinMax(minMaxArr);

        System.out.println("\n(#7) ---------------------------------------");
        int[] balanceArr = {2, 2, 2, 1, 2, 2, 10, 1};
        System.out.println(checkBalance(balanceArr));

        System.out.println("\n(#8) ---------------------------------------");
        int[] shiftArr = {6, 1, 3, 5};
        shiftArray(shiftArr, 2);
    }

//  1. Задать целочисленный массив, состоящий из элементов 0 и 1. Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ]. С помощью цикла и условия заменить 0 на 1, 1 на 0;

    public static void invertArray(int[] arr) {

        print1DArray(arr);

        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i] ^ 1;
            System.out.print(arr[i] + " ");
        }
    }

//  2. Задать пустой целочисленный массив длиной 100. С помощью цикла заполнить его значениями 1 2 3 4 5 6 7 8 … 100;

    public static int[] fillArray(int len) {
        int[] arr = new int[len];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }
        return arr;
    }

//  3. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом, и числа меньшие 6 умножить на 2;

    public static void changeArray(int[] arr) {

        formatPrint1DArray(arr);

        for (int i = 0; i < arr.length; i++)
            if (arr[i] < 6) arr[i] *= 2;

        formatPrint1DArray(arr);
    }

//    4. Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое), и с помощью цикла(-ов)
//    заполнить его диагональные элементы единицами (можно только одну из диагоналей, если обе сложно). Определить элементы
//    одной из диагоналей можно по следующему принципу: индексы таких элементов равны, то есть [0][0], [1][1], [2][2], …, [n][n];

    public static void fillDiagonal(int len) {
        int[][] arr = new int[len][len];
        for (int i = 0; i < arr.length; i++) {
            arr[i][i] = 1;
            arr[(arr.length - 1) - i][i] = 1;
        }
        print2DArray(arr);
    }

//    5. Написать метод, принимающий на вход два аргумента: len и initialValue, и возвращающий одномерный массив типа int
//    длиной len, каждая ячейка которого равна initialValue;

    public static int[] getInitArray(int len, int initialValue) {
        int[] arr = new int[len];
        for (int i = 0; i < arr.length; i++) arr[i] = initialValue;
        return arr;
    }

//    6. * Задать одномерный массив и найти в нем минимальный и максимальный элементы ;

    public static void printMinMax(int[] arr) {

        print1DArray(arr);

        int min = arr[0];
        int max = arr[0];
        for (int value: arr) {
            if (value < min) min = value;
            if (value > max) max = value;
        }
        System.out.println("Min = " + min + ", Max = " + max);
    }

//    7. ** Написать метод, в который передается не пустой одномерный целочисленный массив, метод должен вернуть true,
//    если в массиве есть место, в котором сумма левой и правой части массива равны.

    public static boolean checkBalance(int[] arr) {

        print1DArray(arr);

        int leftSum = 0;
        int rightSum = 0;

        for (int value: arr) rightSum += value;             //Считаем общую сумму -> rightSum
        for (int i = 0; i < arr.length; i++) {
            leftSum += arr[i];
            rightSum -= arr[i];
            if (leftSum == rightSum) {
                for (int k = 0; k < arr.length; k++)        //Вывод массива с разделителем, затем return
                    if (k == i) System.out.print(arr[k] + " || ");
                    else System.out.print(arr[k] + " ");
                System.out.println("\nSum = " + leftSum);
                return true;
            }
        }
        return false;
    }

//    8. *** Написать метод, которому на вход подается одномерный массив и число n (может быть положительным, или отрицательным),
//    при этом метод должен сместить все элементы массива на n позиций. Элементы смещаются циклично.
//    Для усложнения задачи нельзя пользоваться вспомогательными массивами. Примеры: [ 1, 2, 3 ] при n = 1 (на один
//    вправо) -> [ 3, 1, 2 ]; [ 3, 5, 6, 1] при n = -2 (на два влево) -> [ 6, 1, 3, 5 ]. При каком n в какую сторону
//    сдвиг можете выбирать сами.

    public static void shiftArray(int[] arr, int nShift) {

        print1DArray(arr);
        int tmpVar;

        if (nShift > 0) {
            System.out.println("(" + nShift + "->)");
            for (int i = 1; i <= nShift; i++) {
                tmpVar = arr[arr.length - 1];
                for (int j = arr.length - 1; j > 0; j--) arr[j] = arr[j - 1];
                arr[0] = tmpVar;
            }
        } else if (nShift < 0) {
            System.out.println("(<-" + nShift + ")");
            for (int i = -1; i >= nShift; i--) {
                tmpVar = arr[0];
                for (int j = 0; j < arr.length - 1; j++) arr[j] = arr[j + 1];
                arr[arr.length - 1] = tmpVar;
            }
        }

        print1DArray(arr);
    }

    public static void print1DArray(int[] arr) {
        for (int value: arr) System.out.print(value + " ");
        System.out.println();
    }

    public static void print2DArray(int[][] arr) {
        for (int[] iValue: arr) {
            for (int jValue: iValue) System.out.print(jValue + " ");
            System.out.println();
        }
    }

    public static void formatPrint1DArray(int[] arr) {
        for (int value: arr) System.out.format("%4d", value);
        System.out.println();
    }
}
