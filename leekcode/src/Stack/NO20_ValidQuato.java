package Stack;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Stack;

/**
 * 判断括号是否有效
 * 思路：
 * 遇到左括号时，入栈；
 * 遇到右括号时出栈，判断是否为左右一对
 */
public class NO20_ValidQuato {
    public static void main(String[] args) {
        String target = "(][(}(])(({]{{){){(]}}}){}))(){(}[{)})[[";
        System.out.println(isValid(target));
    }

    public static boolean isValid(String s) {
        boolean result = true;
        //校验字符串
        if(s.isEmpty() || s.length() == 0 || s == null){
            result = true;
        }
        //如果长度为奇数，则直接return
        if(s.length()%2 != 0){
            result = false;
        }

        //定义存入符号的栈
        Stack<String> stack = new Stack<String>();
        //将字符串分割为单独的字符
        char[] chars = s.toCharArray();
        for (int i = 0;i<chars.length;i++){
            if(chars[i] == '(' || chars[i] == '{' || chars[i] == '['){//遇到左括号则入栈
                String singleChar = chars[i] +"";
                stack.push(singleChar);
            }else{//遇到右括号需要判断出栈元素是否为匹配的左括号
                String leftPart = "";
                if(stack.size() > 0)
                    leftPart = stack.pop();
                else
                    return false;
                switch (chars[i]){
                    case ')':
                        if("(".equals(leftPart))
                            continue;
                        else
                            result = false;
                    case ']':
                        if("[".equals(leftPart))
                            continue;
                        else
                            result = false;
                    case '}':
                        if("{".equals(leftPart))
                            continue;
                        else
                            result = false;
                }
            }
        }

        //如果遍历结束，栈中仍然有元素，则return
        if(stack.size() > 0)
            result = false;
        return result;
    }

    public static boolean isValid2(String s) {
        Map<Character,Character> map = new HashMap<Character,Character>();
        map.put('{','}');
        map.put('[',']');
        map.put('(',')');
        map.put('?','?');
        if(s.length() > 0 && !map.containsKey(s.charAt(0)))
            return false;
        LinkedList<Character> stack = new LinkedList<Character>();
        stack.add('?');
        for(Character c : s.toCharArray()){
            if(map.containsKey(c))
                stack.addLast(c);
            else if(map.get(stack.removeLast()) != c)
                return false;
        }
        return stack.size() == 1;
    }

}
