package Java.October;

/**
 * @author: 张国豪
 * @date: 2020/11/3 10:44
 * FileName: BinaryTree
 * @version: 1.0
 * Description:二叉树
 */
public class BinaryTree<T> implements BinaryTTree{

    public BinaryNode<T>  root;
    private int i=0;
    public BinaryNode<T> create (T [] prelist)
    {
        BinaryNode<T> p = null;
        if(i<prelist.length)
        {
            T elem = prelist[i++];
            if(elem != null)
            {
                p = new BinaryNode<T>(elem);
                p.left = create(prelist);
                p.right = create(prelist);
            }
        }
        return p;
    }
    public BinaryTree()
    {
        root = null;
    }
    public BinaryTree(T date)
    {
        root = new BinaryNode<T>(date);
    }
    public BinaryTree(T[] prelist)
    {
        this.root = create(prelist);

    }
    @Override
    public boolean isEmpty() {
        return this.root == null;
    }

    @Override
    public <T> void insert(T x)
    {
        if(x !=null) {
            BinaryNode root = new BinaryNode<T>(x, (BinaryNode<T>) this.root,null);
        }
    }

    @Override
    public <T> BinaryNode<T> insert(BinaryNode<T> p, T x, boolean left) {
       if( x == null || p == null)
       {
           return null;
       }
       if(left)
       {
           return p.left = new BinaryNode<>(x, p.left, null);
       }
       return p.right = new BinaryNode<>(x ,null , p.right);
    }


    @Override
    public <T> void remove(BinaryNode<T> p, boolean left) {
        if(p != null)
        {
            if(left)
            {
                p.left = null;
            }
            else
            {
                p.right = null;
            }
        }
    }

    @Override
    public void clear() {
    this.root = null;
    }

    @Override
    public void preorder() {
    preorder(this.root);
    System.out.println();
    }

    public void preorder(BinaryNode<T> p)
    {
        if(p!=null)
        {
            System.out.println(p.data.toString()+" ");
            preorder(p.left);
            preorder(p.right);
        }
    }

    @Override
    public void inorder() {
    inorder(this.root);
        System.out.println();
    }

    public void inorder(BinaryNode<T> p)
    {
        if(p!=null)
        {
            inorder(p.left);
            System.out.println(p.data.toString()+" ");
            inorder(p.right);
        }
    }

    @Override
    public void postorder()
    {
        postorder(this.root);
        System.out.println();
    }
    public void postorder(BinaryNode<T> p)
    {
        if(p!=null)
        {
            postorder(p.left);
            postorder(p.right);
            System.out.println(p.data.toString()+" ");
        }
    }

    /**层次遍历**/
    @Override
    public void levelorder() {
        if(this.root == null)
        {return ;}
        Queue<BinaryNode<T>> que =  new LinkedQueue<BinaryNode<T>>();
        que.add(this.root);
        while(!que.isEmpty())
        {
            BinaryNode<T> p = que.poll();
            System.out.println(p.data + " ");
            if(p.left != null) {
                que.add(p.left);
            }
            if(p.right != null) {
                que.add(p.right);
            }
        }
        System.out.println();
    }

    /** 节点数量*/
    @Override
    public <T>int size(BinaryNode<T> p) {
       if(p == null)
       {
           return 0;
       }
       return 1 + size (p.left) + size(p.right);
    }
    public <T> int size()
    {
        return size(this.root);
    }
    /**叶子节点数量*/
    public int leafSize(BinaryNode<T> p)
    {
        if(p == null)
        {
            return 0;
        }
        if(p.left == null && p.right == null)
        {
            return 1;
        }
        return leafSize(p.left)+leafSize(p.right);
    }
    public int leafSize()
    {
        return leafSize(this.root);
    }

    @Override
    public int height() {
        return height(this.root);
    }
    public int height(BinaryNode<T> p)
    {
        if(p == null)
        {
            return 0;
        }
        int lh = height(p.left);
        int rh = height(p.right);
        return Math.max(lh,rh)+1;
    }

    // 先根次序遍历查找首个关键字为key结点
    @Override
    public <T> BinaryNode search(T key) {
       return  search(key, (BinaryNode<T>) this.root);
    }
    private <T>BinaryNode search(T key,BinaryNode<T> node)
    {
        if(node==null || key == null)//如果为空，终止
        {
            //System.out.println(1);
            return null;
        }
        if(key.equals(node.getData()))
        {
            System.out.println(key+node.getData().toString());
            return node;
        }

        BinaryNode<T> find=search(key,node.getLeft());
        if(find == null) {
            search(key, node.getRight());
        }
        return find;
    }

    @Override
    public <T> int level(T key) {
        return(level(key, (BinaryNode<T>)this.root));
    }
    // 返回key结点所在的层次
    public <T>int level(T key,BinaryNode<T> node)
    {
        int l1,r1;
        if(node==null) {
            return 0;
        }
        if(node.getData().equals(key))//当找到相同的，终止
        {
            return 1;
        } else
        {
            l1 = level(key,node.getLeft());
            r1 = level(key,node.getRight());
            if(l1!=0) {
                return l1+1;
            } else if(r1!=0) {
                return r1+1;
            } else {
                return 0;
            }


        }

    }
    @Override
    public <T> void remove(T key) {

    }


    @Override
    public String toString() {
        return this.toString(this.root);
    }

    private String toString(BinaryNode<T> parent) {
        if (parent == null) {
            return "^";
        }
        return parent.getData().toString() + " " + toString(parent.getLeft()) + " " + toString(parent.getRight());
    }

    public static void main(String[] args) {
    String [] prelist = {"A","B","D",null,"G",null,null,null,"C","E",null,null,"F","H"};
    BinaryTree<String> bitree = new BinaryTree<String>(prelist);
    System.out.println("先根次序遍历二叉树：" );
        System.out.println(bitree.toString());
//    System.out.println("中根次序遍历二叉树：");
//    bitree.inorder();
//    System.out.println("后根次序遍历二叉树：");
//    bitree.postorder();
//    bitree.insert(bitree.root.left,"X", true);
//    bitree.insert(bitree.root.right,"Y", false);
//    bitree.insert("Z");
//        System.out.println("先根次序遍历二叉树：" );
//        bitree.preorder();
        System.out.println(bitree.search("F"));
        System.out.println(bitree.toString());

    }
}
