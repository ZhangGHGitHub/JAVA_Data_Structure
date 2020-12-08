package Java.October;

/**
 * @author: 张国豪
 * @date: 2020/10/16 14:19
 * FileName: SewStack
 * @version: 1.0
 * Description: 顺序栈
 */
public final class SeqStack<T> implements Stack<T>
{
    private SeqList<T> list ;
    public SeqStack(int length)
    {
        this.list = new SeqList<T>(length);
    }
    public SeqStack()
    {
        this(64);
    }
    @Override
    public boolean isEmpty() {
        return this.list.isEmpty();
    }

    @Override
    public void push(T x) {
    this.list.insert(x);
    }

    @Override
    public T peek() {
        return this.list.get(list.size()-1);
    }

    @Override
    public T pop() {
        return list.remove(list.size()-1);
    }

    @Override
    public String toString() {
        return "SeqStack{" +
                "list=" + list +
                '}';
    }

    /**反向输出顺序栈，*/
//    public String toPreviousString()
//    {
//
//    }
}
