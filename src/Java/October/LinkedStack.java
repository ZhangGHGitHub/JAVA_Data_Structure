package Java.October;

/**
 * @author: 张国豪
 * @date: 2020/10/16 15:29
 * FileName: LinkedStack
 * @version: 1.0
 * Description: 链式栈
 */
public final class LinkedStack<T extends Comparable> implements Stack<T>{
     private SinglyList<T> list;
     public LinkedStack()
     {
         this.list = new SinglyList<T>();
     }
    @Override
    public boolean isEmpty() {
        return this.list.isEmpty();
    }

    @Override
    public void push(T x) {
    this.list.insert(0,x);
    }

    @Override
    public T peek() {
        return this.list.get(0);
    }

    @Override
    public T pop() {
        return this.list.remove(0);
    }

    @Override
    public String toString() {
        return "LinkedStack{" +
                "list=" + list +
                '}';
    }
}
