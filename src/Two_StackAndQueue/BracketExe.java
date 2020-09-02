package Two_StackAndQueue;

/**
 * 括号匹配问题：([AAAA])([[BBBB]]
 */
public class BracketExe {

    public static void main(String[] args) {
        String target = "(AAAA)(BBBB)";
        boolean isMatch = isNormalExpression(target);
        System.out.print(isMatch);
    }

    public static boolean isNormalExpression(String string){
        //初始化栈
        Stack_Array<String> stack = new Stack_Array<String>();
        //获取字符串的每一个字符
        for (int i = 0; i < string.length(); i++) {
            String tmp = string.charAt(i) + "";
            if("(".equals(tmp) || "[".equals(tmp))//如果是左括号，则直接入栈
                stack.push(tmp);
            else if(")".equals(tmp)){//如果是右括号，则判断栈顶是否为左括号，如果不是则表达式错误；如果是，则继续下面的判断
                String leftPart = stack.pop();
                if(!"(".equals(leftPart)){
                    return false;
                }
            }else if( "]".equals(tmp)){//如果是右括号，则判断栈顶是否为左括号，如果不是则表达式错误；如果是，则继续下面的判断
                String leftPart = stack.pop();
                if(!"[".equals(leftPart)){
                    return false;
                }
            }
        }
        if (stack.size() == 0){
            return true;
        }
        return false;
    }
}
