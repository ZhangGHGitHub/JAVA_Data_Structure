package Java.October;

import sun.reflect.generics.tree.VoidDescriptor;

/**
 * @author: ÕÅ¹úºÀ
 * @date: 2020/11/3 10:17
 * FileName: BinaryTTree
 * @version: 1.0
 * Description: ¶þ²æÊ÷
 */
public interface  BinaryTTree {
    public   boolean isEmpty();
    public   <T> void insert(T x);
    public   <T> BinaryNode<T> insert(BinaryNode<T> p, T x, boolean left);
    public   <T> void remove(BinaryNode<T> p, boolean left);
    public   void clear();
    public   void preorder();
    public   void inorder();
    public   void postorder();
    public   void levelorder();
    public   <T> int size(BinaryNode<T> p);
    public   int height();
    public   <T> BinaryNode<T> search(T key);
    public   <T> int level(T key);
    public   <T> void remove(T key);


}
