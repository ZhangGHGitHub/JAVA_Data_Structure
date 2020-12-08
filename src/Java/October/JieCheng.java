package Java.October;

/**
 * @author: 张国豪
 * @date: 2020/10/23 14:30
 * FileName: JieCheng
 * @version: 1.0
 * Description: 阶乘
 */
public class JieCheng {

   public static int jiecheng(int n)
    {
        if(n==0)
        {
            return 1;
        }
        else {
            return n*jiecheng(n-1);
        }
    }
    public static void main(String[] args) {
       System.out.println("5的阶乘是："+jiecheng(5));
    }
}