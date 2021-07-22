import java.util.Random;
import java.util.Scanner;

public class HomeWorkApp {
    static final char emptyChar = '-';
    static final int  countBitForWin = 4;
    static final char signAI = 'O';
    static final char signHuman = 'X';

    public static void main(String[] args) {

        int sizeOfMatrix = setSizeOfMatrix();

        if (sizeOfMatrix != 0)
            ticTacToe(sizeOfMatrix);
    }

    static void ticTacToe(int sizeOfMatrix) {
        char[][] matrix = setMatrixEmpty(sizeOfMatrix);
        drawMatrix(matrix);
        do {
            if (!movePlayer(matrix)) break;
            drawMatrix(matrix);
            if (isWin(matrix, signHuman)) {
                System.out.println("Your are win!");
                break;
            }
            if (isDraw(matrix)) {
                System.out.println("This is draw. ");
                break;
            }

            moveAI(matrix);
            if (isWin(matrix, signAI)) {
                System.out.println("AI win !");
                break;
            }
            if (isDraw(matrix)) {
                System.out.println("This is draw. ");
                break;
            }

        } while(true);
    }

    static boolean isDraw(char[][] matrix) {
        for (int y = 0; y < matrix.length; y++) {
            for (int x = 0; x < matrix.length; x++) {
                if (isEmptyCell(matrix, x, y))
                    return false;
            }
        }
        return true;
    }

    static boolean isWin(char[][] matrix, char sign) {
        int lineWin, contrLineWin;

//        Если матрица 3*3, то классически проверяем вертикали-горизонтали, затем диагонали
        if (matrix.length == 3) {
            for (int y = 0; y < matrix.length; y++) {
                lineWin = 0;
                for (int x = 0; x < matrix.length; x++)
                    if (matrix[y][x] == sign) lineWin++;
                if (lineWin == matrix.length) return true;
            }

            for (int x = 0; x < matrix.length; x++) {
                lineWin = 0;
                for (int y = 0; y < matrix.length; y++)
                    if (matrix[y][x] == sign) lineWin++;
                if (lineWin == matrix.length) return true;
            }

            lineWin = 0;
            for (int xy = 0; xy < matrix.length; xy++)
                if (matrix[xy][xy] == sign) lineWin++;
            if (lineWin == matrix.length) return true;

            lineWin = 0;
            for (int xy = 0; xy < matrix.length; xy++)
                if (matrix[(matrix.length - 1) - xy][xy] == sign) lineWin++;
            return lineWin == matrix.length;

        } else {
//      Если матрица нестандартная, то проверяем вертикали-горизонтали-диагонали в зависимости от количества нужных фишек
            for (int y = 0; y < matrix.length; y++) {
                lineWin = 0;
                for (int x = 0; x < matrix.length && lineWin < countBitForWin; x++)
                    if (matrix[y][x] == sign) lineWin++; else lineWin = 0;
                if (lineWin >= countBitForWin) return true;
            }

            for (int x = 0; x < matrix.length; x++) {
                lineWin = 0;
                for (int y = 0; y < matrix.length && lineWin < countBitForWin; y++)
                    if (matrix[y][x] == sign) lineWin++; else lineWin = 0;
                if (lineWin >= countBitForWin) return true;
            }

            lineWin = 0;
            contrLineWin = 0;
            for (int x = 0; x <= matrix.length - countBitForWin; x++) {
                for (int y = 0; y < matrix.length - x && lineWin < countBitForWin && contrLineWin < countBitForWin; y++) {
                    if (matrix[y][x + y] == sign) lineWin++;
                    else lineWin = 0;
                    if (matrix[y + x][y] == sign) contrLineWin++;
                    else contrLineWin = 0;
                }
                if (lineWin >= countBitForWin || contrLineWin >= countBitForWin) return true;
            }

            lineWin = 0;
            contrLineWin = 0;
            for (int x = 0; x <= matrix.length - countBitForWin; x++) {
                for (int y = (matrix.length - x) -1; y >= 0 && lineWin < countBitForWin && contrLineWin < countBitForWin; y--) {
                    if (matrix[y][((matrix.length -1) - x) - y] == sign) lineWin++;
                    else lineWin = 0;
                    if (matrix[((matrix.length -1) - x) - y][y] == sign) contrLineWin++;
                    else contrLineWin = 0;
                }
                if (lineWin >= countBitForWin || contrLineWin >= countBitForWin) return true;
            }
        }
        return false;
    }

    static void moveAI(char[][] matrix) {
        Random random = new Random();
        int xCoord = 0;
        int yCoord = 0;
        boolean foundWin = false;

//        Проверяем, может ли AI выиграть на этом шаге, если - да, то ходим туда
        for (int y = 0; y < matrix.length && !foundWin; y++)
            for (int x = 0; x < matrix.length && !foundWin; x++)
                if (isEmptyCell(matrix, x, y)) {
                    matrix[y][x] = signAI;
                    if (isWin(matrix, signAI)) {
                        xCoord = x;
                        yCoord = y;
                        foundWin = true;
                    }
                    matrix[y][x] = emptyChar;
                }

//      Проверяем, может ли человек выиграть на этом шаге, если - да, то блокируем его
        for (int y = 0; y < matrix.length && !foundWin; y++)
            for (int x = 0; x < matrix.length && !foundWin; x++)
                if (isEmptyCell(matrix, x, y)) {
                    matrix[y][x] = signHuman;
                    if (isWin(matrix, signHuman)) {
                        xCoord = x;
                        yCoord = y;
                        foundWin = true;
                    }
                    matrix[y][x] = emptyChar;
                }

//        Если ничего интересного, то ходим по random
        if (!foundWin)
        do {
            xCoord = random.nextInt(matrix.length);
            yCoord = random.nextInt(matrix.length);
        } while (!isEmptyCell(matrix, xCoord, yCoord));

        matrix[yCoord][xCoord] = signAI;
        System.out.printf("AI moved: X= %s; Y= %s.%n", xCoord + 1, yCoord + 1);
        drawMatrix(matrix);
    }

    static boolean movePlayer(char[][] matrix) {
        int xCoord = 0;
        int yCoord = 0;

        do {
            xCoord = getCoordinate('X', matrix.length);
            if (xCoord >= 0) {
                yCoord = getCoordinate('Y', matrix.length);
            }
            if (xCoord < 0 || yCoord < 0) return false;
        } while (!isEmptyCell(matrix, xCoord, yCoord));
        matrix[yCoord][xCoord] = signHuman;
        return true;
    }

    static boolean isEmptyCell(char[][] matrix, int xCoord, int yCoord) {
        return (matrix[yCoord][xCoord] == emptyChar);
    }

    static int getCoordinate(char axis, int sizeOfMatrix) {
        Scanner scanner = new Scanner(System.in);
        int coordinate;

        do {
            System.out.printf("Enter %s-coordinate [in range 1-%s], or 0 to exit: ", axis, sizeOfMatrix);
            coordinate = scanner.nextInt() - 1;
        } while (coordinate < (-1) || coordinate >= sizeOfMatrix);
        return coordinate;
    }

    static void drawMatrix(char[][] matrix) {
        System.out.print("   |");
        for (int i = 0; i < matrix.length; i++)
            System.out.printf("  %s ", i + 1);
        System.out.println();

        for (int i = 0; i <= matrix.length; i++)
            System.out.print("----");
        System.out.println();

        for (int j = 0; j < matrix.length; j++) {
            System.out.printf("  %s|", j + 1);
            for (int i = 0; i < matrix.length; i++)
                System.out.printf("  %s ", matrix[j][i]);
            System.out.println();
        }
        System.out.println();
    }

    static char[][] setMatrixEmpty(int sizeOfMatrix) {
        char[][] matrix = new char[sizeOfMatrix][sizeOfMatrix];
        for (int y = 0; y < matrix.length; y++)
            for (int x = 0; x < matrix.length; x++)
                matrix[y][x] = emptyChar;
        return matrix;
    }

    static int setSizeOfMatrix() {
        Scanner scanner = new Scanner(System.in);
        int sizeOfMatrix;
        do {
            System.out.print("Enter size of matrix (3 or 5) or 0 to exit: ");
            sizeOfMatrix = scanner.nextInt();
        } while (sizeOfMatrix != 3 && sizeOfMatrix != 5 && sizeOfMatrix != 0);
        return sizeOfMatrix;
    }
}
