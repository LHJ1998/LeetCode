package com.lhj1998.leetcode.Array._0079;

public class Solution {

//    private int[][] dict = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
//
//    public boolean exist(char[][] board, String word) {
//        if(null == word || "".equals(word)) return false;
//        for(int i = 0; i < board.length; i++){
//            for(int j = 0; j < board[0].length; j++){
//                if(board[i][j] == word.charAt(0)){
//                    char temp = board[i][j];
//                    board[i][j] = ' ';
//                    boolean success = dfs(board, word, i, j, 1, 0);
//                    if(success) return success;
//                    board[i][j] = temp;
//                }
//            }
//        }
//        return false;
//    }
//
//    private boolean dfs(char[][] board, String word, int x, int y, int index, int len) {
//        if(len == word.length()) return true;
//        for(int i = 0; i < dict.length; i++){
//            int tx = x + dict[i][0];
//            int ty = y + dict[i][1];
//            if(tx >= 0 && tx < board.length && ty >= 0 && ty < board[0].length
//                    && index < word.length() && board[tx][ty] == word.charAt(index)){
//                char temp = board[tx][ty];
//                board[tx][ty] = ' ';
//                boolean success = dfs(board, word, tx, ty, index + 1, len + 1);
//                if(success) return success;
//                board[tx][ty] = temp;
//            }
//        }
//        return false;
//    }

    public boolean exist(char[][] board, String word) {
        if(null == word || "".equals(word)) return false;
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == word.charAt(0)){
                    boolean success = dfs(board, word, i, j, 0, 0);
                    if(success) return success;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int x, int y, int index, int len) {
        if(len == word.length()) return true;
        if(x >= 0 && x < board.length && y >= 0 && y < board[0].length
                && index < word.length() && board[x][y] == word.charAt(index)){
            char temp = board[x][y];
            board[x][y] = ' ';
            boolean success = dfs(board, word, x + 1, y, index + 1, len + 1)
                    || dfs(board, word, x - 1, y, index + 1, len + 1)
                    || dfs(board, word, x, y + 1, index + 1, len + 1)
                    || dfs(board, word, x, y - 1, index + 1, len + 1);
            board[x][y] = temp;
            return success;
        }
        return false;
    }

}
