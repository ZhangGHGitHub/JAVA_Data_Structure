package Java.October;

/**
 * @author: 张国豪
 * @date: 2020/10/13 10:57
 * FileName: DoubleNode
 * @version: 1.0
 * Description: 双链表
 */
public class DoubleNode<T>{
    public T data;
    public DoubleNode<T> prev,next;
    public DoubleNode(T data, DoubleNode<T> prev, DoubleNode<T> next)
    {
        this.data = data;
        this.prev = prev;
        this.next = next;
    }
    public DoubleNode(){
        this(null, null,null);
    }
    @Override
    public String toString() {

        return "DoubleNode{" +
                "data=" + data +
                ", prev=" + prev +
                ", next=" + next +
                '}';
    }
}
