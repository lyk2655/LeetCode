public class P036_ValidSudoku {

    public boolean isValidSudoku(char[][] board) {

        for(int i = 0; i<9; i++) {
            int[] arr1 = new int[10];
            int[] arr2 = new int[10];
            int[] arr3 = new int[10];
            for(int j=0; j<9; j++) {
                if(board[i][j] != '.') {
                    int k1 = board[i][j] - '0';
                    if(arr1[k1] == 1) {
                        return false;
                    }
                    arr1[k1] = 1;
                }
                if(board[j][i] != '.') {
                    int k2 = board[j][i] - '0';
                    if(arr2[k2] == 1) {
                        return false;
                    }
                    arr2[k2] = 1;
                }
                if(board[i/3*3+j/3][i%3*3+j%3] != '.') {
                    int k3 = board[i/3*3+j/3][i%3*3+j%3] - '0';
                    if(arr3[k3] == 1) {
                        return false;
                    }
                    arr3[k3] = 1;
                }
            }
        }
        return true;
    }
}
