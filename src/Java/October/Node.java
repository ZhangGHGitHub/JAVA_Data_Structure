package Java.October;
/**
 * @author: 张国豪
 * @date: 2020/10/9 15:28
 * FileName: Node
 * @version: 1.0
 * Description: Node
 */
import java.util.*;
import java.awt.*;
import java.lang.*;
public class Node<T> {

    public T data;
    public Node<T> next;

    public Node (T data, Node<T> next)
    {
        this.data = data;
        this.next = next;
    }
    public Node()
    {
        this(null, null);
    }
    @Override
    public String toString()
    {
        return this.data.toString();
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Node <String> p,q,r;
        p = new Node<String>("A",null);
        q = new Node<String>("B",null);
        // p.next(q);
    }


}
