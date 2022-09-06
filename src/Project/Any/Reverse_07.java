package Project.Any;

public class Reverse_07 {
    public static int reverse(int x) {
        long n=0;
        while (x!=0){
            n=10*n+x%10;
            x=x/10;
        }
     return (int)n==n?(int)n:0;

        //下面是利用字符串的reverse方法
        /*Project.String s = "" + x;
        int flag = 1;
        if (x < 0) {
            flag = -1;
            s = s.substring(1);
        }
        try {
            return Integer.parseInt(new StringBuilder(s).reverse().toString()) * flag;
        } catch (Exception e) {
            return 0;
        }*/

    }

    public static void main(String[] args) {
        int p = reverse(-1234);
        System.out.println(p);
    }
}
