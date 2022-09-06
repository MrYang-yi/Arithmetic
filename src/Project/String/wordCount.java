package Project.String;

/**
 * 算法：计算一行字符串有多少个单词
 *
 */
public class wordCount {
    public static int wordCount(String s){
        int word=0;
        int count=0;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == ' '){
                word=0;
            }else {
                if(word==0){  // 如果标记为空  而且不为空字符
                    word=1;
                    count++;
                }
            }
        }
     return count;
    }
    public static void main(String[] args) {
        String s=" I am a handsome boy";
        int p=wordCount(s);
        System.out.println(p);
    }
}
