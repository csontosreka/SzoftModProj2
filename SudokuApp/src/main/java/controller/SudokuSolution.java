package controller;


public class SudokuSolution {

    public static boolean solveSudoku(int[][] board, int boardSize){
        int rowIndex = -1;
        int columnIndex = -1;
        int i = -1;
        int j = -1;

        for (i = 0; i < boardSize; i++) {
            for (j = 0; j < boardSize; j++) {
                int current_val = board[i][j];

                if(current_val == 0 ){
                    break;
                }
            }
            if(rowIndex != -1){
                break;
            }
        }
        if(i == boardSize && j == boardSize){
            return  true;
        }
        else{
            for(int value = 0; value < 10; value++){
                if (numberWorks(board, value, rowIndex, columnIndex, boardSize)) {
                    board[rowIndex][columnIndex] = value;
                    if(!solveSudoku(board,boardSize)){
                        board[rowIndex][columnIndex] = 0;
                    }
                    else{
                        return  true;
                    }
                }
            }
            return false;
        }
    }
    public static boolean numberWorks(int board[][], int value, int rowIndex, int columnIndex, int boardSize){
        for(int j = 0; j < 9; j++){
            if(board[rowIndex][j]==value){
                return false;
            }
        }
        for(int i = 0; i < 9; i++){
            if(board[i][columnIndex] == value){
                return false;
            }
        }
        int rowIndexSubBoard = rowIndex - ( rowIndex % 3);
        int columnIndexSubBoard = columnIndex - (columnIndex % 3);
        for (int i = rowIndexSubBoard; i < rowIndexSubBoard + 3; rowIndexSubBoard++){
            for(int j = columnIndexSubBoard; j < columnIndexSubBoard + 3; columnIndexSubBoard++ ){
                if(board[i][j]==value){
                    return false;
                }
            }
        }
        return true;
    }
}
