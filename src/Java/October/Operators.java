package Java.October;

/**
 * @author: 张国豪
 * @date: 2020/10/16 16:04
 * FileName: Operators
 * @version: 1.0
 * Description: 运算符集合类，包括算数和位运算符，约定每个运算符的优先级
 */
public  class Operators implements java.util.Comparator<String>{
    private String[] operator = {"*","/","%","+","-","&","^","|",};
    private int[] priority = {3,3,3,4,4,8,9,10};
    private SeqList<String> operlist;
    public Operators()
    {
        this.operlist = new SeqList<String>(this.operator);
    }
    @Override
    public int compare(String oper1, String oper2)
    {
        int i = operlist.search(oper1), j = operlist.search(oper2);
        return this.priority[i] - this.priority[j];
    }
    public int operate(int x, int y, String oper)
    {
        int value = 0;
        switch (oper)
        {
            case "+":value = x + y;break;
            case "-":value = x - y;break;
            case "*":value = x * y;break;
            case "/":value = x / y;break;
            case "%":value = x % y;break;
            case "&":value = x & y;break;
            case "^":value = x ^ y;break;
            case "|":value = x | y;break;
        }
        return value;
    }

}
