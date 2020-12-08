package Java.October;

/**
 * @author: �Ź���
 * @date: 2020/10/9 15:29
 * FileName: SeqList
 * @version: 1.0
 * Description: SeqList
 */

public class SeqList<T> extends Object{
    int n;
    Object [] element;
    static final int MIN_CAPACITY = 16;

    public SeqList()
    {
        this(MIN_CAPACITY);
    }
    public SeqList(int length)
    {
        if(length<MIN_CAPACITY)
        {
            length = MIN_CAPACITY;
        }
        this.element = new Object[length];
        this.n = 0;
    }
    public SeqList(T[] values)			
    {
        this(values.length*2);
        for(int i = 0; i < values.length; i++) {
            if(values[i] != null) {
                this.element[this.n++] = values[i];
            }
        }
    }
    public boolean isEmpty()
    {
        return this.n == 0;
    }
    public int size()
    {
        return this.n;
    }
    public T get(int i)
    {
        if(i>=0 && i<this.n)
        {
            System.out.println(i);
            return (T)this.element[i];
        }
        return null;
    }
    public void set(int i,T x)
    {
        if(x==null) {
            throw new NullPointerException("x==null");
        }
        if(i>=0 && i<this.n) {
            this.element[i] = x;
        } else {
            throw new IndexOutOfBoundsException("????��??("+i+")??????(?��????)");
        }
    }
    @Override
    public String toString()
    {
        String str = this.getClass().getName()+"(";
        if(this.n>0) {
            str += this.element[0].toString();
        }
        for(int i=1;i<this.n;i++) {
            str +=" ,"+this.element[i].toString();
        }
        return str+")";
    }
    public int insert(int i, T x)
    {
        if(x == null){
            return -1;}
        if(i<0){
            i = 0;}
        if(i>this.n){
            i = this.n;}
        Object [] source = this.element ;
        if(this.n == element.length)
        {
            this.element = new Object[source.length * 2];
            for(int j = 0; i < i; j++) {
                this.element[j] = source[j];
            }
        }
        for(int j  = this.n-1; j >=i; j--)
        {this.element[j+1] = source[j];}
        this.element[i] = x;
        this.n ++;
        return i;
    }
    public int insert(T x)
    {
        return this.insert(this.n, x);
    }
    public T remove(int i)		//???????��?
    {
        if(i >= 0 && i < this.n)
        {
            T x = (T)this.element[i];
            for(int j  = i; j < this.n-1; j++)
            { this.element[j] = this.element[j+1];}
            this.element[this.n-1] = null;
            this.n--;
            return x;
        }
        return null;
    }
    public void clear(){
        //this.element = null;
        this.n = 0;
    }
    public int search(T key)
    {
        for(int i = 0; i < this.n; i++) {
            if (key.equals(this.element[i]))
            { return i;}
        }
        return -1;
    }
    public T remove(T key)
    {
        return this.remove(this.search(key));
//		for(int i = 0; i < this.n; i++)	//???????????
//		{
//			if(key.equals(this.element[i]))
//			{
//				T x = (T)this.element[i];
//				for(int j  = i; j < this.n-1; j++)
//					this.element[j] = this.element[j+1];
//				this.element[this.n-1] = null;
//				//System.out.println(this.element.toString());
//				this.n--;
//			}
//		}
//		return null;
    }

    @Override
    public boolean equals (Object obj)
    {
        return this == obj;
    }

    public static void main(String[] args) {
        String[] values = {"A", "B" ,"C" ,"D" ,"E"};
        SeqList<String> lista = new SeqList<String>(values);
        System.out.println(lista.toString());
        //lista.remove("A");
        System.out.println(lista.get(0));

        //SeqList<Integer> list1 = new SeqList<Integer>();
//		Integer [] array = {1,2,3,4,5};
//		SeqList<Integer> arraylist = new SeqList<Integer>(array);
//		System.out.println(arraylist.toString());
//		System.out.println(arraylist.remove(1));
//		System.out.println(arraylist.toString());
    }

}
