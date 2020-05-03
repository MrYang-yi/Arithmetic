package String;
/**
 * 算法：按要求打印数组排列情况（针对1 2 3 4 5 6写一个函数，打印出所有不同排列，要求4 不能放在第三位 ，3 与 5不能相连）
 * 思路：转换为图的遍历
 */

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class getAllCombination {
    private int[] numbers = new int[]{1, 2, 2, 3, 4, 5};
    private int n = numbers.length;
    private boolean[] visited = new boolean[n];
    private int graph[][] = new int[n][n];
    private String Combination = "";
    public Set<String> getAllCombinations() {
        buildgraph();
        Set<String> set = new HashSet<String>();
        for (int i = 0; i < n; i++) {
            this.depthFirstSearch(i, set);
        }
        return set;
    }

    private void buildgraph() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    graph[i][j] = 0;
                } else {
                    graph[i][j] = 1;
                }
            }
        }
        graph[3][5] = 0;
        graph[5][3] = 0;
    }

    private void depthFirstSearch(int start, Set<String> set) {
        visited[start] = true;
        Combination = Combination + numbers[start];
        if (Combination.length() == n) {
            if (Combination.indexOf("4") != 2)
                set.add(Combination);
            }
            for (int j = 0; j < n; j++) {
                if (graph[start][j] == 1 && visited[j] == false)
                    depthFirstSearch(j, set);
            }
            Combination = Combination.substring(0, Combination.length() - 1);
            visited[start] = false;


    }

    public static void main(String[] args) {
        getAllCombination p = new getAllCombination();
        Set<String> set = p.getAllCombinations();
        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()) {
            String s = (String) iterator.next();
            System.out.println(s);
        }
    }
}
