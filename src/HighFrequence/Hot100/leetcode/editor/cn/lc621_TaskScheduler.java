package HighFrequence.Hot100.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class lc621_TaskScheduler {
    public static void main(String[] args) {
        Solution solution = new lc621_TaskScheduler().new Solution();
        System.out.println(solution.leastInterval(new char[]{'A', 'A', 'A', 'B', 'B', 'B'}, 2));
    }

    //任务调度器
    class Solution {
        public int leastInterval(char[] tasks, int n) {
            Map<Character, Integer> map = new HashMap<Character, Integer>();
            // 最多的执行次数
            int maxExec = 0;
            for (char ch : tasks) {
                int exec = map.getOrDefault(ch, 0) + 1;
                map.put(ch, exec);
                maxExec = Math.max(maxExec, exec);
            }

            // 具有最多执行次数的任务数量
            int maxCount = 0;
            for (Map.Entry<Character, Integer> entry : map.entrySet()) {
                int value = entry.getValue();
                if (value == maxExec) {
                    ++maxCount;
                }
            }
            return Math.max((maxExec - 1) * (n + 1) + maxCount, tasks.length);
        }
    }
}