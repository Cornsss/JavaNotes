package Stack;

/**
 * 给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
 */
public class NO32_MaxValidQuato {
    public static void main(String[] args) {
        String target = "(][(}(])(({]{{){){(]}}}){}))(){(}[{)})[[";
        System.out.println(longestValidParentheses(target));
    }
    public static int longestValidParentheses(String s) {
        NO20_ValidQuato.isValid(s);
        return -1;
    }
}
