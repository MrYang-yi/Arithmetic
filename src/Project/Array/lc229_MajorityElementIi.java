package Project.Array;

import java.util.ArrayList;
import java.util.List;

public class lc229_MajorityElementIi {
    /**
     * 摩尔投票法升级
     * A和B两个数，碰到+1，如果没碰到都减1，最后再去核对
     */
    public List<Integer> majorityElement(int[] nums) {
        int num1 = 0;
        int num2 = 0;
        int vote1 = 0;
        int vote2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (vote1 > 0 && nums[i] == num1) {
                vote1++;
            } else if (vote2 > 0 && nums[i] == num2) {
                vote2++;
            } else if (vote1 == 0) {
                num1 = nums[i];
                vote1++;
            } else if (vote2 == 0) {
                num2 = nums[i];
                vote2++;
            } else {
                vote1--;
                vote2--;
            }
        }
        int revote1 = 0;
        int revote2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (vote1 > 0 && nums[i] == num1) {
                revote1++;
            }
            if (vote2 > 0 && nums[i] == num2) {
                revote2++;
            }
        }
        List<Integer> list = new ArrayList<>();
        if (revote1 > nums.length / 3) {
            list.add(num1);
        }
        if (revote2 > nums.length / 3) {
            list.add(num2);
        }
        return list;
    }
}