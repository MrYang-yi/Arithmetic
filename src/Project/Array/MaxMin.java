package Project.Array;


public class MaxMin {
    static int max;
    static int min;
    public  static void  MaxandMin(int a[]){
        max=a[0];
        min=a[0];
        for (int i = 0; i < a.length; i++) {
            if(a[i]>max){
                max=a[i];
            }
            if(a[i]<min){
                min=a[i];
            }
        }
    }
    public static void main(String[] args) {
        int a[]={1,34,6,57,9,-3,35,89,4};
        MaxandMin(a);
        System.out.println(max);
        System.out.println(min);
    }
}
