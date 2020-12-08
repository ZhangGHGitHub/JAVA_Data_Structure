package Java.October;

/**
 * @author: 张国豪
 * @date: 2020/10/16 16:17
 * FileName: ArithExpression
 * @version: 1.0
 * Description: 算数表达式求值，整数：算数运算和位运算，双目、单字符运算符，没有正负号，忽略空格
 */
public class ArithExpression {
    private static Operators operators;
    static
    {
        operators =new Operators();
    }
    public ArithExpression(String infix)
    {
        StringBuffer postfix = toPostfix(infix);
        System.out.println("postfix=\" " + postfix + "\"\nvalue=" + toValue(postfix));
    }
    private StringBuffer toPostfix(String infix) {

        Stack<String> stack = new SeqStack<String>(infix.length());
        StringBuffer postfix = new StringBuffer(infix.length()*2);
        int i = 0;
        while(i < infix.length())
        {
            char ch = infix.charAt(i);
            if(ch >='0' && ch <='9')
            {
                while(i < infix.length() && (ch = infix.charAt(i))>='0' && ch <='9')
                {
                    postfix.append(ch+"");
                    i++;
                }
                postfix.append(" ");
            }
            else
            {
                switch (ch)
                {
                    case ' ':i++; break;
                    case '(':stack.push(ch+"");i++;break;
                    case ')':String out = "";
                    while((out =stack.pop()) != null && !out.equals("(")) {
                        postfix.append(out);
                    }
                    i++;break;
                    default:while(!stack.isEmpty() && !stack.peek().equals("(") && operators.compare(ch+"", stack.peek())>=0)
                    {
                        postfix.append(stack.pop());
                    }
                    stack.push(ch+"");
                    i++;
                }
            }
        }
        while(!stack.isEmpty())
        {
            postfix.append(stack.pop());
        }

        return postfix;

    }
    private int toValue(StringBuffer postfix) {
        Stack<Integer> stack = new LinkedStack<Integer>();
        int value = 0;
        for(int i=0; i<postfix.length(); i++)
        {
            char ch = postfix.charAt(i);
            if(ch>='0' && ch<='9')
            {
                value = 0;
                while(ch>='0' && ch<='9')
                {
                    value = value * 10 + ch -'0';
                    ch = postfix.charAt(++i);
                }
                stack.push(value);
            }
            else
            {
                if(ch != ' ')
                {
                    int y = stack.pop() ,x = stack.pop();
                    value = operators.operate(x,y,ch+"");
                    System.out.print(x+(ch+"")+y+"="+value+",");
                    stack.push(value);
                }
            }
        }
        return stack.pop();
    }
    public static void main(String[] args) {
    String infix = "123+20*(3|12^15&4+6)/((35-20)%10+5)-11";
    new ArithExpression(infix);
    }

}
