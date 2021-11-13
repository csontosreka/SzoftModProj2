package generators;

public class LevelGenerator {

    int[][] sudokuArray; // sudoku pálya
    int N; // sorok, oszlopok száma
    int SQRT_N; // gyök N
    int K; // üres mezők száma


    public LevelGenerator(int N, int K) {
        this.N = N;
        this.K = K;

        // kiszámoljuk N gyökét
        double SRNd = Math.sqrt(N);
        SQRT_N = (int) SRNd;

        sudokuArray = new int[N][N];
    }

    // sudoku generátor
    public void fillValues() {
        fillDiagonal();

        // az üres mezőket kinullázzuk
        fillRemaining(0, SQRT_N);

        removeKDigits();
    }

    // átlósan kitöltjük az SQRT_N x SQRT_N mátrixot
    void fillDiagonal() {

        for (int i = 0; i < N; i = i + SQRT_N)

            // ha átlósan haladunk akkor i==j
            // meghívjuk rá a 3x3 blokkot kitöltő eljárást
            fillBlock(i, i);
    }

    // megnézi, hogy az adott szám benne van-e a vizsgált 3x3-as blokkban
    boolean unUsedInBlock(int rowStart, int colStart, int num) {
        for (int i = 0; i < SQRT_N; i++)
            for (int j = 0; j < SQRT_N; j++)
                if (sudokuArray[rowStart + i][colStart + j] == num)
                    return false;

        return true;
    }

    // kitölti a 3x3-as blokkot.
    void fillBlock(int row, int col) {
        int num;
        for (int i = 0; i < SQRT_N; i++) {
            for (int j = 0; j < SQRT_N; j++) {
                do {
                    num = randomGenerator(N);
                }
                while (!unUsedInBlock(row, col, num));

                sudokuArray[row + i][col + j] = num;
            }
        }
    }

    // random generátor
    int randomGenerator(int num) {
        return (int) Math.floor((Math.random() * num + 1));
    }

    // megnézi, hogy az adott szám beilleszthető-e az adott koordinátába
    boolean CheckIfSafe(int i, int j, int num) {
        return (unUsedInRow(i, num) &&
                unUsedInCol(j, num) &&
                unUsedInBlock(i - i % SQRT_N, j - j % SQRT_N, num));
    }

    // megnézi, hogy a sorban benne van-e már az adott szám
    boolean unUsedInRow(int i, int num) {
        for (int j = 0; j < N; j++)
            if (sudokuArray[i][j] == num)
                return false;
        return true;
    }

    // megnézi, hogy az oszlopban benne van-e már az adott szám
    boolean unUsedInCol(int j, int num) {
        for (int i = 0; i < N; i++)
            if (sudokuArray[i][j] == num)
                return false;
        return true;
    }

    // rekurzívan kitölti a maradék cellákat
    boolean fillRemaining(int i, int j) {
        if (j >= N && i < N - 1) {
            i = i + 1;
            j = 0;
        }
        if (i >= N && j >= N)
            return true;

        if (i < SQRT_N) {
            if (j < SQRT_N)
                j = SQRT_N;
        } else if (i < N - SQRT_N) {
            if (j == (i / SQRT_N) * SQRT_N)
                j = j + SQRT_N;
        } else {
            if (j == N - SQRT_N) {
                i = i + 1;
                j = 0;
                if (i >= N)
                    return true;
            }
        }

        for (int num = 1; num <= N; num++) {
            if (CheckIfSafe(i, j, num)) {
                sudokuArray[i][j] = num;

                if (fillRemaining(i, j + 1))
                    return true;

                sudokuArray[i][j] = 0;
            }
        }
        return false;
    }

    // random cellákat kinulláz a megoldott sudokuból
    public void removeKDigits() {
        int count = K;
        while (count != 0) {
            int cellId = randomGenerator(N * N) - 1;

            int i = (cellId / N);
            int j = cellId % 9;
            if (j != 0)
                j = j - 1;

            if (sudokuArray[i][j] != 0) {
                count--;
                sudokuArray[i][j] = 0;
            }
        }
    }

    // kiírja a sudokut
    public void printSudoku() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++)
                System.out.print(sudokuArray[i][j] + " ");
            System.out.println();
        }
        System.out.println();
    }

    // ellenőrzés
    public static void main(String[] args) {
        int N = 9, K = 20;
        LevelGenerator sudoku = new LevelGenerator(N, K);
        sudoku.fillValues();
        sudoku.printSudoku();
    }
}

