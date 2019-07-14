# [Word Search](https://leetcode.com/problems/word-search/)

Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

**Example:**

```
board =
[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]

Given word = "ABCCED", return true.
Given word = "SEE", return true.
Given word = "ABCB", return false.
```

## 思路0

看了一会儿，我大概知道该怎么做了，这里我觉得需要构造一个二维访问矩阵，然后用dfs一次一次的查找

```java
package com.lhj1998.leetcode.Array._0079;

public class Solution {

    private int[][] dict = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

    public boolean exist(char[][] board, String word) {
        if(null == word || "".equals(word)) return false;
        boolean[][] visited = new boolean[board.length][board[0].length];
        StringBuffer temp = new StringBuffer();
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == word.charAt(0)){
                    visited[i][j] = true;
                    temp.append(board[i][j]);
                    boolean success = dfs(board, visited, word, temp, i, j, 1);
                    if(success) return success;
                    temp.deleteCharAt(temp.length() - 1);
                    visited[i][j] = false;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, boolean[][] visited, String word, StringBuffer temp, int x, int y, int index) {
        if(temp.toString().equals(word)) return true;
        for(int i = 0; i < dict.length; i++){
            int tx = x + dict[i][0];
            int ty = y + dict[i][1];
            if(tx >= 0 && tx < board.length && ty >= 0 && ty < board[0].length
                    && !visited[tx][ty] && index < word.length() && board[tx][ty] == word.charAt(index)){
                visited[tx][ty] = true;
                temp.append(board[tx][ty]);
                boolean success = dfs(board, visited, word, temp, tx, ty, index + 1);
                if(success) return success;
                visited[tx][ty] = false;
                temp.deleteCharAt(temp.length() - 1);
            }
        }
        return false;
    }

}

```

花了好长时间总算把dfs写出来了，但是结果不太令人满意，代码是通过了，但是效率不高，值超过了14.07%的人，em....果然dfs还是比较烂是吗

## 思路1

看了一下别人的解法，有个人和我的一样用的dfs，但是和我的区别在于，他没有用visited和temp，也就是说我这边的dfs多了很多的额外操作，我试着把这些操作去除看看效果

```java
package com.lhj1998.leetcode.Array._0079;

public class Solution {

    private int[][] dict = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

    public boolean exist(char[][] board, String word) {
        if(null == word || "".equals(word)) return false;
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == word.charAt(0)){
                    char temp = board[i][j];
                    board[i][j] = ' ';
                    boolean success = dfs(board, word, i, j, 1, 1);
                    if(success) return success;
                    board[i][j] = temp;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int x, int y, int index, int len) {
        if(len == word.length()) return true;
        for(int i = 0; i < dict.length; i++){
            int tx = x + dict[i][0];
            int ty = y + dict[i][1];
            if(tx >= 0 && tx < board.length && ty >= 0 && ty < board[0].length
                    && index < word.length() && board[tx][ty] == word.charAt(index)){
                char temp = board[tx][ty];
                board[tx][ty] = ' ';
                boolean success = dfs(board, word, tx, ty, index + 1, len + 1);
                if(success) return success;
                board[tx][ty] = temp;
            }
        }
        return false;
    }

}

```

改进之后的代码耗时5ms，超过了46.61%的人，但这并不能让我满意...

然后我试了一下跟我一样思路的人的代码，耗时4ms，超过了89.21%的人，说明我的改进还不够，继续改进

```java
package com.lhj1998.leetcode.Array._0079;

public class Solution {

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

```

