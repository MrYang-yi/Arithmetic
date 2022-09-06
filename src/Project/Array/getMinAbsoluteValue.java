package Project.Array;

/**
 * 算法：如何求出（升序数组）绝对值最小的数
 * 思路 总共3种情况 1 全部负数 2 负数 正数 3全部正数
 *   1 如果是全部正数或者全部负数 可以直接返回
 *   2 如果含有正负数 就要用到二分查找的思想 暴力求解也可以求（不推荐）
 *
 */
public class getMinAbsoluteValue {
    public static int getMinAbsoluteValue(int a[]){
        if(a==null||a.length<=1){
            return Integer.MIN_VALUE;
        }
        if(a[a.length-1]<=0){
            return a[a.length-1];
        }else if(a[0]>=0){
            return  a[0];
        }else {
             int start=0;
             int end=a.length-1;
             int mid=(start+end)/2;
             if(a[mid]<0){
                 if(a[mid+1]>0){
                     return Math.min(Math.abs(a[mid]),Math.abs(a[mid+1]));
                 }if(a[mid+1]==0){
                     return a[mid+1];
                 }else{
                     start=mid+1;
                 }
             }else if(a[mid]==0){
                 return a[mid];
             }else if(a[mid]>0){
                 if(a[mid-1]<0){
                     return Math.min(Math.abs(a[mid]),Math.abs(a[mid-1]));
                 }else if(a[mid-1]==0){
                     return a[mid-1];
                 }else{
                     end=mid-1;
                 }
             }
        }
     return -1;
    }
    public static void main(String[] args) {
        int a1[]={-10,-5,-2,7,15,50};
        int a2[]={2,4,6,8,27};
        int a3[]={-13,-9,-7,-3};
        int value1=getMinAbsoluteValue(a1);
        int value2=getMinAbsoluteValue(a2);
        int value3=getMinAbsoluteValue(a3);
        System.out.println(value1);
        System.out.println(value2);
        System.out.println(value3);
    }
}
