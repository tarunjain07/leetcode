class Solution {
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if ((i * j == 0 || i == n - 1 || j == m - 1) && board[i][j] == 'O') {
                    //System.out.println("i " + i + " j " + j);
                    dfs(i, j, n, m, board);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }else if(board[i][j] == 'Y'){
                    board[i][j] = 'O';
                }
            }
        }

        // return board;
        //System.out.println();

    }

    int[][] directions = new int[][]{{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

    private void dfs(int r, int c, int n, int m, char[][] board) {

        board[r][c] = 'Y';

        for (int[] dir : directions) {
            int new_r = r + dir[0];
            int new_c = c + dir[1];
            if (isValid(new_r, new_c, n, m, board)) {
                dfs(new_r, new_c, n, m, board);
            }
        }

    }

    private boolean isValid(int r, int c, int n, int m, char[][] board) {
        if (r >= 0 && c >= 0 && r < n && c < m && board[r][c] == 'O') {
            return true;
        }

        return false;
    }
}