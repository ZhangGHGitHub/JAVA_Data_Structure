package Java.October;
/**
 * @author: �Ź���
 * @date: 2020/11/3 10:33
 * FileName: BinaryNode
 * @version: 1.0
 * Description: ��������ڵ�
 */
public class BinaryNode<T>{
    public  T data;
    public BinaryNode<T> left, right;

    public  BinaryNode()
    {
        this.data = null;
        this.left = null;
        this.right = null;
    }

    public BinaryNode(T data)
    {
        this.data = data;
        this.left = null;
        this.right = null;
    }
    public  BinaryNode(T data, BinaryNode<T>  left, BinaryNode<T> right)
    {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public BinaryNode<T> getLeft() {
        return left;
    }

    public void setLeft(BinaryNode<T> left) {
        this.left = left;
    }

    public BinaryNode<T> getRight() {
        return right;
    }

    public void setRight(BinaryNode<T> right) {
        this.right = right;
    }

    @Override
    public String toString()
    {
        return "data"+this.data;
    }
    public boolean isLeaf()
    {
        if(this.left == null && this.right == null) {
            return true;
        } else {
            return false;
        }
    }

}
