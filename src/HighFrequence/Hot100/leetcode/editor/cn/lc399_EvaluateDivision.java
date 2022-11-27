package HighFrequence.Hot100.leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class lc399_EvaluateDivision {
    public static void main(String[] args) {
        Solution solution = new lc399_EvaluateDivision().new Solution();
        List<List<String>> equations = Arrays.asList(Arrays.asList("a", "b"), Arrays.asList("b", "c"));
        List<List<String>> queries = Arrays.asList(Arrays.asList("a", "c"), Arrays.asList("b", "a"), Arrays.asList("b", "a"), Arrays.asList("a", "e"), Arrays.asList("a", "a"), Arrays.asList("x", "x"));
        System.out.println(Arrays.stream(solution.calcEquation(equations, new double[]{2.0, 3.0}, queries)).boxed().collect(Collectors.toList()));
    }

    //除法求值
    //具有变量之间传递关系的，这种用并查集去实现
    class Solution {
        public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
            UnionFind unionFind = new UnionFind(2 * equations.size());
            // 第 1 步：预处理，将变量的值与 id 进行映射，使得并查集的底层使用数组实现，方便编码
            Map<String, Integer> hashMap = new HashMap<>(2 * equations.size());
            int id = 0;
            for (int i = 0; i < equations.size(); i++) {
                List<String> equation = equations.get(i);
                String var1 = equation.get(0);
                String var2 = equation.get(1);

                if (!hashMap.containsKey(var1)) {
                    hashMap.put(var1, id);
                    id++;
                }
                if (!hashMap.containsKey(var2)) {
                    hashMap.put(var2, id);
                    id++;
                }
                unionFind.union(hashMap.get(var1), hashMap.get(var2), values[i]);
            }
            // 第 2 步：做查询
            int queriesSize = queries.size();
            double[] res = new double[queriesSize];
            for (int i = 0; i < queriesSize; i++) {
                String var1 = queries.get(i).get(0);
                String var2 = queries.get(i).get(1);
                Integer id1 = hashMap.get(var1);
                Integer id2 = hashMap.get(var2);
                if (id1 == null || id2 == null) {
                    res[i] = -1.0d;
                } else {
                    res[i] = unionFind.isConnected(id1, id2);
                }
            }
            return res;
        }

        private class UnionFind {
            private int[] parent;
            //指向的父结点的权值
            private double[] weight;

            public UnionFind(int n) {
                this.parent = new int[n];
                this.weight = new double[n];
                for (int i = 0; i < n; i++) {
                    parent[i] = i;
                    weight[i] = 1.0d;
                }
            }

            public void union(int x, int y, double value) {
                int rootX = find(x);
                int rootY = find(y);
                if (rootX == rootY) {
                    return;
                }
                parent[rootX] = rootY;
                weight[rootX] = weight[y] * value / weight[x];  //weight[x] * weight[rootX] = weight[y] * value,见底部
            }

            //路径压缩,x为根结点的id
            public int find(int x) {
                if (x != parent[x]) {
                    int origin = parent[x];
                    parent[x] = find(parent[x]);
                    weight[x] *= weight[origin];
                }
                return parent[x];
            }

            public double isConnected(int x, int y) {
                int rootX = find(x);
                int rootY = find(y);
                if (rootX == rootY) {
                    return weight[x] / weight[y];
                } else {
                    return -1.0d;
                }
            }
        }
    }
}
//                     weight[rootx]
//             rootX -------------------> rootY
//              /                          /
//  weight[x]  /                          / weight[y]
//            /                          /
//           x ----------------------->  y
//