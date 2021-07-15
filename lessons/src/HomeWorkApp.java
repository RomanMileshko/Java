public class HomeWorkApp {
    public static void main(String[] args) {
        System.out.println(within10and20(15, 3));
        isPositiveOrNegative(10);
        System.out.println(isNegative(6));
        printWordNTimes("Hello !", 5);
        System.out.println(isLeapYear(2100));
    }

    public static boolean isLeapYear(int x) {
        if (x % 4 == 0) {
            if ((x % 100 != 0) || (x % 400 == 0))
                return true;
        }
        return false;
    }

    public static boolean within10and20(int x1, int x2) {
        int sum;
        sum = x1 + x2;
        if(sum >= 10 && sum <= 20)
            return true;
        else return false;
    }
    public static void isPositiveOrNegative(int x) {
        if (x >= 0) {
            System.out.println("Positive");
        } else {
            System.out.println("Negative");
        }
    }
    public static boolean isNegative(int x) {
        if (x < 0) {
            return true;
        }
        return false;
    }
    public static void printWordNTimes(String word, int times) {
        for (int i = 1; i <= times; i++) {
            System.out.println(word);
        }
    }
}
