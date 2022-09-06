package Project.Array;

/**
 *
 * 算法：如何求出数组两两相加等于20的组合种数 1暴力求解 2 引用HashMap
 *
 */
public class Sum {
    public static void findSum(int a[],int k){
        int i;
        int j;
        for ( i = 0; i < a.length; i++) {
            for ( j = i+1; j < a.length; j++) {
                if(a[i]==k-a[j]){
                    System.out.println(a[i]+" "+a[j]);
                }
            }
        }
    }
    public static void main(String[] args) {
        int a[]={1,7,17,2,6,3,14};
        findSum(a,20);
        }

}
