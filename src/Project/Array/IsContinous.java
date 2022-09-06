package Project.Array;

/**
 * 算法： 如何判断一个数组中数值是否连续相邻 0可以匹配任何数 不会有重复数字出现
 * 思路：如果含有0 则最大值与非0最小值之差<4 不含0 则最大值与非0最小值之差=4
 *
 */
public class IsContinous {
    public static void  IsContinous(int a[]){
        int max=Integer.MIN_VALUE;
        int min=Integer.MAX_VALUE;
        if(a==null||a.length<=4) return;
        for (int i = 0; i < a.length; i++) {
            if(a[i]!=0){
                if(a[i]>max){
                    max=a[i];
                }
                if(a[i]<min){
                    min=a[i];
                }
            }
    }
        if(ContainsZero(a)){
            if((max-min)<4){
                System.out.println("该数组连续相邻");
            }else{
                System.out.println("该数组不连续相邻");
            }
        }else {
            if(max-min==4){
                System.out.println("该数组连续相邻");
            }else{
                System.out.println("该数组不连续相邻");
            }
        }
    }

    public static boolean ContainsZero(int a[]){
        for (int i = 0; i < a.length; i++) {
            if(a[i]==0){
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int a[]={8,7,5,0,6};
        IsContinous(a);
    }
}
