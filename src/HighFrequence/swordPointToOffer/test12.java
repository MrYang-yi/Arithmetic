package LeetCode.editor.cn.HighFrequence.swordPointToOffer;

/**
 * 面试题12. 矩阵中的路径
 * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。路径可以从矩阵中的任意一格开始，每一步可以在矩阵中向左、右、上、下移动一格。如果一条路径经过了矩阵的某一格，那么该路径不能再次进入该格子。例如，在下面的3×4的矩阵中包含一条字符串“bfce”的路径（路径中的字母用加粗标出）。
 * [["a","b","c","e"],
 * ["s","f","c","s"],
 * ["a","d","e","e"]]
 * 但矩阵中不包含字符串“abfb”的路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入这个格子。
 * <p>
 * 示例 1：
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
 * 输出：true
 * <p>
 * 示例 2：
 * 输入：board = [["a","b"],["c","d"]], word = "abcd"
 * 输出：false
 *
 * 思路：回溯思想
 * 首先 1 先用两个for循环  保证每个点都可以进行回溯
 *     2 设计回溯方法 参数 添加一个int 型变量  表示长度 如果长度达到目标长度 则停止
 *     3 回溯先确定 终止条件 i j 不超过边界 就有4个条件  return false 遍历到的值不相等 return false 总共5个
 *     4 如果长度相等 说明已经取到目标值的长度 即return true；
 *     5 将遍历的值用temp保存
 *     6 当确定条件都满足时，用 "/" 标记 已经访问过的值 回溯回去的时候就能确保两个不相等 当然"/" 一定是不会出现的字符 不然没有作用
 *     7 进行回溯
 *     8 最后将保存的值返还给board[i][j]
 */

public class test12 {
    public boolean exist(char[][] board, String word) {
        char[] words = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(i, j, board, words, 0)) return true;
            }
        }
        return false;
    }

    private boolean dfs(int i, int j, char[][] board, char[] word, int k) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word[k]) {
            return false;
        }
        if (k == word.length - 1) {
            return true;
        }
        char temp = board[i][j];
        board[i][j] = '/';
        boolean flag = dfs(i + 1, j, board, word, k + 1) ||
                dfs(i - 1, j, board, word, k + 1) ||
                dfs(i, j + 1, board, word, k + 1) ||
                dfs(i, j - 1, board, word, k + 1);
        board[i][j] = temp;
        return flag;
    }


    public static void main(String[] args) {
        boolean flag = new test12().exist(new char[][]{
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'F'}
        }, "ABCCED");
        System.out.println(flag);
    }


}
