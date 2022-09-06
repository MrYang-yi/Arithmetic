package Project.Any;

/**
 * topic:盛最多水的容器
 *
 * 盛水容量   =   两个指针指向的数字中较小值   ∗  指针之间的距离（不断减少）
 * 所以就得改变较小的那个值  移动他 使它可能变大  如果变大 存入ans中
 */
public class MaxArea_11 {
    public int maxArea(int[] height) {
/*        int l = 0;
        int r = height.length - 1;
        int ans = 0;
        while (l < r) {
            int area = Math.min(height[l], height[r]) * (r - l);
            ans = Math.max(ans, area);
            if (height[l] <= height[r]) {
                ++l;
            } else {
                --r;
            }
        }
        return ans;*/
        int i=0;
        int j=height.length-1;
        int max=0;
        while(i<j){
             max=Math.max(max,(j-i)*Math.min(height[i],height[j]));
            if(height[i]<height[j]){
                i++;
            }else{
                j--;
            }
        }
        return max;
    }


    public static void main(String[] args) {
        int[] a = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        int p = new MaxArea_11().maxArea(a);
        System.out.println(p);
    }
}
