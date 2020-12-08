package Java.October;

/**
 * @author: 张国豪
 * @date: 2020/10/23 14:33
 * FileName: fibonacci
 * @version: 1.0
 * Description: 斐波那契数列
 */
public class fibonacci {
    public static void main(String[] args) {
        SeqStack<Integer> stack = new SeqStack<Integer>();
        //压栈
        stack.push(1);
        stack.push(1);
        int k = 1;
        while(k < 11){
           // for (int i = 0; i <= 2 ; i++) {
                //弹栈
                int f1 = stack.pop();
                int f2 = stack.pop();
                int next = f1+f2;
                System.out.print(" " + next);
                stack.push(next);
                //后进先出
                stack.push(f2);
                k++;
            }
            //} 2 3 5 8 13 21 34 55 89 144 233 377
    }
}
