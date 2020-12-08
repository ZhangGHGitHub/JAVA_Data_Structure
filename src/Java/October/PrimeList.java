package Java.October;
/**
 * @author: 张国豪
 * @date: 2020/9/1 12:53
 * FileName: PrimeList
 * @version: 1.0
 * Description: 素数线性表（升序）
 */
public class PrimeList {
    private int  range;
    private SinglyList<Integer> list;
    public PrimeList(int range)
    {
        if(range<=1)
        {
            throw new IllegalArgumentException("range="+range);
        }
        this.range = range;
        this.list = new SinglyList<Integer>();
        this.list.insert(2);
        Node<Integer> rear = this.list.head.next;
        for(int key = 3; key <= range; key+=2)
        {
            if(this.isPrime(key))
            {
                rear.next = new Node<Integer>(key,null);
                rear = rear.next;
            }
        }
    }
    public boolean isPrime(int key)
    {
        if(key <= 1)
        {
            throw new java.lang.IllegalArgumentException("key=" + key);
        }
        int sqrt = (int)Math.sqrt(key);
        for(Node<Integer> p = this.list.head.next; p != null && p.data <= sqrt; p = p.next)
        {
            if(key % p.data == 0)
            {
                return false;
            }
        }
      return true;
    }
    @Override
    public String toString()
    {
        return "2~" + range + "素数的集合:" + list.toString() + "," +list.size() + "个元数";
    }
    public static void main(String []args)
    {
        System.out.println(new PrimeList(100).toString());
    }
}
