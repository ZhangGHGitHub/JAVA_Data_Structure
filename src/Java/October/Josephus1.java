package Java.October;

/**
 * @author: 张国豪
 * @date: 2020/10/9 15:44
 * FileName: Josephus1
 * @version: 1.0
 * Description: Josephus1
 */
public class Josephus1 {
    public Josephus1(int n, int start ,int distance)
    {
        if(n <= 0 || start < 0 ||start >= n || distance <= 0 || distance >= n) {
            throw new IllegalArgumentException("n = "+ n + ", start = " + start + ", distance = " + distance);
        }
        System.out.println("Josephus(" + n +"," + start + "," + distance + "),");
        SeqList<String> list = new SeqList<String>(n);
        for(int i = 0; i < n; i++) {
            list.insert((char)('A'+i)+"");
        }
        System.out.println(list.toString());
        while(n > 1)
        {
            start = (start + distance -1) % n;
            System.out.println("ɾ��" + list.remove(start).toString() + ", " + list.toString());
            n=n-1;
        }
        System.out.print("����������" + list.get(0).toString());
    }
    public static void main(String[] args) {
        new Josephus1(5,1,3);
    }
}
