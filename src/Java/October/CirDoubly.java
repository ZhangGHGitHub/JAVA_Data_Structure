package Java.October;

/**
 * @author: 张国豪
 * @date: 2020/10/15 19:14
 * FileName: CirDoubly
 * @version: 1.0
 * Description: 循环双链表
 */
public class CirDoubly<T> extends DoubleNode<T>{
    public DoubleNode<T> head;
    public CirDoubly()
    {
        this.head = new DoubleNode<>();
        this.head.prev = this.head;
        this.head.next = this.head;
    }
    public boolean isEmpty()
    {
        return this.head.next == this.head;
    }
    public T remove(int i)
    {
        int j=0;
        if(i >= 0 )
        {
            DoubleNode ybkc =this.head;
            while(ybkc.next !=null)
            {
                if(j==i)
                {
                    T x = (T) ybkc.data;
                   ybkc.prev.next=ybkc.next;
                   ybkc.next.prev=ybkc.prev;
                   return x;
                }
                else {
                    ybkc = ybkc.next;
                    i++;
                }
            }
        }
        return null;
    }
//    public String toPreviousString()
//    {
//
//    }







}
