package Java.October;

/**
 * @author: 张国豪
 * @date: 2020/10/16 14:03
 * FileName: Stack
 * @version: 1.0
 * Description: Stack
 */
public interface Stack<T> {
    /**@param 判空*/
public abstract boolean isEmpty();
public abstract void push(T x);
public abstract T peek();
public abstract T pop();

}
