package Java.October;

/**
 * @author: 张国豪
 * @date: 2020/11/6 15:26
 * FileName: TriElement
 * @version: 1.0
 * Description: 二叉树的静态三叉链表节点
 */
public class TriElement {
    public int data;
    public int parent, left, right;
    public TriElement(int data, int parent, int left, int right)
    {
        this.data = data;
        this.parent = parent;
        this.left = left;
        this.right = right;
    }
    public TriElement(int data)
    {
        this.data = data;
        this.left = -1;
        this.right = -1;
        this.parent = -1;
    }

    @Override
    public String toString() {
        return "TriElement{" +
                "data=" + data +
                ", parent=" + parent +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
    public boolean isLeaf()
    {
        if(this.left == -1 && this.right == -1)
        {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        
    }
}

