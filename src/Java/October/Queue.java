package Java.October;

/**
 * @author: 张国豪
 * @date: 2020/10/20 10:14
 * FileName: Queue
 * @version: 1.0
 * Description: 队列接口，描述队列抽象数据类型
 */
public interface Queue<T> {
    public abstract boolean isEmpty();

    public abstract boolean add(T x);

    public abstract T peek();
    public abstract T poll();
}
