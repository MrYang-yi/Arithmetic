package Project.Any;

public class Rob_198 {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int length = nums.length;
        if (length == 1) {
            return nums[0];
        }
        int first = nums[0]; //S0
        int second = Math.max(nums[0], nums[1]); //S1
        for (int i = 2; i < length; i++) {
            int temp = second;    //把S1赋值给temp
            second = Math.max(first + nums[i], second);  //S2=max（S0+nums[2],second）（2由i控制）
            first = temp;                                //把temp赋值给first
        }
        return second;
    }

    public static void main(String[] args) {
        int p = new Rob_198().rob(new int[]{2, 1, 1, 2});
        System.out.println(p);
    }
}
