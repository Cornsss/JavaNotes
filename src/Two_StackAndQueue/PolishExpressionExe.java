package Two_StackAndQueue;

/**
 * 后缀表达式习题：3、17、15、-、*、18、6、/、+
 */
public class PolishExpressionExe {
    public static void main(String[] args) {
        String original = "3、17、15、-、*、18、6、/、+";
        int result = solveExpression(original);
        System.out.print(result);
    }

    public static int solveExpression(String original){
        String[] ele = original.split("、");
        Stack_Array<Integer> statck = new Stack_Array<Integer>();

        for (int i = 0; i < ele.length; i++) {
            if("+".equals(ele[i])){//如果是操作符
                Integer tmp1 = statck.pop();
                Integer tmp2 = statck.pop();
                Integer result = tmp1 + tmp2;
                statck.push(result);
            }else if("-".equals(ele[i])){
                Integer tmp1 = statck.pop();
                Integer tmp2 = statck.pop();
                Integer result = tmp2 - tmp1;
                statck.push(result);
            }else if("*".equals(ele[i])){
                Integer tmp1 = statck.pop();
                Integer tmp2 = statck.pop();
                Integer result = tmp1 * tmp2;
                statck.push(result);
            }else if("/".equals(ele[i])){
                Integer tmp1 = statck.pop();
                Integer tmp2 = statck.pop();
                Integer result = tmp2 / tmp1;
                statck.push(result);
            } else{//如果是操作数
                statck.push(Integer.parseInt(ele[i]));
            }
        }
        return statck.pop();
    }
}
