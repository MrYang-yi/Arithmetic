package HighFrequence.Hot100.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

//根据身高重建队列
public class lc406_QueueReconstructionByHeight {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>() {
            public int compare(int[] person1, int[] person2) {
                if (person1[0] != person2[0]) {
                    return person2[0] - person1[0];
                } else {
                    return person1[1] - person2[1];
                }
            }
        });
        List<int[]> ans = new ArrayList<>();
        for (int[] person : people) {
            ans.add(person[1], person);
        }
        return ans.toArray(new int[ans.size()][]);
    }
}