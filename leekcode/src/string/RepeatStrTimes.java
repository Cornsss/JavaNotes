package string;

public class RepeatStrTimes {

    public static void main(String[] args) {
        String A = "abcd";
        String B = "cdabcdab";
//        String C = "abcdabcdabcd";
//        System.out.println(C.indexOf(B));
        int i = repeatMatch(A, B);
        System.out.println(i);
    }
    public static int repeatMatch(String A,String B) {
        if(A.isEmpty() || A == null)
            return -1;
        if(B.isEmpty() || B == null)
            return -1;
        if(A.length() < 0 || A.length() > 10000)
            return -1;
        if(B.length() < 0 || B.length() > 10000)
            return -1;
        String tmp = A;
        int result = 1;
        while(tmp.indexOf(B) == -1){
            tmp = tmp + A;
            result++;
        }
        return result;
    }
}
