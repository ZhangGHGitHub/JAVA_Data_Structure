package Java.October;

import org.omg.CORBA.OMGVMCID;

/**
 * @author: 张国豪
 * @date: 2020/11/6 15:32
 * FileName: HuffmanTree
 * @version: 1.0
 * Description: Huffman树
 */
public class HuffmanTree {
    private String charset;
    private TriElement [] elements;
    public  HuffmanTree(int [] weight)
    {
        this.charset = "";
        int n = weight.length;
        for(int i=0; i<weight.length;i++)
        {
            this.charset += (char)('A'+i);
        }
        this.elements = new TriElement[2*n-1];
        for(int i=0; i<n; i++)
        {
            this.elements[i] = new TriElement(weight[i]);
        }
        for(int i=n; i<2*n-1; i++)
        {
            int min1 = Integer.MIN_VALUE,min2=min1;
            int x1=-1, x2=-1;
            for(int j=0; j<i; j++)
            {
                if(this.elements[j].parent == -1)
                {
                    if(this.elements[j].data<min1)
                    {
                        min2 = min1;
                        x2 = x1;
                        min1 = this.elements[j].data;
                        x1 = j;
                    }
                    else if(this.elements[j].data<min2)
                    {
                        min2 = elements[j].data;
                        x2 = j;
                    }
                }
            }
            this.elements[x1].parent = i;
            this.elements[x2].parent = i;
            this.elements[i] = new TriElement(min1+min2, -1, x1, x2);
        }
    }
    private String huffmanCode(int i)
    {
        int n = 8;
        char code[] = new char[n];
        int child = i, parent = this.elements[child].parent;
        for(i = n-1;parent !=-1;i--)
        {
            code[i] = (elements[parent].left == child) ? '0' : '1';
            child = parent;
            parent = elements[child].parent;
        }
        return new String(code,i+1,n-1-i);
    }
    @Override
    public String toString()
    {
        String str="Huffman树的节点数组";
        for(int i = 0; i<this.elements.length; i++)
        {
            str += this.elements[i].toString()+",";
        }
        str += "\nHuffman编码：";
        for(int i = 0; i<this.charset.length(); i++)
        {
            str+= this.charset.charAt(i)+":"+huffmanCode(i)+",";
        }
        return str;
    }

    public String encode(String text)
    {
        String compressed = "";
        for(int i = 0; i<text.length(); i++)
        {
            int j =text.charAt(i) - 'A';
            compressed += this.huffmanCode(j);
        }
        return compressed;
    }

    public String deode(String compressed)
    {
        String text = "";
        int node = this.elements.length-1;
        for(int i=0; i<compressed.length(); i++)
        {
            if(compressed.charAt(i) == '0')
            {
                node  = elements[node].left;
            }else{
                node = elements[node].right;
            }
            if(elements[node].isLeaf())
            {
                text += this.charset.charAt(node);
                node = this.elements.length-1;
            }
        }
        return text;
    }

    public static void main(String[] args) {
        String text = "AAAABBBCDDBBAAA";
        int [] weights = {7,5,1,2};
        HuffmanTree huftree = new HuffmanTree(weights);
        System.out.println(huftree.toString());
        String compressed = huftree.encode(text);
        System.out.println("将"+text+"压缩为"+compressed+","+compressed.length()+"位");
        System.out.println("将"+compressed+"解码为"+huftree.deode(compressed));

    }
}
