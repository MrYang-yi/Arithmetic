package Project.Any;

/**
 * 算法：将数组分成和相等的三个部分
 * <p>
 * 给你一个整数数组 A，只有可以将其划分为三个和相等的非空部分时才返回 true，否则返回 false。
 * 形式上，如果可以找出索引 i+1 < j 且满足 (A[0] + A[1] + ... + A[i] == A[i+1] + A[i+2] + ... + A[j-1]
 * == A[j] + A[j-1] + ... + A[A.length - 1]) 就可以将数组三等分。
 * <p>
 * 示例 1：
 * 输入：[0,2,1,-6,6,-7,9,1,2,0,1]
 * 输出：true
 * 解释：0 + 2 + 1 = -6 + 6 - 7 + 9 + 1 = 2 + 0 + 1
 */
public class CanThreePartsEqualSum_1013 {
    public boolean canThreePartsEqualSum(int[] A) {
        if (A == null || A.length < 3) return false;
        int sum = 0;
        for (int x : A) {
            sum += x;
        }
        if (sum % 3 != 0) {
            return false;
        }
        // 使用双指针,从数组两头开始一起找，节约时间
        int i = 0;
        int leftSum = A[i];
        int j = A.length - 1;
        int rightSum = A[j];

        // 使用left + 1 < right 的原因，防止只能将数组分成两个部分
        while (i + 1 < j) {
            if (leftSum == sum / 3 && rightSum == sum / 3) {
                return true;
            }
            if (leftSum != sum / 3) {
                leftSum += A[++i];
            }
            if (rightSum != sum / 3) {
                rightSum += A[--j];
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] a = {0, 2, 1, -6, 6, -7, 9, 1, 2, 0, 1};
        //int[] b = {0, 2, 1, -6, 6, 7, 9, -1, 2, 0, 1};
       // int[] c = {3, 3, 6, 5, -2, 2, 5, 1, -9, 4};
        boolean flag1 = new CanThreePartsEqualSum_1013().canThreePartsEqualSum(a);
       // boolean flag2 = new CanThreePartsEqualSum().canThreePartsEqualSum(b);
       // boolean flag3 = new CanThreePartsEqualSum().canThreePartsEqualSum(c);
        System.out.println(flag1);
      //  System.out.println(flag2);
       // System.out.println(flag3);
    }
}
