package Java.October;

/**
 * @author: 张国豪
 * @date: 2020/10/9 15:45
 * FileName: SinglyList
 * @version: 1.0
 * Description: SinglyList
 */

import java.lang.*;
import java.util.Stack;

public class SinglyList<T extends Comparable> extends Object{
    public Node<T> head;
    public SinglyList()
    {
        this.head = new Node<T>();
    }
    public SinglyList(T[] values)
    {
        this();
        Node<T> rear = this.head;
        for(int i=0; i<values.length; i++)
        {
            if(values[i] != null)
            {
                rear.next = new Node<T>(values[i], null);
                rear = rear.next;
            }
        }
    }
    public boolean isEmpty()
    {
        return this.head.next == null;
    }
    public T get(int i)
    {
        Node<T> p = this.head.next;
        for(int j = 0; p!=null && j<i; j++)
        {
            p = p.next;
        }
        /**
         * i可以等于0，获取第0个的元素
         *
         * **/
        return(i>=0 && p!=null) ? p.data :null;
    }
    public void set(int i, T x)
    {
        if(0<=i && i<this.size() && x!=null)
        {
            Node<T> p = this.head.next;
            for(int j = 0; p!=null && x!=null;j++) {
                if(j==i) {
                    p.data = x;
                }
                p = p.next;
            }
        }
    }
    public int size()
    {
        Node<T> p = this.head.next;
        int size = 0;
        for(int j = 0; p != null ;j++)
        {
            p = p.next;
            size++;
        }
        return size;
    }
    @Override
    public String toString()
    {
        String str = this.getClass().getName()+"(";
        for(Node<T> p = this.head.next; p!=null; p = p.next) {
            str += p.data.toString() + (p.next != null ? "," : "");
        }
        return str +=")";
    }
    public Node<T> insert(int i, T x)
    {
        if(x == null) {
            return null;
        }
        Node<T> front = this.head;
        for(int j = 0; front.next !=null && j<i; j++) {
            front = front.next;
        }
        front.next = new Node<T>(x, front.next);
        /*
         * Node<T> p = new Node<T>(x,null);
         * p.next = front.next;
         * front.next = p.next;
         *
         * */
        return front.next;
    }
    public Node<T> insert(T x)
    {
        return insert(Integer.MAX_VALUE,x);
    }
    	public T remove(int i)
	{
		Node<T> front = this.head;
		for(int j = 0; front.next!=null && j<i; j++) {
            front = front.next;
        }
		System.out.println(front.next);
		if(i >= 0 && front.next != null)
		{
			T x = front.next.data;
			front.next = front.next.next;
			return x;
		}
		return null;
	}
    public void clear()
    {
        this.head.next = null;
    }
    public Node<T> search(T key)
    {
//		Node<T> p = this.head.next;
//		for(;p.next.data.equals(key);p = p.next)
//		{
//			if(p.data==key)
//				return p;
//
//		}
//	-----------------------------------------
//		Node<T> front = this.head.next;
//		while(front!=null)
//		{
//			if(front.data.equals(key))
//				return front;
//			front = front.next;
//		}

        Node<T> front = this.head.next;
        while(front.next!=null )
        {
            if(front.next.data.equals(key))
            {
                return front;
            }
            front = front.next;
        }
        return null;
    }
    public T remove(T key)
    {

//		while(!front.next.data.equals(key))
//			front = front.next;
//		if(front.next != null)
//		{
//			T x = front.next.data;
//			front.next = front.next.next;
//			return x;
//		}
        Node<T> front = this.search(key);
        if(front.next != null)
        {
            T x = front.next.data;
            front.next = front.next.next;
            return x;
        }
        return null;
    }
    /**
     ** 逆转单链表
     */
    public static <T extends Comparable> void Reverse(SinglyList<T> list)
    {
        Node<T> p = list.head.next,q = null,front = null;
        /** Node<T> front = null; 前驱结点
         *  Node<T> p = this.head.next; 当前节点
         *  Node<T> q = null;   后继节点
         */
        while(p!=null){
            //设置q是p结点的后继结点,即用q来保持p的后继结点
            q = p.next;
            //逆转,即使p.next指向p结点的前驱结点
            p.next = front;
            //front向后移一步
            front = p;
            //p向后移一步
            p = q;
            /**
             *             当前节点                    后结点，前结点
             * Node<T> p = this.head.next, q = null, front = null;
             * Node<T> front = null, p = this.head.next, q = null;
             * q是p的后继节点，用q来保持p的后继节点
             * q = p.next;
             * 逆转，使p.next指向p结点的前结点
             * p.next = front ;
             * front 后移一位
             * front = p;
             * p 后移一位
             * p = q;
             * **/


        }
        //head指向原链表的最后一个结点，完成逆转
        list.head.next = front;
       // System.out.println(this.toString());
    }
    public  SinglyList<T> merge(SinglyList list2)
    {
        Node<T> p,q,t,s;
        /**
         * @param
         * p是比较数p，t是list1的头结点,q是比较数q，s是比较数q的下一个
         * */
        p=this.head.next;
        t=this.head;
        q=list2.head.next;
        s=q.next;
        /**@param 如果为空，返回另一个单链表*/
        if(p == null )
        {
            return list2;
        }
        if(q == null)
        {
            return this;
        }
        while(p!=null&&q!=null )
        {
            if (p.data.compareTo(q.data)>0){
                q.next = p;
                t.next = q;
               // System.out.println(this.toString());
                t = p;
                p = p.next;
                q = s;
                if(s.next==null)
                {
                    q.next = p;
                    t.next = q;
                    break;
                }
                s = s.next;
            }else if(p.data.compareTo(q.data)<0){
                t = p;
                p = p.next;
                q.next = p;
                t.next = q;
                //System.out.println(.toString());
                //System.out.println(s.next.toString());
                if(s.next==null)
                {
                    p.next = s;
                    //System.out.println(this.toString());
                    break;
                }
                q = s;
                s = s.next;
            }else {
                t = p;
                p = p.next;
                q = s;
                s = s.next;
            }
        }
        return this;
    }
    public static void main(String[] args) {
        Integer[] array = {1,3,5,7,9};
        Integer[] array2 = {2,4,6,8,10};
        SinglyList<Integer> sl = new SinglyList<Integer>(array);
        SinglyList<Integer> sll = new SinglyList<Integer>(array2);
        System.out.println(sl.toString());
        System.out.println(sll.toString());
//		System.out.println(sl.remove(1));
//		System.out.println(sl.size());
//        System.out.println(sl.search(1));
//        System.out.println(sl.remove(1));
//        SinglyList.Reverse(sl);
//        System.out.println(sl.toString());
//        System.out.println(sl.get(0));
        System.out.println(sll.merge(sl).toString());

    }

}

