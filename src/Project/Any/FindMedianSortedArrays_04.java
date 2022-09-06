package Project.Any;

/**
 * topic: 寻找两个有序数组的中位数
 * <p>
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
 * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 * 你可以假设 nums1 和 nums2 不会同时为空
 * <p>
 * nums1 = [1, 3]
 * nums2 = [2]
 * <p>
 * 则中位数是 2.0
 * <p>
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * <p>
 * 则中位数是 (2 + 3)/2 = 2.5
 */
public class FindMedianSortedArrays_04 {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        return (find(nums1, 0, len1 - 1, nums2, 0, len2 - 1, (len1 + len2 + 1) / 2) +
                find(nums1, 0, len1 - 1, nums2, 0, len2 - 1, (len1 + len2) / 2 + 1)) * 0.5;
    }
    private static int find(int[] nums1, int start1, int end1, int[] nums2, int start2, int end2, int cnt) {
        int len1 = end1 - start1 + 1;
        int len2 = end2 - start2 + 1;
        //确保nums1是短的
        if (len1 > len2) {
            return find(nums2, start2, end2, nums1, start1, end1, cnt);
        }
        //如果len1已经为空，直接从nums2找
        if (len1 == 0) {
            return nums2[start2 + cnt - 1];
        }
        //找第1个数，比较nums1[0]和nums2[0]谁更小即可
        if (cnt == 1) {
            return Math.min(nums1[start1], nums2[start2]);
        }
        //因为nums1比较短，因此取位置时要考虑实际长度
        int pos1 = start1 + Math.min(cnt / 2, len1) - 1;
        int pos2 = start2 + cnt / 2 - 1;
        if (nums1[pos1] > nums2[pos2]) {
            return find(nums1, start1, end1, nums2, pos2 + 1, end2, cnt - cnt / 2);
        } else {
            return find(nums1, pos1 + 1, end1, nums2, start2, end2, cnt - Math.min(cnt / 2, len1));
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3};
        int[] nums2 = {5, 6, 7, 8, 9};
        double p = findMedianSortedArrays(nums1, nums2);
        System.out.println(p);
    }
}
//下面这种方法在Leetcode上已经ac过 可时间复杂度好像不是log（m+n） 不知道怎么通过的
/*public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList<Integer>();
        int n = nums1.length + nums2.length;
        for (int i = 0; i < nums1.length; i++) {
        list.add(nums1[i]);
        }
        for (int i = 0; i < nums2.length; i++) {
        list.add(nums2[i]);
        }
        Collections.sort(list);
        if (list.size() % 2 == 1) {
        return list.get(n / 2);
        } else {
        return (list.get(n / 2 - 1) + list.get(n / 2)) / 2.0;
        }

        }*/
