package Java.October;

import java.util.Arrays;

/**
 * @author: 张国豪
 * @date: 2020/10/20 11:06
 * FileName: SeqQueue
 * @version: 1.0
 * Description: 顺序循环队列类
 */
public class SeqQueue <T> implements Queue<T>{
    private Object element[];
    private int front ,rear;
    private static final int MIN_CAPCITY = 16;
    public SeqQueue(int length)
    {
        if(length<MIN_CAPCITY)
        {
            length = MIN_CAPCITY;
        }
        this.element = new Object[length];
        this.front = this.rear = 0;
    }

    public SeqQueue()
    {
        this(MIN_CAPCITY);
    }

    @Override
    public boolean isEmpty() {
        return this.front == this.rear;
    }

    @Override
    public boolean add(T x) {
        if(x == null)
        {
            return false;
        }
        if(this.front == (this.rear+1)%this.element.length)
        {
            Object [] temp = this.element;
            this.element = new Object[temp.length*2];
            int j = 0;
            for(int i=this.front; i!=this.rear; i=(i+1)%temp.length)
            {
                this.element[j++] = temp[i];
            }
            this.front = 0;
            this.rear = j;
        }
        this.element[this.rear] = x;
        this.rear =(this.rear+1)%this.element.length;
        return true;
    }

    @Override
    public T peek() {
        return this.isEmpty() ? null : (T)this.element[this.front];
    }

    @Override
    public T poll() {
        if(this.isEmpty()) {
            return null;
        }
        T temp = (T)this.element[this.front];
        this.front = (this.front+1) % this.element.length;
        return temp;
    }

    @Override
        public String toString() {
            return "SeqQueue{" +
                    "element=" + Arrays.toString(element) +
                    ", front=" + front +
                    ", rear=" + rear +
                    '}';
    }
}
